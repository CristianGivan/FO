package com.app.FO.model.note;

import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_user")
public class NoteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_user_seq")
    @SequenceGenerator(name = "note_user_seq",
            sequenceName = "note_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public NoteUser() {
    }
    public NoteUser(Note note, User user){
        this.note=note;
        this.user=user;
        this.createdDate=LocalDateTime.now();
    }


    @Override
    public String toString() {
        return "TopicUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", noteId=" + note.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}