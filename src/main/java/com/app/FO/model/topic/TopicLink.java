package com.app.FO.model.topic;

import com.app.FO.model.link.Link;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_link")
public class TopicLink {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_link_seq")
    @SequenceGenerator(name = "topic_link_seq",
            sequenceName = "topic_link_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_link_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @Column(name = "created_date")
    private LocalDateTime createdDate;


    public TopicLink() {
    }

    public TopicLink(Topic topic, Link link) {
        this.topic = topic;
        this.link = link;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "NoteLink{" +
                "id=" + id +
                ", topicId=" + topic.getId() +
                ", linkId=" + link.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Topic getNote() {
        return topic;
    }

    public void setNote(Topic topic) {
        this.topic = topic;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
