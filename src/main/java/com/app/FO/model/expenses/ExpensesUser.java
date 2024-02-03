package com.app.FO.model.expenses;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_user")
public class ExpensesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_user_seq")
    @SequenceGenerator(name = "expenses_user_seq",
            sequenceName = "expenses_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesUser() {
    }

    public ExpensesUser(Expenses expenses, User user) {
        this.user = user;
        this.expenses = expenses;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", expenses=" + expenses.getId() +
                ", expensesDate=" + expensesDate +
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

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public LocalDateTime getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(LocalDateTime expensesDate) {
        this.expensesDate = expensesDate;
    }
}
