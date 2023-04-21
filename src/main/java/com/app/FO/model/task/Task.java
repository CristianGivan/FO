package com.app.FO.model.task;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tasks.TasksTask;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task")
    private String task;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column (name = "task_status")
    private TaskStatus taskStatus;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainderList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskEffort> taskEffortList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskHistory> taskHistoryList;

    public Task() {
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", userId=" + user.getId() +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", remainders=" + remainderList +
                ", taskEfforts=" + taskEffortList +
                ", noteTags=" + taskTagList +
                ", tasksTasks=" + tasksTaskList +
                ", taskHistories=" + taskHistoryList +
                '}';
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

    public List<Remainder> getRemainderList() {
        return remainderList;
    }

    public void setRemainderList(List<Remainder> remainders) {
        this.remainderList = remainders;
    }

    public List<TaskEffort> getTaskEffortList() {
        return taskEffortList;
    }

    public void setTaskEffortList(List<TaskEffort> taskEfforts) {
        this.taskEffortList = taskEfforts;
    }

    public List<TaskTag> getTaskTagList() {
        return taskTagList;
    }

    public void setTaskTagList(List<TaskTag> noteTags) {
        this.taskTagList = noteTags;
    }

    public List<TasksTask> getTaskListTasks() {
        return tasksTaskList;
    }

    public void setTaskListTasks(List<TasksTask> tasksTasks) {
        this.tasksTaskList = tasksTasks;
    }

    public List<TaskHistory> getTaskHistoryList() {
        return taskHistoryList;
    }

    public void setTaskHistoryList(List<TaskHistory> taskHistories) {
        this.taskHistoryList = taskHistories;
    }
}
