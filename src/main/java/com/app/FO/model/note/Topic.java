package com.app.FO.model.note;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @OneToMany(mappedBy = "topic")
    private List<TopicNote> topicNotes;

    @OneToMany(mappedBy = "topic")
    private List<TopicTag> topicTags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "create_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "topic")
    private List<TopicHistory> topicHistory;


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
        return topicNotes;
    }

    public void setTopicNotes(List<TopicNote> topicNotes) {
        this.topicNotes = topicNotes;
    }

    public List<TopicTag> getTopicTags() {
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
        return topicHistory;
    }

    public void setTopicHistory(List<TopicHistory> topicHistory) {
        this.topicHistory = topicHistory;
    }
}
