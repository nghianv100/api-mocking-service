package mocking.service.mocking;

import mocking.service.entity.SetupRequestEntity;

import java.util.PriorityQueue;

public abstract class MockingHandler<REQ, RES> {

    protected PriorityQueue<SetupRequestEntity> mockingData = new PriorityQueue<>();

    public abstract RES handle(REQ data);
}
