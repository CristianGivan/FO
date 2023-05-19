package com.app.FO.model.topic;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_tag")
public class TopicTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_tag_seq")
    @SequenceGenerator(name = "topic_tag_seq",
            sequenceName = "topic_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "created_date")
    private LocalDateTime createdDate;


    public TopicTag() {
    }

    public TopicTag(Topic topic, Tag tag, LocalDateTime createdDate) {
        this.topic = topic;
        this.tag = tag;
        this.createdDate = createdDate;
    }

    @Override
    public String toString() {
        return "NoteTag{" +
                "id=" + id +
                ", topicId=" + topic.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
