package com.app.FO.model.task;

import com.app.FO.model.tasks.TasksTask;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @Column(name = "subject")
    private String subject;


    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "working_time")
    private Double workingTime;

    @Column(name = "estimated_time")
    private Double estimatedTime;
    @Column(name = "estimated_left_time")
    private Double estimatedLeftTime;
    @Column(name = "working_progress")
    private Double workingProgress;
    @Column(name = "task_status")
    private TaskStatus taskStatus;

    //todo tbc

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskUser> taskUserList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskReminder> taskReminderList;
    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTopic> taskTopicList;
    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskWork> taskWorkList;
    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;
    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskHistory> taskHistoryList;

    public Task() {
    }

    public Task(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", workingTime=" + workingTime +
                ", estimatedTime=" + estimatedTime +
                ", leftEstimatedTime=" + estimatedLeftTime +
                ", workingProgress=" + workingProgress +
                ", taskStatus=" + taskStatus +
                ", creator=" + creator +
                ", taskUserList=" + taskUserList +
                ", taskTagList=" + taskTagList +
                ", taskReminderList=" + taskReminderList +
                ", taskTopicList=" + taskTopicList +
                ", taskWorkList=" + taskWorkList +
                ", tasksTaskList=" + tasksTaskList +
                ", taskHistoryList=" + taskHistoryList +
                '}';
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getStartDate() {
        if (startDate == null) {
            startDate = LocalDateTime.now();
        }
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public Double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Double workingTime) {
        this.workingTime = workingTime;
    }

    public Double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Double estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public Double getEstimatedLeftTime() {
        return estimatedLeftTime;
    }

    public void setEstimatedLeftTime(Double estimatedLeftTime) {
        this.estimatedLeftTime = estimatedLeftTime;
    }

    public Double getWorkingProgress() {
        return workingProgress;
    }

    public void setWorkingProgress(Double workingProgress) {
        this.workingProgress = workingProgress;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<TaskUser> getTaskUserList() {
        if (taskUserList == null) {
            taskUserList = new ArrayList<>();
        }
        return taskUserList;
    }

    public void setTaskUserList(List<TaskUser> taskUserList) {
        this.taskUserList = taskUserList;
    }

    public List<TaskTag> getTaskTagList() {
        return taskTagList;
    }

    public void setTaskTagList(List<TaskTag> taskTagList) {
        this.taskTagList = taskTagList;
    }

    public List<TaskReminder> getTaskReminderList() {
        return taskReminderList;
    }

    public void setTaskReminderList(List<TaskReminder> taskReminderList) {
        this.taskReminderList = taskReminderList;
    }

    public List<TaskTopic> getTaskTopicList() {
        return taskTopicList;
    }

    public void setTaskTopicList(List<TaskTopic> taskTopicList) {
        this.taskTopicList = taskTopicList;
    }

    public List<TaskWork> getTaskWorkList() {
        return taskWorkList;
    }

    public void setTaskWorkList(List<TaskWork> taskWorkList) {
        this.taskWorkList = taskWorkList;
    }

    public List<TasksTask> getTasksTaskList() {
        if (tasksTaskList == null) {
            tasksTaskList = new ArrayList<>();
        }
        return tasksTaskList;
    }

    public void setTasksTaskList(List<TasksTask> tasksTaskList) {
        this.tasksTaskList = tasksTaskList;
    }

    public List<TaskHistory> getTaskHistoryList() {
        return taskHistoryList;
    }

    public void setTaskHistoryList(List<TaskHistory> taskHistoryList) {
        this.taskHistoryList = taskHistoryList;
    }
}
