package mocking.service.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpMethod;

import java.util.Map;

@Getter
@Setter
@ToString
public class DynamicRequestEntity {

    private MockingType type;
    private HttpMethod method;
    private String url;
    private Map<String, String> params;
    private String body;

    public enum MockingType {
        GET, SET
    }
}
