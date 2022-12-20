package com.app.FO.model.tasklist;

import com.app.FO.model.note.Note;
import com.app.FO.model.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_list_task")
public class TaskListTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_list_task_seq")
    @SequenceGenerator(name = "task_list_task_seq",
            sequenceName = "task_list_task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_list_task_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    @JsonIgnore
    private TaskList taskList;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskListTask() {
    }

    @Override
    public String toString() {
        return "TaskListTask{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", taskList=" + taskList.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
