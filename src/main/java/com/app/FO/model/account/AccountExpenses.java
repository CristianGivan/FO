package com.app.FO.model.account;

import com.app.FO.model.expenses.Expenses;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_expenses")
public class AccountExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_expenses_seq")
    @SequenceGenerator(name = "account_expenses_seq",
            sequenceName = "account_expenses_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_expenses_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "sum")
    private Double sum;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public AccountExpenses() {
    }

    public AccountExpenses(Account account, Expenses expenses) {
        this.account = account;
        this.expenses = expenses;
        this.accountDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "AccountExpenses{" +
                "id=" + id +
                ", accountId=" + account.getId() +
                ", expensesId=" + expenses.getId() +
                ", accountDate=" + accountDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }
}
