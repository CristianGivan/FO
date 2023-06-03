package com.app.FO.model.account;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq",
            sequenceName = "account_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "account_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountUser> accountUserList;


    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTopic> accountTopicList;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTasks> accountTasksList;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTag> accountTagList;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountReminder> accountReminderList;

    @OneToMany(mappedBy = "account", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountHistory> accountHistoryList;


    public Account() {
    }

    public Account(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", accountUserList=" + accountUserList +
                ", accountTopicList=" + accountTopicList +
                ", accountTasksList=" + accountTasksList +
                ", accountUserList=" + accountUserList +
                ", accountTagList=" + accountTagList +
                ", accountReminderList=" + accountReminderList +
                ", accountHistoryList=" + accountHistoryList +
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

    public List<AccountUser> getAccountUserList() {
        return accountUserList;
    }

    public void setAccountUserList(List<AccountUser> accountUserList) {
        this.accountUserList = accountUserList;
    }

    public List<AccountTag> getAccountTagList() {
        return accountTagList;
    }

    public void setAccountTagList(List<AccountTag> accountTagList) {
        this.accountTagList = accountTagList;
    }

    public List<AccountReminder> getAccountReminderList() {
        return accountReminderList;
    }

    public void setAccountReminderList(List<AccountReminder> accountReminderList) {
        this.accountReminderList = accountReminderList;
    }

    public List<AccountHistory> getAccountHistoryList() {
        return accountHistoryList;
    }

    public void setAccountHistoryList(List<AccountHistory> accountHistoryList) {
        this.accountHistoryList = accountHistoryList;
    }

    public List<AccountTopic> getAccountTopicList() {
        return accountTopicList;
    }

    public void setAccountTopicList(List<AccountTopic> accountTopicList) {
        this.accountTopicList = accountTopicList;
    }

    public List<AccountTasks> getAccountTasksList() {
        return accountTasksList;
    }

    public void setAccountTasksList(List<AccountTasks> accountTasksList) {
        this.accountTasksList = accountTasksList;
    }
}
