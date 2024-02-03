package com.app.FO.model.expense;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_user")
public class ExpenseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_user_seq")
    @SequenceGenerator(name = "expense_user_seq",
            sequenceName = "expense_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    public ExpenseUser() {
    }

    public ExpenseUser(Expense expense, User user) {
        this.user = user;
        this.expense = expense;
        this.expenseDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpenseTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", expense=" + expense.getId() +
                ", expenseDate=" + expenseDate +
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

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }
}
