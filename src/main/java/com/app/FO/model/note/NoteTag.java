package com.app.FO.model.note;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_tag")
public class NoteTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_tag_seq")
    @SequenceGenerator(name = "note_tag_seq",
            sequenceName = "note_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "created_date")
    private LocalDateTime createdDate;


    public NoteTag() {
    }

    @Override
    public String toString() {
        return "NoteTag{" +
                "id=" + id +
                ", noteId=" + note.getId()+
                ", tagId=" + tag.getId() +
                ", createdDate=" + createdDate +
                '}';
    }


    public Long getId() {
        return id;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
