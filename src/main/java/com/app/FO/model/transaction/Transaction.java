package com.app.FO.model.transaction;

import com.app.FO.model.account.AccountTransaction;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(name = "transaction_seq",
            sequenceName = "transaction_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "transaction_id")
    private Long id;

    @Column(name = "details")
    private String details;

    @Column(name = "amount")
    private Double amount;

    private LocalDateTime dateTime;
    @OneToMany(mappedBy = "account",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransaction> fromAccount;

    @OneToMany(mappedBy = "account",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransaction> toAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_id", referencedColumnName = "expenses_id")
    private Expenses expenses;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public Transaction() {
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", details='" + details + '\'' +
                ", amount=" + amount +
                ", dateTime=" + dateTime +
                ", fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", expensesId=" + expenses.getId() +
                ", userId=" + user.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<AccountTransaction> getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(List<AccountTransaction> fromAccount) {
        this.fromAccount = fromAccount;
    }

    public List<AccountTransaction> getToAccount() {
        return toAccount;
    }

    public void setToAccount(List<AccountTransaction> toAccount) {
        this.toAccount = toAccount;
    }

    public Expenses getExpensesList() {
        return expenses;
    }

    public void setExpensesList(Expenses expenses) {
        this.expenses = expenses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
