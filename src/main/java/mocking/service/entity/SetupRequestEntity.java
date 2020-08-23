package mocking.service.entity;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
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
import java.util.Map;
import java.util.regex.Pattern;

@Getter
@Setter
@ToString
public class SetupRequestEntity implements Comparable<SetupRequestEntity> {

    private Method method;
    private String path;
    private GrpcApi api;
    private JsonObject headers;
    private JsonObject params;
    private JsonObject request;
    private JsonObject response;
    private int latency;
    private int order = -1;

    @Expose(serialize = false, deserialize = false)
    private Map<String, Pattern>


    private static final List<String> HTTP_METHODS = Arrays.asList("GET", "POST", "PUT", "DELETE");

    private SetupRequestEntity() {
    }

    public static SetupRequestEntity fromServletRequest(HttpServletRequest servletRequest) throws IOException {
        String servletRequestBody = IOUtils.readAsString(servletRequest.getReader());
        SetupRequestEntity requestEntity = GsonUtils.fromJson(servletRequestBody, SetupRequestEntity.class);
        Validate.notNull(requestEntity.method, "_method is required");
        Validate.notBlank(requestEntity.path, "_path is required");
        Validate.notNull(requestEntity.response, "_response is required");
        if (requestEntity.method == Method.GRPC && requestEntity.api == null)
            throw new IllegalArgumentException("_api is required for GRPC");
        requestEntity.latency = Math.max(requestEntity.latency, 0);
        requestEntity.order = Math.max(requestEntity.order, -1);
        return requestEntity;
    }

    @Override
    public int compareTo(SetupRequestEntity o) {
        return Integer.compare(this.order, o.order);
    }
}
