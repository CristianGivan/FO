package com.app.FO.model.transaction;

public enum TransactionStatus {
    UNDEFINE(0),
    CREATED(1),
    PLANED(2),
    PENDING(3),
    COMPLETED(4);

    private int value;

    private TransactionStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
