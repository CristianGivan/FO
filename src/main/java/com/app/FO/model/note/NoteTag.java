package com.app.FO.model.note;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;


    public NoteTag() {
    }

    public NoteTag(Note note, Tag tag) {
        this.note = note;
        this.tag = tag;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "NoteTag{" +
                "id=" + id +
                ", noteId=" + note.getId() +
                ", tagId=" + tag.getId() +
                ", createdDate=" + linkDate +
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

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime createdDate) {
        this.linkDate = createdDate;
    }
}
