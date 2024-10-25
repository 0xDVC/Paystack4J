package com.dvc.paystack4j;

import com.dvc.paystack4j.config.KeyType;
import com.dvc.paystack4j.config.PaystackConfig;

final class PaystackClientConfiguration {

    public static PaystackClient buildClient(String keyType) {
        KeyType key = KeyType.valueOf(keyType);
        PaystackConfig config = new PaystackConfig(key);
        return new PaystackClient.Impl(config.getApiKey());
    }
}
