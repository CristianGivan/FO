package com.app.FO.dto.task;

import com.app.FO.model.task.Task;

import java.time.LocalDate;

public class TaskEffortSDTO {
    private Long id;
    private LocalDate workingDate;
    private Double workingTime;
    private TaskSDTO task;

    @Override
    public String toString() {
        return "TaskEffortSDTO{" +
                "id=" + id +
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", task=" + task +
                '}';
    }

    public TaskEffortSDTO(Long id, LocalDate workingDate, Double workingTime, TaskSDTO task) {
        this.id = id;
        this.workingDate = workingDate;
        this.workingTime = workingTime;
        this.task = task;
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

    public TaskSDTO getTask() {
        return task;
    }

    public void setTask(TaskSDTO task) {
        this.task = task;
    }
}
