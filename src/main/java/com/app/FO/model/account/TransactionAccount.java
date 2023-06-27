package com.app.FO.model.account;

import com.app.FO.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_account")
public class TransactionAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_account_seq")
    @SequenceGenerator(name = "transaction_account_seq",
            sequenceName = "transaction_account_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_account_id")
    private Long id;

    // todo trebuie sa vad cum modelez asta o fac cu un singur acount sau o fac cu form to
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "direction")
    private String direction;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TransactionAccount() {
    }

    public TransactionAccount(Account account, Transaction transaction, Double sum, String direction) {
        this.transaction = transaction;
        this.account = account;
        this.sum = sum;
        this.direction = direction;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TransactionAccount{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", accountId=" + account.getId() +
                ", sum=" + sum +
                ", direction=" + direction +
                ", linkDate=" + linkDate +
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
