package com.app.FO.model.note;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.task.TaskNote;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "note")
@Getter
@Setter
@NoArgsConstructor
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq",
            sequenceName = "note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "note")
    private String note;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteTag> noteTagList;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "note", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "note", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskNote> taskNoteList;

    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy = "note", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteHistory> noteHistoryList;

    @OneToMany(mappedBy = "note", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Remainder> remainderList;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", noteTags=" + noteTagList +
                ", userId=" + user.getId() +
                ", createdDate=" + createdDate +
                ", topicNotes=" + topicNoteList +
                ", taskNotes=" + taskNoteList +
                ", noteHistories=" + noteHistoryList +
                ", remainders=" + remainderList +
                '}';
    }

    public Note(String note) {
        this.note = note;
    }

    //todo tbdel
    public Note(String note, User user, LocalDateTime createdDate) {
        this.note = note;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Note(String note, User user) {
        this.note = note;
        this.user = user;
        this.createdDate = LocalDateTime.now();
    }


    public List<NoteTag> getNoteTagList() {
        if (noteTagList == null) {
            noteTagList = new ArrayList<>();
        }
        return noteTagList;
    }

    public List<NoteHistory> getNoteHistoryList() {
        if (noteHistoryList == null) {
            noteHistoryList = new ArrayList<>();
        }
        return noteHistoryList;
    }

    public List<TopicNote> getTopicNoteList() {
        if (topicNoteList == null) {
            topicNoteList = new ArrayList<>();
        }
        return topicNoteList;
    }
}
