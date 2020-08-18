package mocking.service.center;

import com.google.gson.JsonObject;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class DataMocking<T> {

    protected ConcurrentHashMap<String, T> args = new ConcurrentHashMap<>();
    protected JsonObject result = new JsonObject();

    public JsonObject getResult() {
        return result;
    }

    public void setResult(JsonObject result) {
        this.result = result;
    }

    public abstract boolean isMatch(Map<String, T> requestArgs);

}
