package mocking.service.controller;

import com.google.gson.JsonObject;

public interface HttpController<T> {
    JsonObject handle(T request);
}
