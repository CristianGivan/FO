package com.app.FO.model.email;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_topic")
public class EmailTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_topic_seq")
    @SequenceGenerator(name = "email_topic_seq",
            sequenceName = "email_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "email_date")
    private LocalDateTime emailDate;

    public EmailTopic() {
    }

    public EmailTopic(Email email, Topic topic) {
        this.email = email;
        this.topic = topic;
        this.emailDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmailTopic{" +
                "id=" + id +
                ", emailId=" + email.getId() +
                ", topicId=" + topic.getId() +
                ", emailDate=" + emailDate +
                '}';
    }
}
