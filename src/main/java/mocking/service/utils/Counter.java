package mocking.service.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class Counter {

    private static final AtomicInteger counter = new AtomicInteger(0);

    private Counter() {
    }

    public static int getAndIncrease() {
        return counter.getAndIncrement();
    }
}
