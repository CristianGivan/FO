package com.app.FO.model.topic;

import com.app.FO.model.event.EventTopic;
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

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicTag> topicTagList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicUser> topicUserList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicReminder> topicReminderList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTopic> eventTopicList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicHistory> topicHistoryList;

    public Topic() {
    }


    public Topic(String subject, User user) {
        this.subject = subject;
        this.creator = user;
        this.createdDate = LocalDateTime.now();
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
                ", topicReminderList=" + topicReminderList +
                ", eventTopics=" + eventTopicList +
                '}';
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
        if (topicNoteList == null) {
            topicNoteList = new ArrayList<>();
        }
        return topicNoteList;
    }

    public void setTopicNoteList(List<TopicNote> topicNotes) {
        this.topicNoteList = topicNotes;
    }

    public List<TopicTag> getTopicTagList() {
        if (topicTagList == null) {
            topicTagList = new ArrayList<>();
        }
        return topicTagList;
    }

    public void setTopicTagList(List<TopicTag> topicTags) {
        this.topicTagList = topicTags;
    }

    public List<TopicUser> getTopicUserList() {
        if (topicUserList == null) {
            topicUserList = new ArrayList<>();
        }
        return topicUserList;
    }

    public void setTopicUserList(List<TopicUser> usersTopics) {
        this.topicUserList = usersTopics;
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
        if (topicHistoryList == null) {
            topicHistoryList = new ArrayList<>();
        }
        return topicHistoryList;
    }

    public void setTopicHistoryList(List<TopicHistory> topicHistory) {
        this.topicHistoryList = topicHistory;
    }

    public List<TopicReminder> getTopicReminderList() {
        if (topicReminderList == null) {
            topicReminderList = new ArrayList<>();
        }
        return topicReminderList;
    }

    public void setTopicReminderList(List<TopicReminder> reminders) {
        this.topicReminderList = reminders;
    }

    public List<EventTopic> getEventTopicList() {
        return eventTopicList;
    }

    public void setEventTopicList(List<EventTopic> eventTopics) {
        this.eventTopicList = eventTopics;
    }
}
