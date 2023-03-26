package com.app.FO.dto.task;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.remainder.RemainderDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tasks.TasksDTO;
import com.app.FO.dto.user.UserDTO;
import com.app.FO.model.task.*;

import java.time.LocalDateTime;
import java.util.List;

public class TaskFDTO {
    private Long id;
    private String task;
    private UserDTO user;
    private LocalDateTime createdDate;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private TaskStatus taskStatus;
    private List<RemainderDTO> remainderDTOList;
    private List<TaskEffortSDTO> taskEffortSDTOList;
    private List<TagDTO> tagDTOList;
    private List<NoteDTO> noteDTOList;
    private List<TasksDTO> tasksDTOList;
    private List<TaskHistoryDTO> taskHistoryDTOList;

    @Override
    public String toString() {
        return "TaskFDTO{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", remainders=" + remainderDTOList +
                ", taskEfforts=" + taskEffortSDTOList +
                ", noteTags=" + tagDTOList +
                ", taskNotes=" + noteDTOList +
                ", taskListTasks=" + tasksDTOList +
                ", taskHistories=" + taskHistoryDTOList +
                '}';
    }

    public TaskFDTO(Long id, String task, UserDTO user, LocalDateTime createdDate, LocalDateTime startDate,
                    LocalDateTime endDate, TaskStatus taskStatus, List<RemainderDTO> remainderDTOList,
                    List<TaskEffortSDTO> taskEffortSDTOList, List<TagDTO> tagDTOList, List<NoteDTO> noteDTOList,
                    List<TasksDTO> tasksDTOList, List<TaskHistoryDTO> taskHistoryDTOList) {
        this.id = id;
        this.task = task;
        this.user = user;
        this.createdDate = createdDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.taskStatus = taskStatus;
        this.remainderDTOList = remainderDTOList;
        this.taskEffortSDTOList = taskEffortSDTOList;
        this.tagDTOList = tagDTOList;
        this.noteDTOList = noteDTOList;
        this.tasksDTOList = tasksDTOList;
        this.taskHistoryDTOList = taskHistoryDTOList;
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

    public List<RemainderDTO> getRemainderDTOList() {
        return remainderDTOList;
    }

    public void setRemainderDTOList(List<RemainderDTO> remainderDTOList) {
        this.remainderDTOList = remainderDTOList;
    }

    public List<TaskEffortSDTO> getTaskEffortSDTOList() {
        return taskEffortSDTOList;
    }

    public void setTaskEffortSDTOList(List<TaskEffortSDTO> taskEffortSDTOList) {
        this.taskEffortSDTOList = taskEffortSDTOList;
    }

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }

    public List<NoteDTO> getNoteDTOList() {
        return noteDTOList;
    }

    public void setNoteDTOList(List<NoteDTO> noteDTOList) {
        this.noteDTOList = noteDTOList;
    }

    public List<TasksDTO> getTasksSDTOList() {
        return tasksDTOList;
    }

    public void setTasksSDTOList(List<TasksDTO> tasksDTOList) {
        this.tasksDTOList = tasksDTOList;
    }

    public List<TaskHistoryDTO> getTaskHistoryDTOList() {
        return taskHistoryDTOList;
    }

    public void setTaskHistoryDTOList(List<TaskHistoryDTO> taskHistoryDTOList) {
        this.taskHistoryDTOList = taskHistoryDTOList;
    }
}
