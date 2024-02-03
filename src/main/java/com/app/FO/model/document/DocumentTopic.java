package com.app.FO.model.document;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_topic")
public class DocumentTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_topic_seq")
    @SequenceGenerator(name = "document_topic_seq",
            sequenceName = "document_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    public DocumentTopic() {
    }

    public DocumentTopic(Document document, Topic topic) {
        this.document = document;
        this.topic = topic;
        this.documentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DocumentTopic{" +
                "id=" + id +
                ", documentId=" + document.getId() +
                ", topicId=" + topic.getId() +
                ", documentDate=" + documentDate +
                '}';
    }
}
