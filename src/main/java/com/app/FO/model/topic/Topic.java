package com.app.FO.model.topic;

import com.app.FO.model.event.EventTopic;
import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UsersTopics;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
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
    private List<TopicNote> topicNotes;

    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicTag> topicTags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "topic")
    private List<UsersTopics> usersTopics;

    @OneToMany(mappedBy = "topic")
    private List<TopicHistory> topicHistory;

    @OneToMany(mappedBy = "topic")
    private List<Remainder> remainders;

    @OneToMany(mappedBy = "topic")
    private List<EventTopic> eventTopics;

    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", topicNotes=" + topicNotes +
                ", topicTags=" + topicTags +
                ", userId=" + creator.getId() +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistory +
                ", remainders=" + remainders +
                ", eventTopics=" + eventTopics +
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

    public List<TopicNote> getTopicNotes() {
        if(topicNotes==null){
            topicNotes=new ArrayList<>();
        }
        return topicNotes;
    }

    public void setTopicNotes(List<TopicNote> topicNotes) {
        this.topicNotes = topicNotes;
    }

    public List<TopicTag> getTopicTags() {
        if (topicTags==null){
            topicTags=new ArrayList<>();
        }
        return topicTags;
    }

    public List<UsersTopics> getUsersTopics() {
        if (usersTopics==null){
            usersTopics=new ArrayList<>();
        }
        return usersTopics;
    }

    public void setUsersTopics(List<UsersTopics> usersTopics) {
        this.usersTopics = usersTopics;
    }

    public void setTopicTags(List<TopicTag> topicTags) {
        this.topicTags = topicTags;
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

    public List<TopicHistory> getTopicHistory() {
        if (topicHistory==null){
            topicHistory=new ArrayList<>();
        }
        return topicHistory;
    }

    public void setTopicHistory(List<TopicHistory> topicHistory) {
        this.topicHistory = topicHistory;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }

    public List<EventTopic> getEventTopics() {
        return eventTopics;
    }

    public void setEventTopics(List<EventTopic> eventTopics) {
        this.eventTopics = eventTopics;
    }
}
