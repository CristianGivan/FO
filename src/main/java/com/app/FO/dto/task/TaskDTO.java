package com.app.FO.dto.task;

import com.app.FO.model.task.TaskStatus;

import java.time.LocalDateTime;

public class TaskDTO {
    private Long id;
    private String task;
    private LocalDateTime createdDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TaskStatus taskStatus;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                '}';
    }

    public TaskDTO(Long id, String task, LocalDateTime createdDate, LocalDateTime startDate,
                   LocalDateTime endDate, TaskStatus taskStatus) {
        this.id = id;
        this.task = task;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskStatus = taskStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }
}
