package com.app.FO.model.topic;

import com.app.FO.model.event.EventTopic;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_seq")
    @SequenceGenerator(name = "topic_seq",
            sequenceName = "topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicTag> topicTagList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "topic")
    private List<TopicUser> usersTopicList;

    @OneToMany(mappedBy = "topic")
    private List<TopicHistory> topicHistoryList;

    @OneToMany(mappedBy = "topic")
    private List<Reminder> reminderList;

    @OneToMany(mappedBy = "topic")
    private List<EventTopic> eventTopicList;

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", topicNotes=" + topicNoteList +
                ", topicTags=" + topicTagList +
                ", userId=" + creator.getId() +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistoryList +
                ", remainders=" + reminderList +
                ", eventTopics=" + eventTopicList +
                '}';
    }

    //todo tnu
    public Topic(String subject, User user, LocalDateTime createdDate) {
        this.subject = subject;
        this.creator = user;
        this.createdDate = createdDate;
    }
    public Topic(String subject, User user) {
        this.subject = subject;
        this.creator = user;
        this.createdDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<TopicNote> getTopicNoteList() {
        if(topicNoteList ==null){
            topicNoteList =new ArrayList<>();
        }
        return topicNoteList;
    }

    public void setTopicNoteList(List<TopicNote> topicNotes) {
        this.topicNoteList = topicNotes;
    }

    public List<TopicTag> getTopicTagList() {
        if (topicTagList ==null){
            topicTagList =new ArrayList<>();
        }
        return topicTagList;
    }

    public List<TopicUser> getUsersTopicList() {
        if (usersTopicList ==null){
            usersTopicList =new ArrayList<>();
        }
        return usersTopicList;
    }

    public void setUsersTopicList(List<TopicUser> usersTopics) {
        this.usersTopicList = usersTopics;
    }

    public void setTopicTagList(List<TopicTag> topicTags) {
        this.topicTagList = topicTags;
    }

    public User getUser() {
        return creator;
    }

    public void setUser(User user) {
        this.creator = user;
    }

    public LocalDateTime getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<TopicHistory> getTopicHistoryList() {
        if (topicHistoryList ==null){
            topicHistoryList =new ArrayList<>();
        }
        return topicHistoryList;
    }

    public void setTopicHistoryList(List<TopicHistory> topicHistory) {
        this.topicHistoryList = topicHistory;
    }

    public List<Reminder> getRemainderList() {
        return reminderList;
    }

    public void setRemainderList(List<Reminder> reminders) {
        this.reminderList = reminders;
    }

    public List<EventTopic> getEventTopicList() {
        return eventTopicList;
    }

    public void setEventTopicList(List<EventTopic> eventTopics) {
        this.eventTopicList = eventTopics;
    }
}
