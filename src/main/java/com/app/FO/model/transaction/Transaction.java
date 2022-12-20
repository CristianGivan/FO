package com.app.FO.model.transaction;

import com.app.FO.model.account.AccountTransactions;
import com.app.FO.model.expenseslist.ExpensesList;
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
    private List<AccountTransactions> fromAccount;

    @OneToMany(mappedBy = "account",cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTransactions> toAccount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_list_id", referencedColumnName = "expense_list_id")
    private ExpensesList expensesList;

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
                ", expensesListId=" + expensesList.getId() +
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

    public List<AccountTransactions> getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(List<AccountTransactions> fromAccount) {
        this.fromAccount = fromAccount;
    }

    public List<AccountTransactions> getToAccount() {
        return toAccount;
    }

    public void setToAccount(List<AccountTransactions> toAccount) {
        this.toAccount = toAccount;
    }

    public ExpensesList getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(ExpensesList expensesList) {
        this.expensesList = expensesList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
