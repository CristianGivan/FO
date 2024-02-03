package com.app.FO.model.phoneNumber;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phoneNumber_topic")
public class PhoneNumberTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_topic_seq")
    @SequenceGenerator(name = "phoneNumber_topic_seq",
            sequenceName = "phoneNumber_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "phoneNumber_date")
    private LocalDateTime phoneNumberDate;

    public PhoneNumberTopic() {
    }

    public PhoneNumberTopic(PhoneNumber phoneNumber, Topic topic) {
        this.phoneNumber = phoneNumber;
        this.topic = topic;
        this.phoneNumberDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumberTopic{" +
                "id=" + id +
                ", phoneNumberId=" + phoneNumber.getId() +
                ", topicId=" + topic.getId() +
                ", phoneNumberDate=" + phoneNumberDate +
                '}';
    }
}
