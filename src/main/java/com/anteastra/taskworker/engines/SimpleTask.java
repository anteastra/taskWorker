package com.anteastra.taskworker.engines;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleTask implements Task<SimpleResult> {
    private CountDownLatch latch = new CountDownLatch(1);

    private SimpleResult result;

    public SimpleResult execute() {

        System.out.println("task executed");
        Random random = new Random();
        result = new SimpleResult(Double.toString(random.nextGaussian()));
        latch.countDown();
        return result;
    }

    public SimpleResult get() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
}
