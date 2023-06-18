package com.app.FO.model.reminder;

import com.app.FO.model.account.AccountReminder;
import com.app.FO.model.dates.DatesReminder;
import com.app.FO.model.email.EmailReminder;
import com.app.FO.model.event.EventReminder;
import com.app.FO.model.expense.ExpenseReminder;
import com.app.FO.model.expenses.ExpensesReminder;
import com.app.FO.model.link.LinkReminder;
import com.app.FO.model.note.NoteReminder;
import com.app.FO.model.person.PersonReminder;
import com.app.FO.model.phoneNumber.PhoneNumberReminder;
import com.app.FO.model.task.TaskReminder;
import com.app.FO.model.tasks.TasksReminder;
import com.app.FO.model.topic.TopicReminder;
import com.app.FO.model.transaction.TransactionReminder;
import com.app.FO.model.user.User;
import com.app.FO.model.work.WorkReminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_seq")
    @SequenceGenerator(name = "reminder_seq",
            sequenceName = "reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_id")
    private Long id;

    @Column(name = "subject")
    private String subject;


    @Column(name = "reminder_date_time")
    private LocalDateTime reminderDateTime;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReminderUser> reminderUserList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReminderSnooze> reminderSnoozeList;

    @OneToMany(mappedBy = "repeatedReminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReminderReminder> repeatedReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteReminder> noteReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicReminder> topicReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskReminder> taskReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkReminder> workReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksReminder> tasksReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventReminder> eventReminderList;
    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkReminder> linkReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonReminder> personReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseReminder> expenseReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesReminder> expensesReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionReminder> transactionReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountReminder> accountReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailReminder> emailReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberReminder> phoneNumberReminderList;

    @OneToMany(mappedBy = "reminder", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesReminder> datesReminderList;

    public Reminder() {
    }

    public Reminder(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDateTime = LocalDateTime.now();
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

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<ReminderUser> getReminderUserList() {
        if (reminderUserList == null) {
            reminderUserList = new ArrayList<>();
        }
        return reminderUserList;
    }

    public void setReminderUserList(List<ReminderUser> reminderUserList) {
        this.reminderUserList = reminderUserList;
    }

    public List<ReminderSnooze> getReminderSnoozeList() {
        return reminderSnoozeList;
    }

    public void setReminderSnoozeList(List<ReminderSnooze> reminderSnoozeList) {
        this.reminderSnoozeList = reminderSnoozeList;
    }

    public List<ReminderReminder> getRepeatedReminderList() {
        return repeatedReminderList;
    }

    public void setRepeatedReminderList(List<ReminderReminder> repeatedReminderList) {
        this.repeatedReminderList = repeatedReminderList;
    }

    public List<NoteReminder> getNoteReminderList() {
        return noteReminderList;
    }

    public void setNoteReminderList(List<NoteReminder> noteReminderList) {
        this.noteReminderList = noteReminderList;
    }

    public List<TopicReminder> getTopicReminderList() {
        return topicReminderList;
    }

    public void setTopicReminderList(List<TopicReminder> topicReminderList) {
        this.topicReminderList = topicReminderList;
    }

    public List<TaskReminder> getTaskReminderList() {
        return taskReminderList;
    }

    public void setTaskReminderList(List<TaskReminder> taskReminderList) {
        this.taskReminderList = taskReminderList;
    }

    public List<WorkReminder> getWorkReminderList() {
        return workReminderList;
    }

    public void setWorkReminderList(List<WorkReminder> workReminderList) {
        this.workReminderList = workReminderList;
    }

    public List<TasksReminder> getTasksReminderList() {
        return tasksReminderList;
    }

    public void setTasksReminderList(List<TasksReminder> tasksReminderList) {
        this.tasksReminderList = tasksReminderList;
    }

    public List<EventReminder> getEventReminderList() {
        return eventReminderList;
    }

    public void setEventReminderList(List<EventReminder> eventReminderList) {
        this.eventReminderList = eventReminderList;
    }

    public List<LinkReminder> getLinkReminderList() {
        return linkReminderList;
    }

    public void setLinkReminderList(List<LinkReminder> linkReminderList) {
        this.linkReminderList = linkReminderList;
    }

    public List<PersonReminder> getPersonReminderList() {
        return personReminderList;
    }

    public void setPersonReminderList(List<PersonReminder> personReminderList) {
        this.personReminderList = personReminderList;
    }

    public List<ExpenseReminder> getExpenseReminderList() {
        return expenseReminderList;
    }

    public void setExpenseReminderList(List<ExpenseReminder> expenseReminderList) {
        this.expenseReminderList = expenseReminderList;
    }

    public List<ExpensesReminder> getExpensesReminderList() {
        return expensesReminderList;
    }

    public void setExpensesReminderList(List<ExpensesReminder> expensesReminderList) {
        this.expensesReminderList = expensesReminderList;
    }

    public List<TransactionReminder> getTransactionReminderList() {
        return transactionReminderList;
    }

    public void setTransactionReminderList(List<TransactionReminder> transactionReminderList) {
        this.transactionReminderList = transactionReminderList;
    }

    public List<AccountReminder> getAccountReminderList() {
        return accountReminderList;
    }

    public void setAccountReminderList(List<AccountReminder> accountReminderList) {
        this.accountReminderList = accountReminderList;
    }

    public List<EmailReminder> getEmailReminderList() {
        return emailReminderList;
    }

    public void setEmailReminderList(List<EmailReminder> emailReminderList) {
        this.emailReminderList = emailReminderList;
    }

    public List<PhoneNumberReminder> getPhoneNumberReminderList() {
        return phoneNumberReminderList;
    }

    public void setPhoneNumberReminderList(List<PhoneNumberReminder> phoneNumberReminderList) {
        this.phoneNumberReminderList = phoneNumberReminderList;
    }

    public List<DatesReminder> getDatesReminderList() {
        return datesReminderList;
    }

    public void setDatesReminderList(List<DatesReminder> datesReminderList) {
        this.datesReminderList = datesReminderList;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reminderDateTime=" + reminderDateTime +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator +
                ", reminderUserList=" + reminderUserList +
                ", reminderSnoozeList=" + reminderSnoozeList +
                ", repeatedReminderList=" + repeatedReminderList +
                ", noteReminderList=" + noteReminderList +
                ", topicReminderList=" + topicReminderList +
                ", taskReminderList=" + taskReminderList +
                ", workReminderList=" + workReminderList +
                ", tasksReminderList=" + tasksReminderList +
                ", eventReminderList=" + eventReminderList +
                ", linkReminderList=" + linkReminderList +
                ", personReminderList=" + personReminderList +
                ", expenseReminderList=" + expenseReminderList +
                ", expensesReminderList=" + expensesReminderList +
                ", transactionReminderList=" + transactionReminderList +
                ", accountReminderList=" + accountReminderList +
                ", emailReminderList=" + emailReminderList +
                ", phoneNumberReminderList=" + phoneNumberReminderList +
                ", datesReminderList=" + datesReminderList +
                '}';
    }
}