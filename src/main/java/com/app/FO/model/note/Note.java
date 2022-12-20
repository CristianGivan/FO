package com.app.FO.model.note;

import com.app.FO.model.Remainder;
import com.app.FO.model.task.TaskNote;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "notes")
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

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<NoteTag> noteTags;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
   // @JoinColumn(name = "note")
    private List<TopicNote> topicNotes;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    // @JoinColumn(name = "note")
    private List<TaskNote> taskNotes;
    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<NoteHistory> noteHistories;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainders;

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", noteTags=" + noteTags +
                ", userId=" + user.getId() +
                ", createdDate=" + createdDate +
                ", topicNotes=" + topicNotes +
                ", taskNotes=" + taskNotes +
                ", noteHistories=" + noteHistories +
                ", remainders=" + remainders +
                '}';
    }

    public Note(String note) {
        this.note = note;
    }

    public Note(String note, User user, LocalDateTime createdDate) {
        this.note = note;
        this.user = user;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public List<TaskNote> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(List<TaskNote> taskNotes) {
        this.taskNotes = taskNotes;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<NoteTag> getNoteTags() {
        if(noteTags==null){
            noteTags=new ArrayList<>();
        }
        return noteTags;
    }

    public void setNoteTags(List<NoteTag> noteTags) {
        this.noteTags = noteTags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<NoteHistory> getNoteHistories() {
        if (noteHistories==null){
            noteHistories=new ArrayList<>();
        }
        return noteHistories;
    }

    public void setNoteHistories(List<NoteHistory> noteHistories) {
        this.noteHistories = noteHistories;
    }

    public List<TopicNote> getTopicNotes() {
        return topicNotes;
    }

    public void setTopicNotes(List<TopicNote> topicNotes) {
        this.topicNotes = topicNotes;
    }
}
