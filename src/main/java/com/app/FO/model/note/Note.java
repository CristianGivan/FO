package com.app.FO.model.note;

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

    @Column(name = "note_text")
    private String noteText;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteUser> noteUserList;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteTag> noteTagList;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteReminder> noteReminderList;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicNote> topicNoteList;

    @OneToMany(mappedBy = "note", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteHistory> noteHistoryList;

    public Note() {
    }

    public Note(String noteText) {
        this.noteText = noteText;
    }

    //todo tbdel
    public Note(String noteText, User creator, LocalDateTime createdDateTime) {
        this.noteText = noteText;
        this.creator = creator;
        this.createdDateTime = createdDateTime;
    }

    public Note(String noteText, User creator) {
        this.noteText = noteText;
        this.creator = creator;
        this.createdDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", noteText='" + noteText + '\'' +
                ", createdDate=" + createdDateTime +
                ", creator=" + creator.getId() +
                ", noteUserList=" + noteUserList +
                ", noteTagList=" + noteTagList +
                ", topicNoteList=" + topicNoteList +
                ", noteReminderList=" + noteReminderList +
                ", noteHistoryList=" + noteHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }


    public List<NoteUser> getNoteUserList() {

        if (noteUserList == null) {
            noteUserList = new ArrayList<>();
        }
        return noteUserList;
    }

    public void setNoteUserList(List<NoteUser> noteUserList) {
        this.noteUserList = noteUserList;
    }


    public List<NoteReminder> getNoteRemainderList() {
        if (noteReminderList == null) {
            noteReminderList = new ArrayList<>();
        }
        return noteReminderList;
    }

    public void setNoteRemainderList(List<NoteReminder> noteReminderList) {
        this.noteReminderList = noteReminderList;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String note) {
        this.noteText = note;
    }

    public List<NoteTag> getNoteTagList() {
        if (noteTagList == null) {
            noteTagList = new ArrayList<>();
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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDate) {
        this.createdDateTime = createdDate;
    }

    public List<TopicNote> getTopicNoteList() {
        if (topicNoteList == null) {
            topicNoteList = new ArrayList<>();
        }
        return topicNoteList;
    }

    public void setTopicNoteList(List<TopicNote> topicNotes) {
        this.topicNoteList = topicNotes;
    }


    public List<NoteHistory> getNoteHistoryList() {
        if (noteHistoryList == null) {
            noteHistoryList = new ArrayList<>();
        }
        return noteHistoryList;
    }

    public void setNoteHistoryList(List<NoteHistory> noteHistories) {
        this.noteHistoryList = noteHistories;
    }

}
