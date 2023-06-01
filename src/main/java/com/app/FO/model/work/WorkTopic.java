package com.app.FO.model.work;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_topic")
public class WorkTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_topic_seq")
    @SequenceGenerator(name = "work_topic_seq",
            sequenceName = "work_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "work_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public WorkTopic() {
    }

    public WorkTopic(Work work, Topic topic) {
        this.work = work;
        this.topic = topic;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "WorkTopic{" +
                "id=" + id +
                ", workId=" + work.getId() +
                ", topicId=" + topic.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
