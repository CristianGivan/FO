package com.app.FO.model.account;

import com.app.FO.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_transaction")
public class AccountTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_transaction_seq")
    @SequenceGenerator(name = "account_transaction_seq",
            sequenceName = "account_transaction_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_transaction_id")
    private Long id;

    // todo trebuie sa vad cum modelez asta o fac cu un singur acount sau o fac cu form to
    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction  transaction;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public AccountTransaction() {
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "id=" + id +
                ", transactionId=" + transaction.getId() +
                ", accountId=" + account.getId() +
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

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
