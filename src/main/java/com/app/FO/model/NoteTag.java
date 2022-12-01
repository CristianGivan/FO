package com.app.FO.model;

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

}
