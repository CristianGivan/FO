package com.app.FO.dto.task;

import com.app.FO.dto.user.UserSDTO;
import com.app.FO.model.task.Task;
import com.app.FO.model.user.User;

import java.time.LocalDateTime;

public class TaskHistoryDTO {
    private Long id;
    private LocalDateTime modifiedDate;
    private UserSDTO user;
    private TaskSDTO task;

    @Override
    public String toString() {
        return "TaskHistoryDTO{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                ", task=" + task +
                '}';
    }

    public TaskHistoryDTO(Long id, LocalDateTime modifiedDate, UserSDTO user, TaskSDTO task) {
        this.id = id;
        this.modifiedDate = modifiedDate;
        this.user = user;
        this.task = task;
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

    public UserSDTO getUser() {
        return user;
    }

    public void setUser(UserSDTO user) {
        this.user = user;
    }

    public TaskSDTO getTask() {
        return task;
    }

    public void setTask(TaskSDTO task) {
        this.task = task;
    }
}
