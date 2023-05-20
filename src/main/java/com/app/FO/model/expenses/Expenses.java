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
    private List<ExpensesUser> ExpensesUsers;

    @OneToMany(mappedBy = "expenses")
    private List<Expense> expenseList;

    @OneToMany(mappedBy = "expenses")
    private List<ExpensesTag> expensesTagList;

    @OneToOne(mappedBy = "expenses",cascade = CascadeType.ALL)
    private Transaction transaction;

    @OneToMany(mappedBy = "expenses")
    private List<EventExpense> eventExpensesList;

    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", creatorId=" + creator.getId() +
                ", ExpensesUser=" + ExpensesUsers +
                ", expenses=" + expenseList +
                ", expensesTags=" + expensesTagList +
                ", transactionId=" + transaction.getId() +
                ", eventExpens=" + eventExpensesList +
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

    public List<ExpensesUser> getExpensesListUsers() {
        return ExpensesUsers;
    }

    public void setExpensesListUsers(List<ExpensesUser> expensesUsers) {
        ExpensesUsers = expensesUsers;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenses) {
        this.expenseList = expenses;
    }

    public List<ExpensesTag> getExpensesListTags() {
        return expensesTagList;
    }

    public void setExpensesListTags(List<ExpensesTag> expensesTags) {
        this.expensesTagList = expensesTags;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public List<EventExpense> getEventExpenseLists() {
        return eventExpensesList;
    }

    public void setEventExpenseLists(List<EventExpense> eventExpenseLists) {
        this.eventExpensesList = eventExpenseLists;
    }
}
