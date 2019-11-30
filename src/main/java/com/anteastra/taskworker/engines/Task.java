package com.anteastra.taskworker.engines;

public interface Task<T> {
    T execute();
}
