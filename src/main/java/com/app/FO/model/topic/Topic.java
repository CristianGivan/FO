package com.app.FO.model.topic;

import com.app.FO.model.Remainder;
import com.app.FO.model.user.User;
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

    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicNote> topicNotes;

    @OneToMany(mappedBy = "topic",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicTag> topicTags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "topic")
    private List<TopicHistory> topicHistory;

    @OneToMany(mappedBy = "topic")
    private List<Remainder> remainders;


    public Topic() {
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", topicNotes=" + topicNotes +
                ", topicTags=" + topicTags +
                ", userId=" + user.getId() +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistory +
                '}';
    }

    public Topic(String subject, User user, LocalDateTime createdDate) {
        this.subject = subject;
        this.user = user;
        this.createdDate = createdDate;
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

    public void setTopicTags(List<TopicTag> topicTags) {
        this.topicTags = topicTags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}
