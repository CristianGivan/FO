package com.app.FO.model.task;

import com.app.FO.model.work.Work;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

//work
@Entity
@Table(name = "task_work")
public class TaskWork {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_work_seq")
    @SequenceGenerator(name = "task_work_seq",
            sequenceName = "task_work_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_work_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskWork() {
    }

    public TaskWork(Task task, Work work) {
        this.task = task;
        this.work = work;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskWork{" +
                "id=" + id +
                ", task=" + task +
                ", work=" + work +
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

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
