package mocking.service.controller;

import com.google.gson.JsonObject;
import lombok.extern.slf4j.Slf4j;
import mocking.service.entity.DefaultResponse;
import mocking.service.entity.SetupRequestEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@RestController
@Slf4j
public class EntryController implements HttpController<HttpServletRequest> {

    @Autowired
    private RequestController requestController;

    @Autowired
    private SetupController setupController;

    @RequestMapping("/**")
    public JsonObject handle(HttpServletRequest request) {
        Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            log.info("{}: {}", header, request.getHeader(header));
        }

        String servletPath = request.getServletPath();
        if (!StringUtils.isEmpty(servletPath)) {
            if (servletPath.startsWith("/_setup")) {
                if ("POST".equals(request.getMethod())) {
                    try {
                        return setupController.handle(SetupRequestEntity.fromServletRequest(request));
                    } catch (Exception e) {
                        log.info("Error when handle setupController", e);
                        return DefaultResponse.errorResponseWithMessage(e.getMessage());
                    }
                } else {
                    return DefaultResponse.errorResponseWithMessage("Setup request require using POST method");
                }
            } else {
                return requestController.handle(request);
            }
        } else {
            return DefaultResponse.errorResponseWithMessage("Invalid servlet path");
        }
    }
}
