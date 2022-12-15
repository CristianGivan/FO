package com.app.FO.model.task;

import com.app.FO.model.Tag;
import com.app.FO.model.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_notes")
public class TaskNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_notes_seq")
    @SequenceGenerator(name = "task_notes_seq",
            sequenceName = "task_notes_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_notes_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @Column(name = "link_date")
    private LocalDateTime linkDate;
}
