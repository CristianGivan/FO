package com.app.FO.model.expenses;

import com.app.FO.model.event.EventExpense;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
    @SequenceGenerator(name = "expense_seq",
            sequenceName = "expense_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_id")
    private Long id;

    @Column(name = "name")
    private String taskListName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "expenses")
    private List<ExpensesUsers> ExpensesUsers;

    @OneToMany(mappedBy = "expenses")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "expenses")
    private List<ExpensesTag> expensesTags;

    @OneToOne(mappedBy = "expenses",cascade = CascadeType.ALL)
    private Transaction transaction;

    @OneToMany(mappedBy = "expenses")
    private List<EventExpense> eventExpens;

    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", creatorId=" + creator.getId() +
                ", ExpensesUsers=" + ExpensesUsers +
                ", expenses=" + expenses +
                ", expensesTags=" + expensesTags +
                ", transactionId=" + transaction.getId() +
                ", eventExpens=" + eventExpens +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<ExpensesUsers> getExpensesListUsers() {
        return ExpensesUsers;
    }

    public void setExpensesListUsers(List<ExpensesUsers> expensesUsers) {
        ExpensesUsers = expensesUsers;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<ExpensesTag> getExpensesListTags() {
        return expensesTags;
    }

    public void setExpensesListTags(List<ExpensesTag> expensesTags) {
        this.expensesTags = expensesTags;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<EventExpense> getEventExpenseLists() {
        return eventExpens;
    }

    public void setEventExpenseLists(List<EventExpense> eventExpenseLists) {
        this.eventExpens = eventExpenseLists;
    }
}
