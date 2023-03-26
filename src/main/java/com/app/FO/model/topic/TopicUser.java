package com.app.FO.model.topic;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_user")
public class TopicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_user_seq")
    @SequenceGenerator(name = "topic_user_seq",
            sequenceName = "topic_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public TopicUser() {
    }
    public TopicUser(User user, Topic topic){
        this.user=user;
        this.topic=topic;
        this.createdDate=LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "TopicUser{" +
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