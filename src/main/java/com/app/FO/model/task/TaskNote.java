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

    public TaskNote() {
    }

    @Override
    public String toString() {
        return "TaskNote{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", noteId=" + note.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
