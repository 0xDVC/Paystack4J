package com.dvc.paystack4j.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

public class PaystackConfig {
    private static final Logger log = LoggerFactory.getLogger(PaystackConfig.class);

    private static final String[] LIVE_ENV_KEYS = {
            "PAYSTACK_LIVE_SECRET_KEY",
            "paystack.live.secretKey",
    };

    private static final String[] TEST_ENV_KEYS = {
            "PAYSTACK_TEST_SECRET_KEY",
            "paystack.test.secretKey",
    };

    private static final String[] CONFIG_FILES = {
            "application.yml",
            "application.yaml",
            "application.properties",
            "paystack.yml",
            "paystack.yaml",
            "paystack.properties",
            ".env"
    };

    private final KeyType keyType;
    private final String[] ENV_KEYS;


    private String apiKey;

    public PaystackConfig(KeyType keyType) {
        this.keyType = keyType;
        this.ENV_KEYS = keyType == KeyType.LIVE ? LIVE_ENV_KEYS : TEST_ENV_KEYS;
        loadConfiguration();
    }

    private void loadConfiguration() {
        apiKey = findApiKey();

        if (apiKey == null || apiKey.isEmpty()) {
            log.error("No Paystack API key found in any configuration source");
            throw new IllegalStateException("No Paystack API key found in any configuration source");
        }
    }

    private String findApiKey() {
        String key = checkEnvironmentVariables();
        if (key != null) {
            log.info("Found Paystack API key in environment variables");
            return key;
        }

        key = checkSystemProperties();
        if (key != null) {
            log.info("Found Paystack API key in system properties");
            return key;
        }

        key = checkConfigurationFiles();
        if (key != null) {
            log.info("Found Paystack API key in configuration files");
            return key;
        }

        return null;
    }

    private String checkEnvironmentVariables() {
        for (String envKey : ENV_KEYS) {
            String value = System.getenv(envKey);
            if (value != null && !value.isEmpty()) {
                log.debug("Found API key in environment variable: {}", envKey);
                return value;
            }
        }
        log.debug("No API key found in environment variables");
        return null;
    }

    private String checkSystemProperties() {
        for (String propKey : ENV_KEYS) {
            String value = System.getProperty(propKey);
            if (value != null && !value.isEmpty()) {
                log.debug("Found API key in system property: {}", propKey);
                return value;
            }
        }
        log.debug("No API key found in system properties");
        return null;
    }

    private String checkConfigurationFiles() {
        for (String fileName : CONFIG_FILES) {
            String key = null;

            key = checkClasspathResource(fileName);
            if (key != null) {
                log.debug("Found API key in classpath resource: {}", fileName);
                return key;
            }

            key = checkFileInCurrentDirectory(fileName);
            if (key != null) {
                log.debug("Found API key in current directory: {}", fileName);
                return key;
            }

            key = checkFileInUserHome(fileName);
            if (key != null) {
                log.debug("Found API key in user home directory: {}", fileName);
                return key;
            }
        }
        log.debug("No API key found in any configuration files");
        return null;
    }

    private String checkClasspathResource(String fileName) {
        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName)) {
            if (is != null) {
                return extractKeyFromInputStream(is, fileName);
            }
        } catch (IOException e) {
            log.trace("Could not read {} from classpath: {}", fileName, e.getMessage());
        }
        return null;
    }

    private String checkFileInCurrentDirectory(String fileName) {
        Path path = Paths.get(fileName);
        if (Files.exists(path)) {
            try (InputStream is = Files.newInputStream(path)) {
                return extractKeyFromInputStream(is, fileName);
            } catch (IOException e) {
                log.trace("Could not read {} from current directory: {}", fileName, e.getMessage());
            }
        }
        return null;
    }

    private String checkFileInUserHome(String fileName) {
        Path path = Paths.get(System.getProperty("user.home"), fileName);
        if (Files.exists(path)) {
            try (InputStream is = Files.newInputStream(path)) {
                return extractKeyFromInputStream(is, fileName);
            } catch (IOException e) {
                log.trace("Could not read {} from user home directory: {}", fileName, e.getMessage());
            }
        }
        return null;
    }

    private String extractKeyFromInputStream(InputStream is, String fileName) throws IOException {
        if (fileName.endsWith(".yml") || fileName.endsWith(".yaml")) {
            return extractFromYaml(is);
        } else if (fileName.endsWith(".properties")) {
            return extractFromProperties(is);
        } else if (fileName.equals(".env")) {
            return extractFromEnvFile(is);
        }
        return null;
    }

    private String extractFromYaml(InputStream is) {
        try {
            Yaml yaml = new Yaml();
            Map<String, Object> data = yaml.load(is);
            return extractNestedValue(data, "paystack", "secretKey");
        } catch (Exception e) {
            log.trace("Error parsing YAML file: {}", e.getMessage());
            return null;
        }
    }

    private String extractFromProperties(InputStream is) throws IOException {
        try {
            Properties props = new Properties();
            props.load(is);
            return props.getProperty("paystack.secretKey");
        } catch (Exception e) {
            log.trace("Error parsing properties file: {}", e.getMessage());
            return null;
        }
    }

    private String extractFromEnvFile(InputStream is) throws IOException {
        try {
            Properties props = new Properties();
            props.load(is);
            return props.getProperty("PAYSTACK_SECRET_KEY");
        } catch (Exception e) {
            log.trace("Error parsing .env file: {}", e.getMessage());
            return null;
        }
    }

    private String extractNestedValue(Map<String, Object> map, String... keys) {
        Object current = map;
        for (String key : keys) {
            if (current instanceof Map) {
                current = ((Map<?, ?>) current).get(key);
            } else {
                return null;
            }
        }
        return current instanceof String ? (String) current : null;
    }

    public String getApiKey() {
        return apiKey;
    }
}
