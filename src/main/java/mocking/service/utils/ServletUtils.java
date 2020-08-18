package mocking.service.utils;

import mocking.service.controller.DynamicRequestEntity;
import org.springframework.http.HttpMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ServletUtils {

    private ServletUtils() {
    }

    public static DynamicRequestEntity parseHttpServletRequest(HttpServletRequest request, DynamicRequestEntity.MockingType type) throws IOException {
        DynamicRequestEntity result = new DynamicRequestEntity();
        result.setType(type);
        result.setMethod(HttpMethod.resolve(request.getMethod().toUpperCase()));
        Map<String, String[]> requestParams = request.getParameterMap();
        if (requestParams != null)
            result.setParams(requestParams.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue()[0])));
        StringBuilder body = new StringBuilder();
        if (result.getMethod() == HttpMethod.POST) {
            try (Scanner scanner = new Scanner(request.getReader())) {
                while (scanner.hasNextLine())
                    body.append(scanner.nextLine());
                result.setBody(body.toString());
            }
        }
        String requestedUrl = request.getRequestURL().toString();
        switch (type) {
            case SET:
                result.setUrl(requestedUrl.substring(requestedUrl.indexOf("_set") + 4));
                break;
            case GET:
                result.setUrl(requestedUrl.substring(requestedUrl.indexOf("_get") + 4));
                break;
        }
        return result;
    }
}
