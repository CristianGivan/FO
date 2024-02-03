package com.app.FO.model.account;

import com.app.FO.model.expenses.Expenses;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_account")
public class ExpensesAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_account_seq")
    @SequenceGenerator(name = "expenses_account_seq",
            sequenceName = "expenses_account_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_account_id")
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

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "account_date")
    private LocalDateTime accountDate;

    public ExpensesAccount() {
    }

    public ExpensesAccount(Account account, Expenses expenses, Double sum) {
        this.account = account;
        this.expenses = expenses;
        this.sum = sum;
        this.accountDate = LocalDateTime.now();
        this.account.setBalance(this.account.getBalance() + sum);
    }

    @Override
    public String toString() {
        return "ExpensesAccount{" +
                "id=" + id +
                ", account=" + account +
                ", expenses=" + expenses +
                ", sum=" + sum +
                ", checked=" + checked +
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

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public LocalDateTime getAccountDate() {
        return accountDate;
    }

    public void setAccountDate(LocalDateTime accountDate) {
        this.accountDate = accountDate;
    }
}
