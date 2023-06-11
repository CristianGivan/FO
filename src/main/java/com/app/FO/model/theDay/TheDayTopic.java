package com.app.FO.model.theDay;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_topic")
public class TheDayTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_topic_seq")
    @SequenceGenerator(name = "the_day_topic_seq",
            sequenceName = "the_day_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "the_day_date")
    private LocalDateTime theDayDate;

    public TheDayTopic() {
    }

    public TheDayTopic(TheDay theDay, Topic topic) {
        this.theDay = theDay;
        this.topic = topic;
        this.theDayDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDayTopic{" +
                "id=" + id +
                ", theDayId=" + theDay.getId() +
                ", topicId=" + topic.getId() +
                ", theDayDate=" + theDayDate +
                '}';
    }
}
