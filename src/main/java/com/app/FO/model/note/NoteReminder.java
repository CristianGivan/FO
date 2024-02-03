package com.app.FO.model.note;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_reminder")
public class NoteReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_reminder_seq")
    @SequenceGenerator(name = "note_reminder_seq",
            sequenceName = "note_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;


    public NoteReminder() {
    }

    public NoteReminder(Note note, Reminder reminder) {
        this.note = note;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "noteReminder{" +
                "id=" + id +
                ", noteId=" + note.getId() +
                ", ReminderId=" + reminder.getId() +
                ", createdDate=" + linkDate +
                '}';
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

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
