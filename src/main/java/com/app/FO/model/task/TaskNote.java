package com.app.FO.model.task;

import com.app.FO.model.note.Note;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_note")
@Getter
@Setter
@NoArgsConstructor
public class TaskNote {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_note_seq")
    @SequenceGenerator(name = "task_note_seq",
            sequenceName = "task_note_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_note_id")
    @Setter(AccessLevel.NONE)
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

    @Override
    public String toString() {
        return "TaskNote{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", noteId=" + note.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
