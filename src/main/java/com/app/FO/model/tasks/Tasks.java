package com.app.FO.model.tasks;

import com.app.FO.model.account.AccountTasks;
import com.app.FO.model.event.EventTasks;
import com.app.FO.model.expense.ExpenseTasks;
import com.app.FO.model.expenses.ExpensesTasks;
import com.app.FO.model.link.LinkTasks;
import com.app.FO.model.person.PersonTasks;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.transaction.TransactionTasks;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_seq")
    @SequenceGenerator(name = "tasks_seq",
            sequenceName = "tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "tasks_status")
    private TaskStatus taskStatus;


    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksUser> tasksUserList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTag> tasksTagList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksReminder> tasksReminderList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTopic> tasksTopicList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkTasks> linkTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTasks> personTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTasks> eventTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTasks> expenseTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTasks> expensesTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionTasks> transactionTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTasks> accountTasksList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksHistory> tasksHistoryList;

    public Tasks() {
    }

    public Tasks(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", creator=" + creator +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", tasksUserList=" + tasksUserList +
                ", tasksTagList=" + tasksTagList +
                ", tasksReminderList=" + tasksReminderList +
                ", tasksTopicList=" + tasksTopicList +
                ", linkTasksList=" + linkTasksList +
                ", personTasksList=" + personTasksList +
                ", tasksTaskList=" + tasksTaskList +
                ", eventTasksList=" + eventTasksList +
                ", expenseTasksList=" + expenseTasksList +
                ", expensesTasksList=" + expensesTasksList +
                ", transactionTasksList=" + transactionTasksList +
                ", accountTasksList=" + accountTasksList +
                ", tasksHistoryList=" + tasksHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<TasksUser> getTasksUserList() {
        if (tasksUserList == null) {
            tasksUserList = new ArrayList<>();
        }
        return tasksUserList;
    }

    public void setTasksUserList(List<TasksUser> tasksUserList) {
        this.tasksUserList = tasksUserList;
    }

    public List<TasksTag> getTasksTagList() {
        return tasksTagList;
    }

    public void setTasksTagList(List<TasksTag> tasksTagList) {
        this.tasksTagList = tasksTagList;
    }

    public List<TasksReminder> getTasksReminderList() {
        return tasksReminderList;
    }

    public void setTasksReminderList(List<TasksReminder> tasksReminderList) {
        this.tasksReminderList = tasksReminderList;
    }

    public List<TasksTopic> getTasksTopicList() {
        if (tasksTopicList == null) {
            tasksTopicList = new ArrayList<>();
        }
        return tasksTopicList;
    }

    public void setTasksTopicList(List<TasksTopic> tasksTopicList) {
        this.tasksTopicList = tasksTopicList;
    }

    public List<LinkTasks> getLinkTasksList() {
        return linkTasksList;
    }

    public void setLinkTasksList(List<LinkTasks> linkTasksList) {
        this.linkTasksList = linkTasksList;
    }

    public List<PersonTasks> getPersonTasksList() {
        return personTasksList;
    }

    public void setPersonTasksList(List<PersonTasks> personTasksList) {
        this.personTasksList = personTasksList;
    }

    public List<TasksTask> getTasksTaskList() {
        return tasksTaskList;
    }

    public void setTasksTaskList(List<TasksTask> tasksTaskList) {
        this.tasksTaskList = tasksTaskList;
    }

    public List<EventTasks> getEventTasksList() {
        return eventTasksList;
    }

    public void setEventTasksList(List<EventTasks> eventTasksList) {
        this.eventTasksList = eventTasksList;
    }

    public List<ExpenseTasks> getExpenseTasksList() {
        return expenseTasksList;
    }

    public void setExpenseTasksList(List<ExpenseTasks> expenseTasksList) {
        this.expenseTasksList = expenseTasksList;
    }

    public List<ExpensesTasks> getExpensesTasksList() {
        return expensesTasksList;
    }

    public void setExpensesTasksList(List<ExpensesTasks> expensesTasksList) {
        this.expensesTasksList = expensesTasksList;
    }

    public List<TransactionTasks> getTransactionTasksList() {
        return transactionTasksList;
    }

    public void setTransactionTasksList(List<TransactionTasks> transactionTasksList) {
        this.transactionTasksList = transactionTasksList;
    }

    public List<AccountTasks> getAccountTasksList() {
        return accountTasksList;
    }

    public void setAccountTasksList(List<AccountTasks> accountTasksList) {
        this.accountTasksList = accountTasksList;
    }

    public List<TasksHistory> getTasksHistoryList() {
        return tasksHistoryList;
    }

    public void setTasksHistoryList(List<TasksHistory> tasksHistoryList) {
        this.tasksHistoryList = tasksHistoryList;
    }
}
