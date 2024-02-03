package com.app.FO.model.email;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "email")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_seq")
    @SequenceGenerator(name = "email_seq",
            sequenceName = "email_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "email_address")
    private String emailAddress;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailUser> emailUserList;

    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailTag> emailTagList;

    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailReminder> emailReminderList;

    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailTopic> emailTopicList;

    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailTasks> emailTasksList;
    @OneToMany(mappedBy = "email", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EmailHistory> emailHistoryList;


    public Email() {
    }

    public Email(String subject, String emailAddress, User creator) {
        this.subject = subject;
        this.emailAddress = emailAddress;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + emailAddress + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", emailUserList=" + emailUserList +
                ", emailTopicList=" + emailTopicList +
                ", emailTasksList=" + emailTasksList +
                ", emailUserList=" + emailUserList +
                ", emailTagList=" + emailTagList +
                ", emailReminderList=" + emailReminderList +
                ", emailHistoryList=" + emailHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if (subject == null) {
            subject = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailAddress() {
        if (emailAddress == null) {
            emailAddress = "";
        }
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
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

    public List<EmailUser> getEmailUserList() {
        if (emailUserList == null) {
            emailUserList = new ArrayList<>();
        }
        return emailUserList;
    }

    public void setEmailUserList(List<EmailUser> emailUserList) {
        this.emailUserList = emailUserList;
    }

    public List<EmailTag> getEmailTagList() {
        if (emailTagList == null) {
            emailTagList = new ArrayList<>();
        }
        return emailTagList;
    }

    public void setEmailTagList(List<EmailTag> emailTagList) {
        this.emailTagList = emailTagList;
    }


    public List<EmailReminder> getEmailReminderList() {
        if (emailReminderList == null) {
            emailReminderList = new ArrayList<>();
        }
        return emailReminderList;
    }

    public void setEmailReminderList(List<EmailReminder> emailReminderList) {
        this.emailReminderList = emailReminderList;
    }


    public List<EmailTopic> getEmailTopicList() {
        if (emailTopicList == null) {
            emailTopicList = new ArrayList<>();
        }
        return emailTopicList;
    }

    public void setEmailTopicList(List<EmailTopic> emailTopicList) {
        this.emailTopicList = emailTopicList;
    }

    public List<EmailTasks> getEmailTasksList() {
        if (emailTasksList == null) {
            emailTasksList = new ArrayList<>();
        }
        return emailTasksList;
    }

    public void setEmailTasksList(List<EmailTasks> emailTasksList) {
        this.emailTasksList = emailTasksList;
    }

    public List<EmailHistory> getEmailHistoryList() {
        if (emailHistoryList == null) {
            emailHistoryList = new ArrayList<>();
        }
        return emailHistoryList;
    }

    public void setEmailHistoryList(List<EmailHistory> emailHistoryList) {
        this.emailHistoryList = emailHistoryList;
    }
}
