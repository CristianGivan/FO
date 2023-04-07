package com.app.FO.model.topic;

import com.app.FO.model.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_note")
@Getter
@Setter
@NoArgsConstructor
public class TopicNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_note_seq")
    @SequenceGenerator(name = "topic_note_seq",
            sequenceName = "topic_note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_note_id")
    @Setter(AccessLevel.NONE)
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

    public TopicNote(Topic topic, Note note) {
        this.topic = topic;
        this.note = note;
        this.linkDate =LocalDateTime.now();
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
}
