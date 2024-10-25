package com.dvc.paystack4j.common;

import kong.unirest.HttpRequest;
import kong.unirest.Unirest;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * A utility class for building Unirest HTTP requests.
 */
public class RequestBuilder {
    private String baseUrl;
    private final Map<String, Object> params;

    public RequestBuilder(String baseUrl) {
        this.baseUrl = baseUrl;
        this.params = new HashMap<>();
    }

    /**
     * Adds a parameter to the request
     * @param key Parameter key
     * @param value Parameter value
     * @return The builder instance for chaining
     */
    public RequestBuilder addParameter(String key, Object value) {
        this.params.put(key, value);
        return this;
    }

    /**
     * Adds multiple parameters to the request
     * @param parameters Map of parameters to add
     * @return The builder instance for chaining
     */
    public RequestBuilder addParameters(Map<String, Object> parameters) {
        this.params.putAll(parameters);
        return this;
    }

    /**
     * Clears all parameters
     * @return The builder instance for chaining
     */
    public RequestBuilder clearParameters() {
        this.params.clear();
        return this;
    }

    /**
     * Gets the current parameters
     * @return Map of current parameters
     */
    public Map<String, Object> getParameters() {
        return new HashMap<>(params);
    }

    /**
     * Builds a GET request with the base URL
     * @return The HTTP request object
     */
    public HttpRequest<?> buildGetRequest() {
        return Unirest.get(baseUrl)
                .queryString(params);
    }

    /**
     * Builds a GET request with the base URL and an ID
     * @param id The ID of the resource
     * @return The HTTP request object
     */
    public HttpRequest<?> buildGetRequest(String id) {
        return Unirest.get(baseUrl + "/" + id)
                .queryString(params);
    }

    /**
     * Builds a POST request with the current parameters as form fields
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPostRequest() {
        return Unirest.post(baseUrl)
                .fields(params);
    }

    /**
     * Builds a POST request with a JSON body
     * @param body The request body as JSONObject
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPostRequest(JSONObject body) {
        return Unirest.post(baseUrl)
                .header("Content-Type", "application/json")
                .queryString(params)  // Parameters as query string for POST with JSON body
                .body(body);
    }

    /**
     * Builds a PUT request using current parameters as form fields
     * @param id The ID of the resource
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPutRequest(String id) {
        return Unirest.put(baseUrl + "/" + id)
                .fields(params);
    }

    /**
     * Builds a PUT request with a JSON body
     * @param id The ID of the resource
     * @param body The request body as JSONObject
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPutRequest(String id, JSONObject body) {
        return Unirest.put(baseUrl + "/" + id)
                .header("Content-Type", "application/json")
                .queryString(params)  // Parameters as query string for PUT with JSON body
                .body(body);
    }

    /**
     * Builds a PATCH request using current parameters as form fields
     * @param id The ID of the resource
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPatchRequest(String id) {
        return Unirest.patch(baseUrl + "/" + id)
                .fields(params);
    }

    /**
     * Builds a PATCH request with a JSON body
     * @param id The ID of the resource
     * @param body The request body as JSONObject
     * @return The HTTP request object
     */
    public HttpRequest<?> buildPatchRequest(String id, JSONObject body) {
        return Unirest.patch(baseUrl + "/" + id)
                .header("Content-Type", "application/json")
                .queryString(params)  // Parameters as query string for PATCH with JSON body
                .body(body);
    }

    /**
     * Builds a DELETE request
     * @param id The ID of the resource
     * @return The HTTP request object
     */
    public HttpRequest<?> buildDeleteRequest(String id) {
        return Unirest.delete(baseUrl + "/" + id)
                .queryString(params);
    }

    /**
     * Sets the base URL for the builder
     * @param baseUrl The base URL to set
     * @return The builder instance for chaining
     */
    public RequestBuilder setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    /**
     * Gets the current base URL
     * @return The current base URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }
}
