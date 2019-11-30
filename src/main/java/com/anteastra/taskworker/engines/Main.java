package com.anteastra.taskworker.engines;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TaskWorker taskWorker = new FutureArrayBlockingQueueTaskWorker();
        SimpleTask task = new SimpleTask();
        taskWorker.queue(task);
        System.out.println(task.get());
        taskWorker.close();
    }
}
