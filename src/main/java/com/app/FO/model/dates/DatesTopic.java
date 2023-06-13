package com.app.FO.model.dates;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_topic")
public class DatesTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_topic_seq")
    @SequenceGenerator(name = "dates_topic_seq",
            sequenceName = "dates_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "dates_date")
    private LocalDateTime datesDate;

    public DatesTopic() {
    }

    public DatesTopic(Dates dates, Topic topic) {
        this.dates = dates;
        this.topic = topic;
        this.datesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DatesTopic{" +
                "id=" + id +
                ", datesId=" + dates.getId() +
                ", topicId=" + topic.getId() +
                ", datesDate=" + datesDate +
                '}';
    }
}
