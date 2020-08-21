package mocking.service.entity;

import com.google.gson.JsonObject;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import mocking.service.utils.GsonUtils;
import mocking.service.utils.IOUtils;
import org.apache.commons.lang3.Validate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@ToString
public class SetupRequestEntity implements Comparable<SetupRequestEntity> {

    private Method _method;
    private String _path;
    private GrpcApi _api;
    private JsonObject _headers;
    private JsonObject _params;
    private JsonObject _request;
    private JsonObject _response;
    private int _latency;
    private int _order = -1;

    private static final List<String> HTTP_METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE");

    private SetupRequestEntity() {
    }

    public static SetupRequestEntity fromServletRequest(HttpServletRequest servletRequest) throws IOException {
        String servletRequestBody = IOUtils.readAsString(servletRequest.getReader());
        SetupRequestEntity requestEntity = GsonUtils.fromJson(servletRequestBody, SetupRequestEntity.class);
        Validate.notNull(requestEntity._method, "_method is required");
        Validate.notBlank(requestEntity._path, "_path is required");
        Validate.notNull(requestEntity._response, "_response is required");
        if (requestEntity._method == Method.GRPC && requestEntity._api == null)
            throw new IllegalArgumentException("_api is required for GRPC");
        requestEntity._latency = Math.max(requestEntity._latency, 0);
        return requestEntity;
    }

    @Override
    public int compareTo(SetupRequestEntity o) {
        return Integer.compare(this._order, o._order);
    }
}
