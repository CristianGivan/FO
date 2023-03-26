package com.app.FO.model.note;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tag.Tag;
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
        return "RemainderTag{" +
                "id=" + id +
                ", noteId=" + note.getId()+
                ", remainderId=" + remainder.getId() +
                ", createdDate=" + linkDate +
                '}';
    }

    public NoteRemainder(Note note, Remainder remainder) {
        this.note = note;
        this.remainder = remainder;
        this.linkDate = LocalDateTime.now();
    }


}
