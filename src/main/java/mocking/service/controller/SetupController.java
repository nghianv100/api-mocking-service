package mocking.service.controller;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import mocking.service.entity.DefaultResponse;
import mocking.service.entity.SetupRequestEntity;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class SetupController implements HttpController<SetupRequestEntity> {

    @Override
    public JsonObject handle(SetupRequestEntity request) {
        log.info("{}", request.toString());
        return DefaultResponse.RESPONSE_OK;
    }

}
