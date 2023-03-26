package com.app.FO.dto.tasks;

import com.app.FO.model.task.TaskStatus;

import java.time.LocalDateTime;

public class TasksSDTO {
    private Long id;
    private String taskListName;
    private LocalDateTime createdDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TaskStatus taskStatus;

    @Override
    public String toString() {
        return "TasksSDTO{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                '}';
    }

    public TasksSDTO(Long id, String taskListName, LocalDateTime createdDate, LocalDateTime startDate,
                     LocalDateTime endDate, TaskStatus taskStatus) {
        this.id = id;
        this.taskListName = taskListName;
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

    public String getTaskListName() {
        return taskListName;
    }

    public void setTaskListName(String taskListName) {
        this.taskListName = taskListName;
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
