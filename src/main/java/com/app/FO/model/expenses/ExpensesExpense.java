package com.app.FO.model.expenses;

import com.app.FO.model.expense.Expense;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_expense")
public class ExpensesExpense {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_expense_seq")
    @SequenceGenerator(name = "expenses_expense_seq",
            sequenceName = "expenses_expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_expense_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @Column(name = "checked")
    private Boolean checked;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesExpense() {
    }

    public ExpensesExpense(Expenses expenses, Expense expense) {
        this.expenses = expenses;
        this.expense = expense;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesExpense{" +
                "id=" + id +
                ", expenses=" + expenses +
                ", expense=" + expense +
                ", checked=" + checked +
                ", expensesDate=" + expensesDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }

    public LocalDateTime getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(LocalDateTime expensesDate) {
        this.expensesDate = expensesDate;
    }
}
