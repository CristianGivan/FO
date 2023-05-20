package com.app.FO.model.note;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_remainder")
public class NoteReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_remainder_seq")
    @SequenceGenerator(name = "note_remainder_seq",
            sequenceName = "note_remainder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_remainder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "remainder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;


    public NoteReminder() {
    }

    @Override
    public String toString() {
        return "noteRemainder{" +
                "id=" + id +
                ", noteId=" + note.getId() +
                ", remainderId=" + reminder.getId() +
                ", createdDate=" + linkDate +
                '}';
    }

    public NoteReminder(Note note, Reminder reminder) {
        this.note = note;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Reminder getRemainder() {
        return reminder;
    }

    public void setRemainder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
