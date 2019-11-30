package com.anteastra.taskworker.engines;

public class SimpleResult {
    private String taskName;

    public SimpleResult(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public String toString() {
        return "SimpleResult{" +
                "taskName='" + taskName + '\'' +
                '}';
    }
}
