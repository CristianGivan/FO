package com.app.FO.model.reminder;

import com.app.FO.model.account.Account;
import com.app.FO.model.dates.Dates;
import com.app.FO.model.email.Email;
import com.app.FO.model.event.Event;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.link.Link;
import com.app.FO.model.note.Note;
import com.app.FO.model.person.Person;
import com.app.FO.model.phoneNumber.PhoneNumber;
import com.app.FO.model.task.Task;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.transaction.Transaction;
import com.app.FO.model.user.User;
import com.app.FO.model.work.Work;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @Column(name = "reminder")
    private String subject;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "data_time")
    private LocalDateTime reminderDateTime;

    //is a table mostly for statistics
    @OneToMany(mappedBy = "reminder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Snooze> snoozes;

    //todo ar putea fi un tabel de legatura?
    @OneToMany
    @JoinColumn(name = "repeated_reminders")
    private List<Reminder> repeatedReminderList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "expense_id")
    @JsonIgnore
    private Expense expense;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "expenses_id")
    @JsonIgnore
    private Expenses expenses;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "transaction_id")
    @JsonIgnore
    private Transaction transaction;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "account_id")
    @JsonIgnore
    private Account account;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    public Reminder() {
    }

    public Reminder(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDateTime = LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", reminder='" + subject + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", reminderDateTime=" + reminderDateTime +
                ", snoozes=" + snoozes +
                ", repeatedReminderList=" + repeatedReminderList +
                ", creator=" + creator +
                ", note=" + note +
                ", topic=" + topic +
                ", task=" + task +
                ", work=" + work +
                ", tasks=" + tasks +
                ", event=" + event +
                ", link=" + link +
                ", person=" + person +
                ", expense=" + expense +
                ", expenses=" + expenses +
                ", transaction=" + transaction +
                ", account=" + account +
                ", email=" + email +
                ", phoneNumber=" + phoneNumber +
                ", dates=" + dates +
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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public List<Snooze> getSnoozes() {
        return snoozes;
    }

    public void setSnoozes(List<Snooze> snoozes) {
        this.snoozes = snoozes;
    }

    public List<Reminder> getRepeatedReminderList() {
        return repeatedReminderList;
    }

    public void setRepeatedReminderList(List<Reminder> repeatedReminderList) {
        this.repeatedReminderList = repeatedReminderList;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Expense getExpense() {
        return expense;
    }

    public void setExpense(Expense expense) {
        this.expense = expense;
    }

    public Expenses getExpenses() {
        return expenses;
    }

    public void setExpenses(Expenses expenses) {
        this.expenses = expenses;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}