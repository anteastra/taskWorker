package com.anteastra.taskworker.engines;

import java.io.Closeable;

public interface TaskWorker<T> extends Closeable {
    void queue(Task<T> input);
}
