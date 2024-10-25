package com.dvc.paystack4j.common;

import com.dvc.paystack4j.exceptions.APIException;
import kong.unirest.JsonNode;
import kong.unirest.UnirestException;
import kong.unirest.HttpResponse;
import kong.unirest.HttpRequest;
import org.json.JSONObject;
import org.json.JSONException;

public class RequestExecutor {
    private static String secretKey;



    public static void setKey(String secretKey) {
        RequestExecutor.secretKey = secretKey;
    }

    /**
     * Executes a Unirest request and returns the response as JSONObject
     *
     * @param requestBuilder Partially built Unirest request
     * @return JSONObject containing API response
     */
    @SuppressWarnings("unchecked")
    private JSONObject executeRequest(HttpRequest<?> requestBuilder) throws APIException {
        if (secretKey == null || secretKey.trim().isEmpty()) {
            throw new APIException("API secret key cannot be null or empty");
        }

        try {
            HttpResponse<JsonNode> response = (HttpResponse<JsonNode>) requestBuilder
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + secretKey)
                    .asJson();

            if (response.getStatus() >= 400) {
                throw new APIException("Request failed with status " + response.getStatus() +
                        ": " + response.getStatusText());
            }

            if (response.getBody() == null) {
                throw new APIException("Received empty response body");
            }

            return new JSONObject(response.getBody().toString());

        } catch (UnirestException e) {
            throw new APIException("Network or request error: " + e.getMessage(), e);
        } catch (JSONException e) {
            throw new APIException("Failed to parse JSON response: " + e.getMessage(), e);
        }
    }
}
