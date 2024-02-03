package com.app.FO.model.expenses;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expenses_reminder")
public class ExpensesReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_reminder_seq")
    @SequenceGenerator(name = "expenses_reminder_seq",
            sequenceName = "expenses_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "expenses_date")
    private LocalDateTime expensesDate;

    public ExpensesReminder() {
    }

    public ExpensesReminder(Expenses expenses, Reminder reminder) {
        this.expenses = expenses;
        this.reminder = reminder;
        this.expensesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpensesReminder{" +
                "id=" + id +
                ", expensesId=" + expenses.getId() +
                ", reminderId=" + reminder.getId() +
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

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getExpensesDate() {
        return expensesDate;
    }

    public void setExpensesDate(LocalDateTime expensesDate) {
        this.expensesDate = expensesDate;
    }
}
