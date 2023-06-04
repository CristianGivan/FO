package com.app.FO.model.transaction;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_reminder")
public class TransactionReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_reminder_seq")
    @SequenceGenerator(name = "transaction_reminder_seq",
            sequenceName = "transaction_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public TransactionReminder() {
    }

    public TransactionReminder(Transaction transaction, Reminder reminder) {
        this.transaction = transaction;
        this.reminder = reminder;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionReminder{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", reminderId=" + reminder.getId() +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
