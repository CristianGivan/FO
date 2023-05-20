package com.app.FO.model.user;


import com.app.FO.exceptions.IdAlreadyAllocatedException;
import com.app.FO.model.account.Account;
import com.app.FO.model.account.AccountUser;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expenses.ExpensesUser;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.NoteUser;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskHistory;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.tasks.TasksHistory;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicHistory;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.model.transaction.Transaction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
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

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserRole> userRoleList;

    @OneToMany
    @JoinColumn(name = "user_list")
    private List<User> userList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Topic> topicList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicHistory> topicHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Note> noteList;
    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tagList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteHistory> noteHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reminder> reminderList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> taskList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskHistory> taskHistoryList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tasks> tasksList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksHistory> tasksHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expense> expensesCreatedList;

    @OneToMany(mappedBy = "payer", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expense> expensesPayedList;


    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesUser> expensesUserList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Account> accountList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountUser> accountUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Transaction> transactionList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TagUser> tagUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicUser> topicUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteUser> noteUserList;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", userRoleList=" + userRoleList +
                ", userList=" + userList +
                ", topicList=" + topicList +
                ", topicHistoryList=" + topicHistoryList +
                ", noteList=" + noteList +
                ", tagList=" + tagList +
                ", noteHistoryList=" + noteHistoryList +
                ", reminderList=" + reminderList +
                ", taskList=" + taskList +
                ", taskHistoryList=" + taskHistoryList +
                ", tasksList=" + tasksList +
                ", tasksHistoryList=" + tasksHistoryList +
                ", expensesCreatedList=" + expensesCreatedList +
                ", expensesPayedList=" + expensesPayedList +
                ", expensesUserList=" + expensesUserList +
                ", accountList=" + accountList +
                ", accountUserList=" + accountUserList +
                ", transactionList=" + transactionList +
                ", tagUserList=" + tagUserList +
                ", topicUserList=" + topicUserList +
                ", noteUserList=" + noteUserList +
                '}';
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

    public List<User> getUserList() {
        if (userList == null) {
            userList = new ArrayList<>();
        }
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }

    public List<TagUser> getTagUserList() {
        return tagUserList;
    }

    public void setTagUserList(List<TagUser> tagUserList) {
        this.tagUserList = tagUserList;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public List<ExpensesUser> getExpensesUserList() {
        return expensesUserList;
    }

    public void setExpensesUserList(List<ExpensesUser> expensesUserList) {
        this.expensesUserList = expensesUserList;
    }

    public List<TopicUser> getTopicUserList() {
        return topicUserList;
    }

    public void setTopicUserList(List<TopicUser> topicUserList) {
        this.topicUserList = topicUserList;
    }

    public List<NoteUser> getNoteUserList() {
        if (noteUserList == null) {
            noteUserList = new ArrayList<>();
        }
        return noteUserList;
    }

    public void setNoteUserList(List<NoteUser> noteUserList) {
        this.noteUserList = noteUserList;
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

    public List<UserRole> getUserRoleList() {
        if (userRoleList == null) {
            userRoleList = new ArrayList<>();
        }
        return userRoleList;
    }


    public void setUserRoleList(List<UserRole> userRoles) {
        this.userRoleList = userRoles;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topics) {
        this.topicList = topics;
    }

    public List<TopicHistory> getTopicHistoryList() {
        return topicHistoryList;
    }

    public void setTopicHistoryList(List<TopicHistory> topicHistories) {
        this.topicHistoryList = topicHistories;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> notes) {
        this.noteList = notes;
    }

    public List<NoteHistory> getNoteHistoryList() {
        return noteHistoryList;
    }

    public void setNoteHistoryList(List<NoteHistory> noteHistories) {
        this.noteHistoryList = noteHistories;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reminder> getRemainderList() {
        return reminderList;
    }

    public void setRemainderList(List<Reminder> reminders) {
        this.reminderList = reminders;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> tasks) {
        this.taskList = tasks;
    }

    public List<TaskHistory> getTaskHistoryList() {
        return taskHistoryList;
    }

    public void setTaskHistoryList(List<TaskHistory> taskHistories) {
        this.taskHistoryList = taskHistories;
    }

    public List<Tasks> getTaskListLists() {
        return tasksList;
    }

    public void setTaskListLists(List<Tasks> tasks) {
        this.tasksList = tasks;
    }

    public List<TasksHistory> getTasksHistoryList() {
        return tasksHistoryList;
    }

    public void setTasksHistoryList(List<TasksHistory> taskListHistories) {
        this.tasksHistoryList = taskListHistories;
    }

    public List<Expense> getExpensesCreatedList() {
        return expensesCreatedList;
    }

    public void setExpensesCreatedList(List<Expense> expensesCreated) {
        this.expensesCreatedList = expensesCreated;
    }

    public List<Expense> getExpensesPayedList() {
        return expensesPayedList;
    }

    public void setExpensesPayedList(List<Expense> expensesPayed) {
        this.expensesPayedList = expensesPayed;
    }

    public List<ExpensesUser> getExpensesListUsers() {
        return expensesUserList;
    }

    public void setExpensesListUsers(List<ExpensesUser> expensesUsers) {
        this.expensesUserList = expensesUsers;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accounts) {
        this.accountList = accounts;
    }

    public List<AccountUser> getAccountUserList() {
        return accountUserList;
    }

    public void setAccountUserList(List<AccountUser> accountUsers) {
        this.accountUserList = accountUsers;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactions) {
        this.transactionList = transactions;
    }

    public List<TagUser> getUserTagList() {
        if (tagUserList == null) {
            tagUserList = new ArrayList<>();
        }
        return tagUserList;
    }

    public void setUserTagList(List<TagUser> tagUsers) {
        this.tagUserList = tagUsers;
    }
}
