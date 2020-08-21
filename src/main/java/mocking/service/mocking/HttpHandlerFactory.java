package mocking.service.mocking;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

@Getter
@Setter
@ToString
@Slf4j
public class HttpHandlerFactory {

    private HttpGetHandler httpGetHandler = new HttpGetHandler();

    public JsonObject getMock(HttpServletRequest request) {
        return httpGetHandler.handle(request);
    }

    public JsonObject postMock(HttpServletRequest request) {
        return null;
    }

    public JsonObject putMock(HttpServletRequest request) {
        return null;
    }

    public JsonObject deleteMock(HttpServletRequest request) {
        return null;
    }

}
