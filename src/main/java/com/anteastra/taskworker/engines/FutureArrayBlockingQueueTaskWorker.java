package com.anteastra.taskworker.engines;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class FutureArrayBlockingQueueTaskWorker implements TaskWorker<SimpleResult> {

    private final ExecutorService executor = Executors.newSingleThreadExecutor();
    private BlockingQueue<Task> queue = new ArrayBlockingQueue<>(CAPACITY);
    private AtomicBoolean toClose = new AtomicBoolean(false);
    private final static Integer CAPACITY = 1000000;

    public FutureArrayBlockingQueueTaskWorker() {
        executor.execute(() -> {
            while(!toClose.get()){
                Task task = queue.poll();
                if (task != null) {
                    task.execute();
                }
            }
        });
    }

    public void queue(Task input) {
        queue.add(input);
    }

    @Override
    public void close() throws IOException {
        toClose.set(true);
        executor.shutdown();
    }
}
