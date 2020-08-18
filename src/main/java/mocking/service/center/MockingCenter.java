package mocking.service.center;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

@Component
@Slf4j
public class MockingCenter {

    private ConcurrentHashMap<String, UrlHandler> ok;

}
