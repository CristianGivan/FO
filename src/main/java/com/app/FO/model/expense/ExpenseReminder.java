package com.app.FO.model.expense;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "expense_reminder")
public class ExpenseReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_reminder_seq")
    @SequenceGenerator(name = "expense_reminder_seq",
            sequenceName = "expense_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "expense_date")
    private LocalDateTime expenseDate;

    public ExpenseReminder() {
    }

    public ExpenseReminder(Expense expense, Reminder reminder) {
        this.expense = expense;
        this.reminder = reminder;
        this.expenseDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ExpenseReminder{" +
                "id=" + id +
                ", expenseId=" + expense.getId() +
                ", reminderId=" + reminder.getId() +
                ", expenseDate=" + expenseDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(LocalDateTime expenseDate) {
        this.expenseDate = expenseDate;
    }
}
