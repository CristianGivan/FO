package com.app.FO.model.user;


import com.app.FO.exceptions.IdAlreadyAllocatedException;
import com.app.FO.model.account.AccountUsers;
import com.app.FO.model.expense.Expense;
//import com.app.FO.model.expenseslist.ExpensesList;
import com.app.FO.model.expenseslist.ExpensesListUsers;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskHistory;
import com.app.FO.model.tasklist.TaskList;
import com.app.FO.model.tasklist.TaskListHistory;
import com.app.FO.model.topic.TopicHistory;
import com.app.FO.model.note.Note;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.account.Account;
import com.app.FO.model.transaction.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq",
            sequenceName = "user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserRole> userRoles;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<UserTag> userTags;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Topic> topics;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TopicHistory> topicHistories;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<NoteHistory> noteHistories;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Remainder> remainders;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> tasks;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TaskHistory> taskHistories;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TaskList> taskListLists;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<TaskListHistory> taskListHistories;

    @OneToMany(mappedBy = "creator")
    private List<Expense> expensesCreated;

    @OneToMany(mappedBy = "payer")
    private List<Expense> expensesPayed;


    @OneToMany(mappedBy = "user")
    private List<ExpensesListUsers> expensesListUsers;

    @OneToMany(mappedBy = "creator")
    private List<Account> accounts;

    @OneToMany(mappedBy = "user")
    private List<AccountUsers> accountUsers;

    @OneToMany(mappedBy = "user")
    private List<Transaction> transactions;

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoles=" + userRoles +
                ", userTags=" + userTags +
                ", topics=" + topics +
                ", topicHistories=" + topicHistories +
                ", notes=" + notes +
                ", noteHistories=" + noteHistories +
                ", remainders=" + remainders +
                ", tasks=" + tasks +
                ", taskHistories=" + taskHistories +
                ", taskListLists=" + taskListLists +
                ", taskListHistories=" + taskListHistories +
                ", expensesCreated=" + expensesCreated +
                ", expensesPayed=" + expensesPayed +
                ", expensesListUsers=" + expensesListUsers +
                ", accounts=" + accounts +
                ", accountUsers=" + accountUsers +
                ", transactions=" + transactions +
                '}';
    }

    public User(String username, String password) {
        this.username = username;
        this.password=password;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (this.id == null || this.id.equals(id)) {
            this.id = id;
        } else {
            throw new IdAlreadyAllocatedException(
                    "Id is already allocated cannot be changed");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String name) {
        this.username = name;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<UserRole> getUserRoles() {
        if (userRoles==null){
            userRoles=new ArrayList<>();
        }
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<TopicHistory> getTopicHistories() {
        return topicHistories;
    }

    public void setTopicHistories(List<TopicHistory> topicHistories) {
        this.topicHistories = topicHistories;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<NoteHistory> getNoteHistories() {
        return noteHistories;
    }

    public void setNoteHistories(List<NoteHistory> noteHistories) {
        this.noteHistories = noteHistories;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistory> taskHistories) {
        this.taskHistories = taskHistories;
    }

    public List<TaskList> getTaskListLists() {
        return taskListLists;
    }

    public void setTaskListLists(List<TaskList> taskListLists) {
        this.taskListLists = taskListLists;
    }

    public List<TaskListHistory> getTaskListHistories() {
        return taskListHistories;
    }

    public void setTaskListHistories(List<TaskListHistory> taskListHistories) {
        this.taskListHistories = taskListHistories;
    }

    public List<Expense> getExpensesCreated() {
        return expensesCreated;
    }

    public void setExpensesCreated(List<Expense> expensesCreated) {
        this.expensesCreated = expensesCreated;
    }

    public List<Expense> getExpensesPayed() {
        return expensesPayed;
    }

    public void setExpensesPayed(List<Expense> expensesPayed) {
        this.expensesPayed = expensesPayed;
    }

    public List<ExpensesListUsers> getExpensesListUsers() {
        return expensesListUsers;
    }

    public void setExpensesListUsers(List<ExpensesListUsers> expensesListUsers) {
        this.expensesListUsers = expensesListUsers;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public List<AccountUsers> getAccountUsers() {
        return accountUsers;
    }

    public void setAccountUsers(List<AccountUsers> accountUsers) {
        this.accountUsers = accountUsers;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public List<UserTag> getUserTags() {
        if (userTags==null){
            userTags= new ArrayList<>();
        }
        return userTags;
    }

    public void setUserTags(List<UserTag> userTags) {
        this.userTags = userTags;
    }
}
