package com.app.FO.model.transaction;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_user")
public class TransactionUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_user_seq")
    @SequenceGenerator(name = "transaction_user_seq",
            sequenceName = "transaction_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public TransactionUser() {
    }

    public TransactionUser(Transaction transaction, User user) {
        this.user = user;
        this.transaction = transaction;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", transaction=" + transaction.getId() +
                ", transactionDate=" + transactionDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        this.transactionDate = transactionDate;
    }
}
