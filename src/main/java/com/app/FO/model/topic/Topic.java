package com.app.FO.model.topic;

import com.app.FO.model.event.EventTopic;
import com.app.FO.model.task.TaskTopic;
import com.app.FO.model.task.TaskWork;
import com.app.FO.model.tasks.TasksTopic;
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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    //todo tbc
    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTopic> taskTopicList;

    //todo tbc
    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTopic> tasksTopicList;

    //todo tbc One to many or one to one?
    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskWork> taskWorkList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "topic", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicTag> topicTagList;

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
                ", createdDate=" + createdDate +
                ", creator=" + creator.getId() +
                ", taskTopicList=" + taskTopicList +
                ", tasksTopicList=" + tasksTopicList +
                ", taskWorkList=" + taskWorkList +
                ", topicNoteList=" + topicNoteList +
                ", topicTagList=" + topicTagList +
                ", topicUserList=" + topicUserList +
                ", topicReminderList=" + topicReminderList +
                ", eventTopicList=" + eventTopicList +
                ", topicHistoryList=" + topicHistoryList +
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<TaskTopic> getTaskTopicList() {
        return taskTopicList;
    }

    public void setTaskTopicList(List<TaskTopic> taskTopicList) {
        this.taskTopicList = taskTopicList;
    }

    public List<TasksTopic> getTasksTopicList() {
        return tasksTopicList;
    }

    public void setTasksTopicList(List<TasksTopic> tasksTopicList) {
        this.tasksTopicList = tasksTopicList;
    }

    public List<TaskWork> getTaskWorkList() {
        return taskWorkList;
    }

    public void setTaskWorkList(List<TaskWork> taskWorkList) {
        this.taskWorkList = taskWorkList;
    }
}
