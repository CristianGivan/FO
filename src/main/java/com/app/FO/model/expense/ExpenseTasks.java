package com.app.FO.model.expense;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_tasks")
public class ExpenseTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_tasks_seq")
    @SequenceGenerator(name = "expense_tasks_seq",
            sequenceName = "expense_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    public ExpenseTasks() {
    }

    public ExpenseTasks(Expense expense, Tasks tasks) {
        this.expense = expense;
        this.tasks = tasks;
        this.expenseDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpenseTasks{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
