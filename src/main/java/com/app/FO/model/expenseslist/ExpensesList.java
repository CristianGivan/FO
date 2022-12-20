package com.app.FO.model.expenseslist;

import com.app.FO.model.event.EventExpenseLists;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "expenses_list")
public class ExpensesList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_list_seq")
    @SequenceGenerator(name = "expense_list_seq",
            sequenceName = "expense_list_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expense_list_id")
    private Long id;

    @Column(name = "name")
    private String taskListName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "expensesList")
    private List<ExpensesListUsers> ExpensesListUsers;

    @OneToMany(mappedBy = "expensesList")
    private List<Expense> expenses;

    @OneToMany(mappedBy = "expensesList")
    private List<ExpensesListTags> expensesListTags;

    @OneToOne(mappedBy = "expensesList",cascade = CascadeType.ALL)
    private Transaction transaction;

    @OneToMany(mappedBy = "expensesList")
    private List<EventExpenseLists> eventExpenseLists;

    public ExpensesList() {
    }

    @Override
    public String toString() {
        return "ExpensesList{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", creatorId=" + creator.getId() +
                ", ExpensesListUsers=" + ExpensesListUsers +
                ", expenses=" + expenses +
                ", expensesListTags=" + expensesListTags +
                ", transactionId=" + transaction.getId() +
                ", eventExpenseLists=" + eventExpenseLists +
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

    public List<com.app.FO.model.expenseslist.ExpensesListUsers> getExpensesListUsers() {
        return ExpensesListUsers;
    }

    public void setExpensesListUsers(List<com.app.FO.model.expenseslist.ExpensesListUsers> expensesListUsers) {
        ExpensesListUsers = expensesListUsers;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    public List<ExpensesListTags> getExpensesListTags() {
        return expensesListTags;
    }

    public void setExpensesListTags(List<ExpensesListTags> expensesListTags) {
        this.expensesListTags = expensesListTags;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<EventExpenseLists> getEventExpenseLists() {
        return eventExpenseLists;
    }

    public void setEventExpenseLists(List<EventExpenseLists> eventExpenseLists) {
        this.eventExpenseLists = eventExpenseLists;
    }
}
