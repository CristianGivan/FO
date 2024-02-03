package com.app.FO.model.expenses;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_tasks")
public class ExpensesTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_tasks_seq")
    @SequenceGenerator(name = "expenses_tasks_seq",
            sequenceName = "expenses_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesTasks() {
    }

    public ExpensesTasks(Expenses expenses, Tasks tasks) {
        this.expenses = expenses;
        this.tasks = tasks;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
