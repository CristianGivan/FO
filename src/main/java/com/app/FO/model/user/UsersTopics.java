package com.app.FO.model.user;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users_topics")
public class UsersTopics {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_topics_seq")
    @SequenceGenerator(name = "users_topics_seq",
            sequenceName = "users_topics_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "users_topics_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public UsersTopics() {
    }
    public UsersTopics(User user, Topic topic){
        this.user=user;
        this.topic=topic;
        this.createdDate=LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "UsersTopics{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", topicId=" + topic.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}