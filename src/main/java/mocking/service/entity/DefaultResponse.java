package mocking.service.entity;

import com.google.gson.JsonObject;

public class DefaultResponse {

    public static final JsonObject RESPONSE_OK = new JsonObject();
    public static final JsonObject RESPONSE_ERROR = new JsonObject();

    static {
        RESPONSE_OK.addProperty("status", "OK");
        RESPONSE_ERROR.addProperty("status", "ERROR");
    }

    private DefaultResponse() {
    }

    public static JsonObject errorResponseWithMessage(String message) {
        JsonObject result = RESPONSE_ERROR.deepCopy();
        result.addProperty("message", message);
        return result;
    }
}
