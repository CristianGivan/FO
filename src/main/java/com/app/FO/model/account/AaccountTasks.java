package com.app.FO.model.transaction;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_tasks")
public class TransactionTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_tasks_seq")
    @SequenceGenerator(name = "transaction_tasks_seq",
            sequenceName = "transaction_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @Column(name = "transaction_date")
    private LocalDateTime transactionDate;

    public TransactionTasks() {
    }

    public TransactionTasks(Transaction transaction, Tasks tasks) {
        this.transaction = transaction;
        this.tasks = tasks;
        this.transactionDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
