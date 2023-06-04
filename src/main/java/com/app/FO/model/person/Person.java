package com.app.FO.model.person;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq",
            sequenceName = "person_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonUser> personUserList;


    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTopic> personTopicList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTasks> personTasksList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTag> personTagList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonReminder> personReminderList;

    @OneToMany(mappedBy = "person", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonHistory> personHistoryList;


    public Person() {
    }

    public Person(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", personUserList=" + personUserList +
                ", personTopicList=" + personTopicList +
                ", personTasksList=" + personTasksList +
                ", personUserList=" + personUserList +
                ", personTagList=" + personTagList +
                ", personReminderList=" + personReminderList +
                ", personHistoryList=" + personHistoryList +
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

    public List<PersonUser> getPersonUserList() {
        return personUserList;
    }

    public void setPersonUserList(List<PersonUser> personUserList) {
        this.personUserList = personUserList;
    }

    public List<PersonTag> getPersonTagList() {
        return personTagList;
    }

    public void setPersonTagList(List<PersonTag> personTagList) {
        this.personTagList = personTagList;
    }

    public List<PersonReminder> getPersonReminderList() {
        return personReminderList;
    }

    public void setPersonReminderList(List<PersonReminder> personReminderList) {
        this.personReminderList = personReminderList;
    }

    public List<PersonHistory> getPersonHistoryList() {
        return personHistoryList;
    }

    public void setPersonHistoryList(List<PersonHistory> personHistoryList) {
        this.personHistoryList = personHistoryList;
    }

    public List<PersonTopic> getPersonTopicList() {
        return personTopicList;
    }

    public void setPersonTopicList(List<PersonTopic> personTopicList) {
        this.personTopicList = personTopicList;
    }

    public List<PersonTasks> getPersonTasksList() {
        return personTasksList;
    }

    public void setPersonTasksList(List<PersonTasks> personTasksList) {
        this.personTasksList = personTasksList;
    }
}
