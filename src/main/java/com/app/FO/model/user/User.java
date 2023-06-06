package com.app.FO.model.user;


import com.app.FO.model.account.Account;
import com.app.FO.model.account.AccountHistory;
import com.app.FO.model.account.AccountUser;
import com.app.FO.model.event.Event;
import com.app.FO.model.event.EventHistory;
import com.app.FO.model.event.EventUser;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expense.ExpenseHistory;
import com.app.FO.model.expense.ExpenseUser;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.expenses.ExpensesExpense;
import com.app.FO.model.expenses.ExpensesHistory;
import com.app.FO.model.expenses.ExpensesUser;
import com.app.FO.model.link.Link;
import com.app.FO.model.link.LinkHistory;
import com.app.FO.model.link.LinkUser;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteHistory;
import com.app.FO.model.note.NoteUser;
import com.app.FO.model.person.Person;
import com.app.FO.model.person.PersonHistory;
import com.app.FO.model.person.PersonUser;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.reminder.ReminderHistory;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagHistory;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskHistory;
import com.app.FO.model.task.TaskUser;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.tasks.TasksHistory;
import com.app.FO.model.tasks.TasksUser;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicHistory;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.transaction.TransactionHistory;
import com.app.FO.model.transaction.TransactionUser;
import com.app.FO.model.work.Work;
import com.app.FO.model.work.WorkHistory;
import com.app.FO.model.work.WorkUser;

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

    //    @JsonIgnore
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<UserUser> userUserList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tag> tagList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TagUser> tagUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TagHistory> tagHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Reminder> reminderList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReminderHistory> reminderHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Note> noteList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteUser> noteUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteHistory> noteHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Topic> topicList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicUser> topicUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicHistory> topicHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Task> taskList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskUser> taskUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskHistory> taskHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Work> workList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkUser> workUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkHistory> workHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Tasks> tasksList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksUser> tasksUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksHistory> tasksHistoryList;


    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Link> linkList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkUser> linkUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkHistory> linkHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Person> personList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonUser> personUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonHistory> personHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Event> eventList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventUser> eventUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventHistory> eventHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expense> expenseList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseUser> expenseUserList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseHistory> expenseHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expenses> expensesList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesUser> expensesUserList;
    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Expenses> expensesPayedList;
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesHistory> expensesHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesExpense> expensesExpenseList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Transaction> transactionList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionUser> transactionUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionHistory> transactionHistoryList;

    @OneToMany(mappedBy = "creator", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Account> accountList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountUser> accountUserList;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountHistory> accountHistoryList;

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
                ", userUserList=" + userUserList +
                ", tagList=" + tagList +
                ", tagUserList=" + tagUserList +
                ", tagHistoryList=" + tagHistoryList +
                ", reminderList=" + reminderList +
                ", reminderHistoryList=" + reminderHistoryList +
                ", noteList=" + noteList +
                ", noteUserList=" + noteUserList +
                ", noteHistoryList=" + noteHistoryList +
                ", topicList=" + topicList +
                ", topicUserList=" + topicUserList +
                ", topicHistoryList=" + topicHistoryList +
                ", taskList=" + taskList +
                ", taskUserList=" + taskUserList +
                ", taskHistoryList=" + taskHistoryList +
                ", workList=" + workList +
                ", workUserList=" + workUserList +
                ", workHistoryList=" + workHistoryList +
                ", tasksList=" + tasksList +
                ", tasksUserList=" + tasksUserList +
                ", tasksHistoryList=" + tasksHistoryList +
                ", linkList=" + linkList +
                ", linkUserList=" + linkUserList +
                ", linkHistoryList=" + linkHistoryList +
                ", personList=" + personList +
                ", personUserList=" + personUserList +
                ", personHistoryList=" + personHistoryList +
                ", eventList=" + eventList +
                ", eventUserList=" + eventUserList +
                ", eventHistoryList=" + eventHistoryList +
                ", expenseList=" + expenseList +
                ", expenseUserList=" + expenseUserList +
                ", expenseHistoryList=" + expenseHistoryList +
                ", expensesList=" + expensesList +
                ", expensesUserList=" + expensesUserList +
                ", expensesPayedList=" + expensesPayedList +
                ", expensesHistoryList=" + expensesHistoryList +
                ", expensesExpenseList=" + expensesExpenseList +
                ", transactionList=" + transactionList +
                ", transactionUserList=" + transactionUserList +
                ", transactionHistoryList=" + transactionHistoryList +
                ", accountList=" + accountList +
                ", accountUserList=" + accountUserList +
                ", accountHistoryList=" + accountHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<UserRole> getUserRoleList() {
        if (userRoleList == null) {
            userRoleList = new ArrayList<>();
        }
        return userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

    public List<UserUser> getUserUserList() {
        if (userUserList == null) {
            userUserList = new ArrayList<>();
        }
        return userUserList;
    }

    public void setUserUserList(List<UserUser> userUserList) {
        this.userUserList = userUserList;
    }

    public List<Tag> getTagList() {
        if (tagUserList == null) {
            tagUserList = new ArrayList<>();
        }
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<TagUser> getTagUserList() {
        return tagUserList;
    }

    public void setTagUserList(List<TagUser> tagUserList) {
        this.tagUserList = tagUserList;
    }

    public List<TagHistory> getTagHistoryList() {
        return tagHistoryList;
    }

    public void setTagHistoryList(List<TagHistory> tagHistoryList) {
        this.tagHistoryList = tagHistoryList;
    }

    public List<Reminder> getReminderList() {
        return reminderList;
    }

    public void setReminderList(List<Reminder> reminderList) {
        this.reminderList = reminderList;
    }

    public List<ReminderHistory> getReminderHistoryList() {
        return reminderHistoryList;
    }

    public void setReminderHistoryList(List<ReminderHistory> reminderHistoryList) {
        this.reminderHistoryList = reminderHistoryList;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
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

    public List<NoteHistory> getNoteHistoryList() {
        return noteHistoryList;
    }

    public void setNoteHistoryList(List<NoteHistory> noteHistoryList) {
        this.noteHistoryList = noteHistoryList;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    public List<TopicUser> getTopicUserList() {
        return topicUserList;
    }

    public void setTopicUserList(List<TopicUser> topicUserList) {
        this.topicUserList = topicUserList;
    }

    public List<TopicHistory> getTopicHistoryList() {
        return topicHistoryList;
    }

    public void setTopicHistoryList(List<TopicHistory> topicHistoryList) {
        this.topicHistoryList = topicHistoryList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<TaskUser> getTaskUserList() {
        return taskUserList;
    }

    public void setTaskUserList(List<TaskUser> taskUserList) {
        this.taskUserList = taskUserList;
    }

    public List<TaskHistory> getTaskHistoryList() {
        return taskHistoryList;
    }

    public void setTaskHistoryList(List<TaskHistory> taskHistoryList) {
        this.taskHistoryList = taskHistoryList;
    }

    public List<Work> getWorkList() {
        return workList;
    }

    public void setWorkList(List<Work> workList) {
        this.workList = workList;
    }

    public List<WorkUser> getWorkUserList() {
        return workUserList;
    }

    public void setWorkUserList(List<WorkUser> workUserList) {
        this.workUserList = workUserList;
    }

    public List<WorkHistory> getWorkHistoryList() {
        return workHistoryList;
    }

    public void setWorkHistoryList(List<WorkHistory> workHistoryList) {
        this.workHistoryList = workHistoryList;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public List<TasksUser> getTasksUserList() {
        return tasksUserList;
    }

    public void setTasksUserList(List<TasksUser> tasksUserList) {
        this.tasksUserList = tasksUserList;
    }

    public List<TasksHistory> getTasksHistoryList() {
        return tasksHistoryList;
    }

    public void setTasksHistoryList(List<TasksHistory> tasksHistoryList) {
        this.tasksHistoryList = tasksHistoryList;
    }

    public List<Link> getLinkList() {
        return linkList;
    }

    public void setLinkList(List<Link> linkList) {
        this.linkList = linkList;
    }

    public List<LinkUser> getLinkUserList() {
        return linkUserList;
    }

    public void setLinkUserList(List<LinkUser> linkUserList) {
        this.linkUserList = linkUserList;
    }

    public List<LinkHistory> getLinkHistoryList() {
        return linkHistoryList;
    }

    public void setLinkHistoryList(List<LinkHistory> linkHistoryList) {
        this.linkHistoryList = linkHistoryList;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<PersonUser> getPersonUserList() {
        return personUserList;
    }

    public void setPersonUserList(List<PersonUser> personUserList) {
        this.personUserList = personUserList;
    }

    public List<PersonHistory> getPersonHistoryList() {
        return personHistoryList;
    }

    public void setPersonHistoryList(List<PersonHistory> personHistoryList) {
        this.personHistoryList = personHistoryList;
    }

    public List<Event> getEventList() {
        return eventList;
    }

    public void setEventList(List<Event> eventList) {
        this.eventList = eventList;
    }

    public List<EventUser> getEventUserList() {
        return eventUserList;
    }

    public void setEventUserList(List<EventUser> eventUserList) {
        this.eventUserList = eventUserList;
    }

    public List<EventHistory> getEventHistoryList() {
        return eventHistoryList;
    }

    public void setEventHistoryList(List<EventHistory> eventHistoryList) {
        this.eventHistoryList = eventHistoryList;
    }

    public List<Expense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    public List<ExpenseUser> getExpenseUserList() {
        return expenseUserList;
    }

    public void setExpenseUserList(List<ExpenseUser> expenseUserList) {
        this.expenseUserList = expenseUserList;
    }

    public List<ExpenseHistory> getExpenseHistoryList() {
        return expenseHistoryList;
    }

    public void setExpenseHistoryList(List<ExpenseHistory> expenseHistoryList) {
        this.expenseHistoryList = expenseHistoryList;
    }

    public List<Expenses> getExpensesList() {
        return expensesList;
    }

    public void setExpensesList(List<Expenses> expensesList) {
        this.expensesList = expensesList;
    }

    public List<ExpensesUser> getExpensesUserList() {
        return expensesUserList;
    }

    public void setExpensesUserList(List<ExpensesUser> expensesUserList) {
        this.expensesUserList = expensesUserList;
    }

    public List<Expenses> getExpensesPayedList() {
        return expensesPayedList;
    }

    public void setExpensesPayedList(List<Expenses> expensesPayedList) {
        this.expensesPayedList = expensesPayedList;
    }

    public List<ExpensesHistory> getExpensesHistoryList() {
        return expensesHistoryList;
    }

    public void setExpensesHistoryList(List<ExpensesHistory> expensesHistoryList) {
        this.expensesHistoryList = expensesHistoryList;
    }

    public List<ExpensesExpense> getExpensesExpenseList() {
        return expensesExpenseList;
    }

    public void setExpensesExpenseList(List<ExpensesExpense> expensesExpenseList) {
        this.expensesExpenseList = expensesExpenseList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public List<TransactionUser> getTransactionUserList() {
        return transactionUserList;
    }

    public void setTransactionUserList(List<TransactionUser> transactionUserList) {
        this.transactionUserList = transactionUserList;
    }

    public List<TransactionHistory> getTransactionHistoryList() {
        return transactionHistoryList;
    }

    public void setTransactionHistoryList(List<TransactionHistory> transactionHistoryList) {
        this.transactionHistoryList = transactionHistoryList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public List<AccountUser> getAccountUserList() {
        return accountUserList;
    }

    public void setAccountUserList(List<AccountUser> accountUserList) {
        this.accountUserList = accountUserList;
    }

    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }
}
