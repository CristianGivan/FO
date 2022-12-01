package com.app.FO.model;

import javax.persistence.*;

@Entity
@Table(name = "details")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detail_seq")
    @SequenceGenerator(name = "detail_seq",
            sequenceName = "detail_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "detail_id")
    private Long id;

    @Column(name = "detail")
    private String detail;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
}
