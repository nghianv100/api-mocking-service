package mocking.service.mocking;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import mocking.service.entity.Method;
import mocking.service.entity.SetupRequestEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Getter
@Setter
@ToString
@Slf4j
public class HttpHandlerFactory {

    private ConcurrentMap<Method, MockingHandler<HttpServletRequest, JsonObject>> httpHandlers = new ConcurrentHashMap<>();

    private HttpHandlerFactory() {
    }

    private HttpHandlerFactory(SetupRequestEntity setupEntity) {

    }

    public void putMockHandler(SetupRequestEntity setupEntity) {

    }
}
