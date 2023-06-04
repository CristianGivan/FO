package com.app.FO.model.event;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq",
            sequenceName = "event_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventUser> eventUserList;


    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTopic> eventTopicList;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTasks> eventTasksList;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTag> eventTagList;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventReminder> eventReminderList;

    @OneToMany(mappedBy = "event", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventHistory> eventHistoryList;


    public Event() {
    }

    public Event(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", eventUserList=" + eventUserList +
                ", eventTopicList=" + eventTopicList +
                ", eventTasksList=" + eventTasksList +
                ", eventUserList=" + eventUserList +
                ", eventTagList=" + eventTagList +
                ", eventReminderList=" + eventReminderList +
                ", eventHistoryList=" + eventHistoryList +
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

    public List<EventUser> getEventUserList() {
        return eventUserList;
    }

    public void setEventUserList(List<EventUser> eventUserList) {
        this.eventUserList = eventUserList;
    }

    public List<EventTag> getEventTagList() {
        return eventTagList;
    }

    public void setEventTagList(List<EventTag> eventTagList) {
        this.eventTagList = eventTagList;
    }

    public List<EventReminder> getEventReminderList() {
        return eventReminderList;
    }

    public void setEventReminderList(List<EventReminder> eventReminderList) {
        this.eventReminderList = eventReminderList;
    }

    public List<EventHistory> getEventHistoryList() {
        return eventHistoryList;
    }

    public void setEventHistoryList(List<EventHistory> eventHistoryList) {
        this.eventHistoryList = eventHistoryList;
    }

    public List<EventTopic> getEventTopicList() {
        return eventTopicList;
    }

    public void setEventTopicList(List<EventTopic> eventTopicList) {
        this.eventTopicList = eventTopicList;
    }

    public List<EventTasks> getEventTasksList() {
        return eventTasksList;
    }

    public void setEventTasksList(List<EventTasks> eventTasksList) {
        this.eventTasksList = eventTasksList;
    }
}
