package com.app.FO.model.note;

import com.app.FO.model.remainder.Remainder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_remainder")
public class NoteRemainder {
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
    private Remainder remainder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;


    public NoteRemainder() {
    }

    @Override
    public String toString() {
        return "noteRemainder{" +
                "id=" + id +
                ", noteId=" + note.getId() +
                ", remainderId=" + remainder.getId() +
                ", createdDate=" + linkDate +
                '}';
    }

    public NoteRemainder(Note note, Remainder remainder) {
        this.note = note;
        this.remainder = remainder;
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

    public Remainder getRemainder() {
        return remainder;
    }

    public void setRemainder(Remainder remainder) {
        this.remainder = remainder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
