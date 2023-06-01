package com.app.FO.model.link;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link_topic")
public class LinkTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_topic_seq")
    @SequenceGenerator(name = "link_topic_seq",
            sequenceName = "link_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public LinkTopic() {
    }

    public LinkTopic(Link link, Topic topic) {
        this.link = link;
        this.topic = topic;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LinkTopic{" +
                "id=" + id +
                ", linkId=" + link.getId() +
                ", topicId=" + topic.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
