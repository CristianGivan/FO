package com.app.FO.model.person;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_topic")
public class PersonTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_topic_seq")
    @SequenceGenerator(name = "person_topic_seq",
            sequenceName = "person_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonTopic() {
    }

    public PersonTopic(Person person, Topic topic) {
        this.person = person;
        this.topic = topic;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonTopic{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", topicId=" + topic.getId() +
                ", personDate=" + personDate +
                '}';
    }
}
