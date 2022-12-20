package com.app.FO.model.task;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

//effort
@Entity
@Table(name = "task_effort")
public class TaskEffort {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_effort_seq")
    @SequenceGenerator(name = "task_effort_seq",
            sequenceName = "task_effort_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_effort_id")
    private Long id;

    @Column(name = "working_date_time")
    private LocalDate workingDate;

    //todo time or double what should be?
    @Column(name = "woking_time")
    private Double workingTime;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    public TaskEffort() {
    }

    @Override
    public String toString() {
        return "TaskEffort{" +
                "id=" + id +
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", taskId=" + task.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(LocalDate workingDate) {
        this.workingDate = workingDate;
    }

    public Double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Double workingTime) {
        this.workingTime = workingTime;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
}
