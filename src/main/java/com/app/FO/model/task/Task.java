package com.app.FO.model.task;

import com.app.FO.model.Remainder;
import com.app.FO.model.tasklist.TaskListTask;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
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

    @Column(name = "total_working_time")
    private double totalWorkingTime;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainders;

    //todo date and time when I worked and how much

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskEffort> taskEfforts;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskTag> noteTags;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskNote> taskNotes;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskListTask> taskListTasks;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskHistory> taskHistories;

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
                ", totalWorkingTime=" + totalWorkingTime +
                ", remainders=" + remainders +
                ", taskEfforts=" + taskEfforts +
                ", noteTags=" + noteTags +
                ", taskNotes=" + taskNotes +
                ", taskListTasks=" + taskListTasks +
                ", taskHistories=" + taskHistories +
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

    public double getTotalWorkingTime() {
        return totalWorkingTime;
    }

    public void setTotalWorkingTime(double totalWorkingTime) {
        this.totalWorkingTime = totalWorkingTime;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }

    public List<TaskEffort> getTaskEfforts() {
        return taskEfforts;
    }

    public void setTaskEfforts(List<TaskEffort> taskEfforts) {
        this.taskEfforts = taskEfforts;
    }

    public List<TaskTag> getNoteTags() {
        return noteTags;
    }

    public void setNoteTags(List<TaskTag> noteTags) {
        this.noteTags = noteTags;
    }

    public List<TaskNote> getTaskNotes() {
        return taskNotes;
    }

    public void setTaskNotes(List<TaskNote> taskNotes) {
        this.taskNotes = taskNotes;
    }

    public List<TaskListTask> getTaskListTasks() {
        return taskListTasks;
    }

    public void setTaskListTasks(List<TaskListTask> taskListTasks) {
        this.taskListTasks = taskListTasks;
    }

    public List<TaskHistory> getTaskHistories() {
        return taskHistories;
    }

    public void setTaskHistories(List<TaskHistory> taskHistories) {
        this.taskHistories = taskHistories;
    }
}
