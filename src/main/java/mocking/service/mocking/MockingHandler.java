package mocking.service.mocking;

import mocking.service.entity.SetupRequestEntity;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class MockingHandler<REQ, RES> {

    protected PriorityQueue<SetupRequestEntity> mockingData = new PriorityQueue<>();

    protected AtomicInteger counter = new AtomicInteger(0);

    public MockingHandler() {
    }

    public MockingHandler(SetupRequestEntity setupEntity) {

    }

    public abstract RES handle(REQ data);
}
