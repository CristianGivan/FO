package com.app.FO.model.task;

public enum TaskStatus {
    UNDEFINE(0),
    STARTED(1),
    WORKING(2),
    PENDING(3),
    COMPLITED(4);

    private int value;

    private TaskStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
