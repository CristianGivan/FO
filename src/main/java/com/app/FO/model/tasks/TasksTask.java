package com.app.FO.model.tasks;

import com.app.FO.model.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_task")
public class TasksTask {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_task_seq")
    @SequenceGenerator(name = "tasks_task_seq",
            sequenceName = "tasks_task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_task_id")
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

    public TasksTask() {
    }

    public TasksTask(Tasks tasks, Task task) {
        this.tasks = tasks;
        this.task = task;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TasksTask{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", tasks=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
