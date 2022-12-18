package com.app.FO.model.transaction;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    private String details;

    private Double amount;

    private LocalDateTime dateTime;

    private Account fromAccount;

    private Account toAccount;
}
