package mocking.service.controller;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import mocking.service.entity.DefaultResponse;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
@Slf4j
public class RequestController implements HttpController<HttpServletRequest> {

    @Override
    public JsonObject handle(HttpServletRequest request) {
        return DefaultResponse.RESPONSE_OK;
    }
}
