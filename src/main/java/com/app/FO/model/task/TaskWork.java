package com.app.FO.model.task;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

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

    @Column(name = "working_date_time")
    private LocalDate workingDate;

    //todo time or double what should be?
    @Column(name = "woking_time")
    private Double workingTime;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    public TaskWork() {
    }

    @Override
    public String toString() {
        return "TaskWork{" +
                "id=" + id +
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", task=" + task +
                ", topic=" + topic +
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}
