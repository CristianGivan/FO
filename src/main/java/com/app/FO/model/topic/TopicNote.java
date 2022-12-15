package com.app.FO.model.topic;

import com.app.FO.model.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_note")
public class TopicNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_note_seq")
    @SequenceGenerator(name = "topic_note_seq",
            sequenceName = "topic_note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_note_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;


    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TopicNote() {
    }

    @Override
    public String toString() {
        return "TopicNote{" +
                "id=" + id +
                ", topicId=" + topic.getId() +
                ", noteId=" + note.getId() +
                ", localDateTime=" + linkDate +
                '}';
    }

    public TopicNote(Topic topic, Note note, LocalDateTime linkDate) {
        this.topic = topic;
        this.note = note;
        this.linkDate = linkDate;
    }

    public Long getId() {
        return id;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime localDateTime) {
        this.linkDate = localDateTime;
    }
}
