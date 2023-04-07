package com.app.FO.model.tasks;

import com.app.FO.model.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_task")
@Getter
@Setter
@NoArgsConstructor
public class TasksTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_task_seq")
    @SequenceGenerator(name = "tasks_task_seq",
            sequenceName = "tasks_task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_task_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "TasksTask{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", tasks=" + tasks.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
