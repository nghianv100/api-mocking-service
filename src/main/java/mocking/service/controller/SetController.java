package mocking.service.controller;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import mocking.service.utils.ServletUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/_set/**")
@Slf4j
public class SetController {

    @RequestMapping
    public JsonObject handle(HttpServletRequest request) {
        try {
            log.info(ServletUtils.parseHttpServletRequest(request, DynamicRequestEntity.MockingType.SET).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new JsonObject();
    }
}
