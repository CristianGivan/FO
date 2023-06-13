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
    @Column(name = "reference")
    private String reference;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesUser> datesUserList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesTag> datesTagList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesReminder> datesReminderList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesTopic> datesTopicList;

    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesTasks> datesTasksList;
    @OneToMany(mappedBy = "dates", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DatesHistory> datesHistoryList;


    public Dates() {
    }

    public Dates(String subject, User creator) {
        this.subject = subject;
        this.reference = reference;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Dates{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + reference + '\'' +
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
        if (reference == null) {
            reference = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReference() {
        if (reference == null) {
            reference = "";
        }
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public List<DatesUser> getDatesUserList() {
        if (datesUserList == null) {
            datesUserList = new ArrayList<>();
        }
        return datesUserList;
    }

    public void setDatesUserList(List<DatesUser> datesUserList) {
        this.datesUserList = datesUserList;
    }

    public List<DatesTag> getDatesTagList() {
        if (datesTagList == null) {
            datesTagList = new ArrayList<>();
        }
        return datesTagList;
    }

    public void setDatesTagList(List<DatesTag> datesTagList) {
        this.datesTagList = datesTagList;
    }

    public List<DatesReminder> getDatesReminderList() {
        if (datesReminderList == null) {
            datesReminderList = new ArrayList<>();
        }
        return datesReminderList;
    }

    public void setDatesReminderList(List<DatesReminder> datesReminderList) {
        this.datesReminderList = datesReminderList;
    }


    public List<DatesTopic> getDatesTopicList() {
        if (datesTopicList == null) {
            datesTopicList = new ArrayList<>();
        }
        return datesTopicList;
    }

    public void setDatesTopicList(List<DatesTopic> datesTopicList) {
        this.datesTopicList = datesTopicList;
    }

    public List<DatesTasks> getDatesTasksList() {
        if (datesTasksList == null) {
            datesTasksList = new ArrayList<>();
        }
        return datesTasksList;
    }

    public void setDatesTasksList(List<DatesTasks> datesTasksList) {
        this.datesTasksList = datesTasksList;
    }

    public List<DatesHistory> getDatesHistoryList() {
        if (datesHistoryList == null) {
            datesHistoryList = new ArrayList<>();
        }
        return datesHistoryList;
    }

    public void setDatesHistoryList(List<DatesHistory> datesHistoryList) {
        this.datesHistoryList = datesHistoryList;
    }
}
