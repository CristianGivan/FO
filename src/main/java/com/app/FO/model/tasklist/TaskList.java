package com.app.FO.model.tasklist;

import com.app.FO.model.event.EventTaskLists;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task_lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_lists_seq")
    @SequenceGenerator(name = "task_lists_seq",
            sequenceName = "task_lists_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_lists_id")
    private Long id;

    @Column(name = "name")
    private String taskListName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskListTask> taskListTasks;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskListHistory> TaskListHistory;

    @OneToMany(mappedBy = "taskList", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTaskLists> eventTaskLists;

    public TaskList() {
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", taskListTasks=" + taskListTasks +
                ", TaskListHistory=" + TaskListHistory +
                ", eventTaskLists=" + eventTaskLists +
                '}';
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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

    public List<TaskListTask> getTaskListTasks() {
        return taskListTasks;
    }

    public void setTaskListTasks(List<TaskListTask> taskListTasks) {
        this.taskListTasks = taskListTasks;
    }

    public List<com.app.FO.model.tasklist.TaskListHistory> getTaskListHistory() {
        return TaskListHistory;
    }

    public void setTaskListHistory(List<com.app.FO.model.tasklist.TaskListHistory> taskListHistory) {
        TaskListHistory = taskListHistory;
    }

    public List<EventTaskLists> getEventTaskLists() {
        return eventTaskLists;
    }

    public void setEventTaskLists(List<EventTaskLists> eventTaskLists) {
        this.eventTaskLists = eventTaskLists;
    }
}
