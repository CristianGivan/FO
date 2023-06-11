package com.app.FO.model.phoneNumber;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "phoneNumber")
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_seq")
    @SequenceGenerator(name = "phoneNumber_seq",
            sequenceName = "phoneNumber_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "number")
    private String number;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberUser> phoneNumberUserList;

    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberTag> phoneNumberTagList;

    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberReminder> phoneNumberReminderList;

    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberTopic> phoneNumberTopicList;

    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberTasks> phoneNumberTasksList;
    @OneToMany(mappedBy = "phoneNumber", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PhoneNumberHistory> phoneNumberHistoryList;


    public PhoneNumber() {
    }

    public PhoneNumber(String subject, String number, User creator) {
        this.subject = subject;
        this.number = number;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + number + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", phoneNumberUserList=" + phoneNumberUserList +
                ", phoneNumberTopicList=" + phoneNumberTopicList +
                ", phoneNumberTasksList=" + phoneNumberTasksList +
                ", phoneNumberUserList=" + phoneNumberUserList +
                ", phoneNumberTagList=" + phoneNumberTagList +
                ", phoneNumberReminderList=" + phoneNumberReminderList +
                ", phoneNumberHistoryList=" + phoneNumberHistoryList +
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

    public String getNumber() {
        if (number == null) {
            number = "";
        }
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public List<PhoneNumberUser> getPhoneNumberUserList() {
        if (phoneNumberUserList == null) {
            phoneNumberUserList = new ArrayList<>();
        }
        return phoneNumberUserList;
    }

    public void setPhoneNumberUserList(List<PhoneNumberUser> phoneNumberUserList) {
        this.phoneNumberUserList = phoneNumberUserList;
    }

    public List<PhoneNumberTag> getPhoneNumberTagList() {
        if (phoneNumberTagList == null) {
            phoneNumberTagList = new ArrayList<>();
        }
        return phoneNumberTagList;
    }

    public void setPhoneNumberTagList(List<PhoneNumberTag> phoneNumberTagList) {
        this.phoneNumberTagList = phoneNumberTagList;
    }

    public List<PhoneNumberReminder> getPhoneNumberReminderList() {
        if (phoneNumberReminderList == null) {
            phoneNumberReminderList = new ArrayList<>();
        }
        return phoneNumberReminderList;
    }

    public void setPhoneNumberReminderList(List<PhoneNumberReminder> phoneNumberReminderList) {
        this.phoneNumberReminderList = phoneNumberReminderList;
    }


    public List<PhoneNumberTopic> getPhoneNumberTopicList() {
        if (phoneNumberTopicList == null) {
            phoneNumberTopicList = new ArrayList<>();
        }
        return phoneNumberTopicList;
    }

    public void setPhoneNumberTopicList(List<PhoneNumberTopic> phoneNumberTopicList) {
        this.phoneNumberTopicList = phoneNumberTopicList;
    }

    public List<PhoneNumberTasks> getPhoneNumberTasksList() {
        if (phoneNumberTasksList == null) {
            phoneNumberTasksList = new ArrayList<>();
        }
        return phoneNumberTasksList;
    }

    public void setPhoneNumberTasksList(List<PhoneNumberTasks> phoneNumberTasksList) {
        this.phoneNumberTasksList = phoneNumberTasksList;
    }

    public List<PhoneNumberHistory> getPhoneNumberHistoryList() {
        if (phoneNumberHistoryList == null) {
            phoneNumberHistoryList = new ArrayList<>();
        }
        return phoneNumberHistoryList;
    }

    public void setPhoneNumberHistoryList(List<PhoneNumberHistory> phoneNumberHistoryList) {
        this.phoneNumberHistoryList = phoneNumberHistoryList;
    }
}
