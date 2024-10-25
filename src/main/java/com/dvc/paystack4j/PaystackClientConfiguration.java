package com.dvc.paystack4j;

import com.dvc.paystack4j.config.KeyType;
import com.dvc.paystack4j.config.PaystackConfig;

/**
 * Factory class for creating Paystack API clients.
 * This class provides a simple interface for initializing a configured PaystackClient
 * while handling all the underlying configuration management automatically.
 */
final class PaystackClientConfiguration {
    /**
     * Creates and configures a new PaystackClient instance.
     *
     * <p>This method automatically handles the configuration loading process by:
     * <ul>
     *   <li>Searching for API keys in environment variables</li>
     *   <li>Checking system properties</li>
     *   <li>Looking for configuration files in the classpath and filesystem</li>
     * </ul>
     *
     * <p>Example usage:
     * <pre>{@code
     * PaystackClient client = PaystackClientConfiguration.buildClient(KeyType.LIVE);
     * }</pre>
     *
     * @param keyType The type of API key to use (LIVE or TEST)
     * @return A fully configured PaystackClient instance
     * @throws IllegalStateException if no valid API key configuration is found
     */
    public static PaystackClient buildClient(KeyType keyType) {
        return new PaystackClient.Impl(new PaystackConfig(keyType).getApiKey());
    }
}
