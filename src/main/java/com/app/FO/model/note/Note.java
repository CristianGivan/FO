package com.app.FO.model.note;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.task.TaskNote;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<NoteUser> noteUserList;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<NoteTag> noteTagList;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskNote> taskNoteList;
    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<NoteHistory> noteHistoryList;

    @OneToMany(mappedBy = "note",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainderList;

    public Note() {
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", noteTags=" + noteTagList +
                ", userId=" + creator.getId() +
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
    public Note(String note, User creator, LocalDateTime createdDate) {
        this.note = note;
        this.creator = creator;
        this.createdDate = createdDate;
    }
    public Note(String note, User creator) {
        this.note = note;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public List<TaskNote> getTaskNoteList() {
        return taskNoteList;
    }

    public List<NoteUser> getNoteUserList() {

        if(noteUserList ==null){
            noteUserList =new ArrayList<>();
        }
        return noteUserList;
    }

    public void setNoteUserList(List<NoteUser> noteUserList) {
        this.noteUserList = noteUserList;
    }

    public void setTaskNoteList(List<TaskNote> taskNotes) {
        this.taskNoteList = taskNotes;
    }

    public List<Remainder> getRemainderList() {
        if(remainderList ==null){
            remainderList =new ArrayList<>();
        }
        return remainderList;
    }

    public void setRemainderList(List<Remainder> remainders) {
        this.remainderList = remainders;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<NoteTag> getNoteTagList() {
        if(noteTagList ==null){
            noteTagList =new ArrayList<>();
        }
        return noteTagList;
    }

    public void setNoteTagList(List<NoteTag> noteTags) {
        this.noteTagList = noteTags;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User user) {
        this.creator = user;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<NoteHistory> getNoteHistoryList() {
        if (noteHistoryList ==null){
            noteHistoryList =new ArrayList<>();
        }
        return noteHistoryList;
    }

    public void setNoteHistoryList(List<NoteHistory> noteHistories) {
        this.noteHistoryList = noteHistories;
    }

    public List<TopicNote> getTopicNoteList() {
        if (topicNoteList ==null){
            topicNoteList =new ArrayList<>();
        }
        return topicNoteList;
    }

    public void setTopicNoteList(List<TopicNote> topicNotes) {
        this.topicNoteList = topicNotes;
    }
}
