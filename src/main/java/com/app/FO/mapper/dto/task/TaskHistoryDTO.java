package com.app.FO.mapper.dto.task;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class TaskHistoryDTO {
    private Long id;
    private LocalDateTime modifiedDate;
    private UserDTO user;
    private TaskDTO task;

    public TaskHistoryDTO(Long id, LocalDateTime modifiedDate, UserDTO user, TaskDTO task) {
        this.id = id;
        this.modifiedDate = modifiedDate;
        this.user = user;
        this.task = task;
    }

    @Override
    public String toString() {
        return "TaskHistoryDTO{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                ", task=" + task +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }
}
