package com.app.FO.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq",
            sequenceName = "tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_id")
    private Long id;

    @OneToMany(mappedBy = "tag")
    private List<NoteTag>noteTags;

    @Column(name = "tag")
    private String tagName;

}
