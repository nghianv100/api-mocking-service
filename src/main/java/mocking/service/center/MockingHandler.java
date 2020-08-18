package mocking.service.center;

import com.google.gson.JsonObject;

public abstract class MockingHandler {

    protected JsonObject defaultResponse = new JsonObject();

    public void setDefaultResponse(JsonObject jsonObject) {
        defaultResponse = jsonObject;
    }

    public JsonObject getDefaultResponse() {
        return defaultResponse;
    }
}
