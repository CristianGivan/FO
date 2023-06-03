package com.app.FO.model.expenses;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "expenses")
public class Expenses {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_seq")
    @SequenceGenerator(name = "expenses_seq",
            sequenceName = "expenses_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "expenses_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesUser> expensesUserList;


    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTopic> expensesTopicList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTasks> expensesTasksList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesReminder> expensesReminderList;

    @OneToMany(mappedBy = "expenses", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesHistory> expensesHistoryList;


    public Expenses() {
    }

    public Expenses(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", expensesUserList=" + expensesUserList +
                ", expensesTopicList=" + expensesTopicList +
                ", expensesTasksList=" + expensesTasksList +
                ", expensesUserList=" + expensesUserList +
                ", expensesTagList=" + expensesTagList +
                ", expensesReminderList=" + expensesReminderList +
                ", expensesHistoryList=" + expensesHistoryList +
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<ExpensesUser> getExpensesUserList() {
        return expensesUserList;
    }

    public void setExpensesUserList(List<ExpensesUser> expensesUserList) {
        this.expensesUserList = expensesUserList;
    }

    public List<ExpensesTag> getExpensesTagList() {
        return expensesTagList;
    }

    public void setExpensesTagList(List<ExpensesTag> expensesTagList) {
        this.expensesTagList = expensesTagList;
    }

    public List<ExpensesReminder> getExpensesReminderList() {
        return expensesReminderList;
    }

    public void setExpensesReminderList(List<ExpensesReminder> expensesReminderList) {
        this.expensesReminderList = expensesReminderList;
    }

    public List<ExpensesHistory> getExpensesHistoryList() {
        return expensesHistoryList;
    }

    public void setExpensesHistoryList(List<ExpensesHistory> expensesHistoryList) {
        this.expensesHistoryList = expensesHistoryList;
    }

    public List<ExpensesTopic> getExpensesTopicList() {
        return expensesTopicList;
    }

    public void setExpensesTopicList(List<ExpensesTopic> expensesTopicList) {
        this.expensesTopicList = expensesTopicList;
    }

    public List<ExpensesTasks> getExpensesTasksList() {
        return expensesTasksList;
    }

    public void setExpensesTasksList(List<ExpensesTasks> expensesTasksList) {
        this.expensesTasksList = expensesTasksList;
    }
}
