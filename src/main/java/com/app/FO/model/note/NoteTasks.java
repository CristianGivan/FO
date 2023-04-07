package com.app.FO.model.note;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_tasks")
@Getter
@Setter
@NoArgsConstructor
public class NoteTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_tasks_seq")
    @SequenceGenerator(name = "note_tasks_seq",
            sequenceName = "note_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_tasks_id")

    @Setter(AccessLevel.NONE)


    @Getter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "tasksTag{" +
                "id=" + id +
                ", noteId=" + note.getId()+
                ", tasksId=" + tasks.getId() +
                ", createdDate=" + linkDate +
                '}';
    }

    public NoteTasks(Note note, Tasks tasks) {
        this.note = note;
        this.tasks = tasks;
        this.linkDate = LocalDateTime.now();
    }


}
