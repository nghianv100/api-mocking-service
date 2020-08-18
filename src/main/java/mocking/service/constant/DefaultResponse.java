package mocking.service.constant;

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
}
