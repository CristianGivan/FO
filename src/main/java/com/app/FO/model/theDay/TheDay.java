package com.app.FO.model.theDay;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "the_day")
public class TheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_seq")
    @SequenceGenerator(name = "the_day_seq",
            sequenceName = "the_day_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "day")
    private String day;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayUser> theDayUserList;

    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayTag> theDayTagList;

    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayReminder> theDayReminderList;

    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayTopic> theDayTopicList;

    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayTasks> theDayTasksList;
    @OneToMany(mappedBy = "the_day", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TheDayHistory> theDayHistoryList;


    public TheDay() {
    }

    public TheDay(String subject, String day, User creator) {
        this.subject = subject;
        this.day = day;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDay{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + day + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", theDayUserList=" + theDayUserList +
                ", theDayTopicList=" + theDayTopicList +
                ", theDayTasksList=" + theDayTasksList +
                ", theDayUserList=" + theDayUserList +
                ", theDayTagList=" + theDayTagList +
                ", theDayReminderList=" + theDayReminderList +
                ", theDayHistoryList=" + theDayHistoryList +
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

    public String getDay() {
        if (day == null) {
            day = "";
        }
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public List<TheDayUser> getTheDayUserList() {
        if (theDayUserList == null) {
            theDayUserList = new ArrayList<>();
        }
        return theDayUserList;
    }

    public void setTheDayUserList(List<TheDayUser> theDayUserList) {
        this.theDayUserList = theDayUserList;
    }

    public List<TheDayTag> getTheDayTagList() {
        if (theDayTagList == null) {
            theDayTagList = new ArrayList<>();
        }
        return theDayTagList;
    }

    public void setTheDayTagList(List<TheDayTag> theDayTagList) {
        this.theDayTagList = theDayTagList;
    }

    public List<TheDayReminder> getTheDayReminderList() {
        if (theDayReminderList == null) {
            theDayReminderList = new ArrayList<>();
        }
        return theDayReminderList;
    }

    public void setTheDayReminderList(List<TheDayReminder> theDayReminderList) {
        this.theDayReminderList = theDayReminderList;
    }


    public List<TheDayTopic> getTheDayTopicList() {
        if (theDayTopicList == null) {
            theDayTopicList = new ArrayList<>();
        }
        return theDayTopicList;
    }

    public void setTheDayTopicList(List<TheDayTopic> theDayTopicList) {
        this.theDayTopicList = theDayTopicList;
    }

    public List<TheDayTasks> getTheDayTasksList() {
        if (theDayTasksList == null) {
            theDayTasksList = new ArrayList<>();
        }
        return theDayTasksList;
    }

    public void setTheDayTasksList(List<TheDayTasks> theDayTasksList) {
        this.theDayTasksList = theDayTasksList;
    }

    public List<TheDayHistory> getTheDayHistoryList() {
        if (theDayHistoryList == null) {
            theDayHistoryList = new ArrayList<>();
        }
        return theDayHistoryList;
    }

    public void setTheDayHistoryList(List<TheDayHistory> theDayHistoryList) {
        this.theDayHistoryList = theDayHistoryList;
    }
}
