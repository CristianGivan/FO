package com.app.FO.model.dates;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dates")
public class Dates {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_seq")
    @SequenceGenerator(name = "dates_seq",
            sequenceName = "dates_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "dates_date)")
    private String datesDate;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesUser> datesUserList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesTag> datesTagList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesReminder> datesReminderList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesTopic> datesTopicList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesTasks> datesTasksList;
    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<com.app.FO.model.dates.DatesHistory> datesHistoryList;


    public Dates() {
    }


    public Dates(String subject, String datesDate, User creator) {
        this.subject = subject;
        this.datesDate = datesDate;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Dates{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + datesDate + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", datesUserList=" + datesUserList +
                ", datesTopicList=" + datesTopicList +
                ", datesTasksList=" + datesTasksList +
                ", datesUserList=" + datesUserList +
                ", datesTagList=" + datesTagList +
                ", datesReminderList=" + datesReminderList +
                ", datesHistoryList=" + datesHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if (datesDate == null) {
            datesDate = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDatesDate() {
        if (datesDate == null) {
            datesDate = "";
        }
        return datesDate;
    }

    public void setDatesDate(String datesDate) {
        this.datesDate = datesDate;
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

    public List<com.app.FO.model.dates.DatesUser> getDatesUserList() {
        if (datesUserList == null) {
            datesUserList = new ArrayList<>();
        }
        return datesUserList;
    }

    public void setDatesUserList(List<com.app.FO.model.dates.DatesUser> datesUserList) {
        this.datesUserList = datesUserList;
    }

    public List<com.app.FO.model.dates.DatesTag> getDatesTagList() {
        if (datesTagList == null) {
            datesTagList = new ArrayList<>();
        }
        return datesTagList;
    }

    public void setDatesTagList(List<com.app.FO.model.dates.DatesTag> datesTagList) {
        this.datesTagList = datesTagList;
    }

    public List<com.app.FO.model.dates.DatesReminder> getDatesReminderList() {
        if (datesReminderList == null) {
            datesReminderList = new ArrayList<>();
        }
        return datesReminderList;
    }

    public void setDatesReminderList(List<com.app.FO.model.dates.DatesReminder> datesReminderList) {
        this.datesReminderList = datesReminderList;
    }


    public List<com.app.FO.model.dates.DatesTopic> getDatesTopicList() {
        if (datesTopicList == null) {
            datesTopicList = new ArrayList<>();
        }
        return datesTopicList;
    }

    public void setDatesTopicList(List<com.app.FO.model.dates.DatesTopic> datesTopicList) {
        this.datesTopicList = datesTopicList;
    }

    public List<com.app.FO.model.dates.DatesTasks> getDatesTasksList() {
        if (datesTasksList == null) {
            datesTasksList = new ArrayList<>();
        }
        return datesTasksList;
    }

    public void setDatesTasksList(List<com.app.FO.model.dates.DatesTasks> datesTasksList) {
        this.datesTasksList = datesTasksList;
    }

    public List<com.app.FO.model.dates.DatesHistory> getDatesHistoryList() {
        if (datesHistoryList == null) {
            datesHistoryList = new ArrayList<>();
        }
        return datesHistoryList;
    }

    public void setDatesHistoryList(List<com.app.FO.model.dates.DatesHistory> datesHistoryList) {
        this.datesHistoryList = datesHistoryList;
    }
}
