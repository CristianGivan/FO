package com.app.FO.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "notes")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_seq")
    @SequenceGenerator(name = "note_seq",
            sequenceName = "note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @OneToMany(mappedBy = "note")
    private List<Detail> details;

    @OneToMany(mappedBy = "note")
    private List<NoteTag> noteTags;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
