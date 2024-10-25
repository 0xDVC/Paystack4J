package com.dvc.paystack4j.common;

public class RequestExecutor {
    private static String secretKey;



    public static void setKey(String secretKey) {
        RequestExecutor.secretKey = secretKey;
    }
}
