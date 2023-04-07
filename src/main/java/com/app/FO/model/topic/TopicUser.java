package com.app.FO.model.topic;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_user")
@Getter
@Setter
@NoArgsConstructor
public class TopicUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_user_seq")
    @SequenceGenerator(name = "topic_user_seq",
            sequenceName = "topic_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_user_id")
    @Setter(AccessLevel.NONE)
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
}