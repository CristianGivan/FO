package com.app.FO.model.expenses;

public enum ExpensesStatus {
    UNDEFINE(0),
    CREATED(1),
    PLANED(2),
    PENDING(3),
    COMPLETED(4);

    private int value;

    private ExpensesStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
