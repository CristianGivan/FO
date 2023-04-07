package com.app.FO.model.event;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_topic")
@Getter
@Setter
@NoArgsConstructor
public class EventTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_topic_seq")
    @SequenceGenerator(name = "event_topic_seq",
            sequenceName = "event_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_topic_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "EventTopic{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", topicId=" + topic.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
