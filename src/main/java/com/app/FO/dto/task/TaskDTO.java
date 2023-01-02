package com.app.FO.dto.task;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.remainder.RemainderSDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tasklist.TaskListSDTO;
import com.app.FO.dto.user.UserDTO;
import com.app.FO.model.task.*;

import java.time.LocalDateTime;
import java.util.List;

public class TaskDTO {
    private Long id;
    private String task;
    private UserDTO user;
    private LocalDateTime createdDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TaskStatus taskStatus;
    private List<RemainderSDTO> remainders;
    private List<TaskEffortSDTO> taskEfforts;
    private List<TagDTO> noteTags;
    private List<NoteDTO> taskNotes;
    private List<TaskListSDTO> taskListTasks;
    private List<TaskHistoryDTO> taskHistories;

    @Override
    public String toString() {
        return "TaskDTO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", remainders=" + remainders +
                ", taskEfforts=" + taskEfforts +
                ", noteTags=" + noteTags +
                ", taskNotes=" + taskNotes +
                ", taskListTasks=" + taskListTasks +
                ", taskHistories=" + taskHistories +
                '}';
    }

    public TaskDTO(Long id, String task, UserDTO user, LocalDateTime createdDate, LocalDateTime startDate,
                   LocalDateTime endDate, TaskStatus taskStatus, List<RemainderSDTO> remainders,
                   List<TaskEffortSDTO> taskEfforts, List<TagDTO> noteTags, List<NoteDTO> taskNotes,
                   List<TaskListSDTO> taskListTasks, List<TaskHistoryDTO> taskHistories) {
        this.id = id;
        this.task = task;
        this.user = user;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskStatus = taskStatus;
        this.remainders = remainders;
        this.taskEfforts = taskEfforts;
        this.noteTags = noteTags;
        this.taskNotes = taskNotes;
        this.taskListTasks = taskListTasks;
        this.taskHistories = taskHistories;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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

    public List<RemainderSDTO> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<RemainderSDTO> remainders) {
        this.remainders = remainders;
    }

    public List<TaskEffortSDTO> getTaskEfforts() {
        return taskEfforts;
    }

    public void setTaskEfforts(List<TaskEffortSDTO> taskEfforts) {
        this.taskEfforts = taskEfforts;
    }

    public List<TagDTO> getNoteTags() {
        return noteTags;
    }

    public void setNoteTags(List<TagDTO> noteTags) {
        this.noteTags = noteTags;
    }

    public List<NoteDTO> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(List<NoteDTO> taskNotes) {
        this.taskNotes = taskNotes;
    }

    public List<TaskListSDTO> getTaskListTasks() {
        return taskListTasks;
    }

    public void setTaskListTasks(List<TaskListSDTO> taskListTasks) {
        this.taskListTasks = taskListTasks;
    }

    public List<TaskHistoryDTO> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistoryDTO> taskHistories) {
        this.taskHistories = taskHistories;
    }
}
