package com.app.FO.model.note;

import com.app.FO.model.history.NoteHistory;
import com.app.FO.model.history.TopicHistory;
import com.app.FO.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq",
            sequenceName = "note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_id")
    private Long id;

    @Column(name = "note")
    private String note;

    @OneToMany(mappedBy = "note")
    private List<NoteTag> noteTags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "note")
    private List<NoteHistory> noteHistories;


    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;




    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", noteTags=" + noteTags +
                ", createdDate=" + createdDate +
                ", noteHistories=" + noteHistories +
                ", topic=" + topic +
                '}';
    }

    public Long getId() {
        return id;
    }


    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
