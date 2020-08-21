package mocking.service.mocking;

import lombok.extern.slf4j.Slf4j;
import mocking.service.entity.GrpcApi;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Component
@Slf4j
public class MockingCenter {
    private ConcurrentMap<String, HttpHandlerFactory> httpRequestHandler = new ConcurrentHashMap<>();
    private Map<GrpcApi, GrpcHandlerFactory> grpcRequestHandler = new HashMap<>();
}
