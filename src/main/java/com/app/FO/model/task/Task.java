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

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "task_status")
    private TaskStatus taskStatus;

    //todo tbc
    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTopic> taskTopicList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskUser> taskUserList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskWork> taskWorkList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskReminder> taskReminderList;

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
                ", creator=" + creator.getId() +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", taskUserList=" + taskUserList +
                ", taskTopicList=" + taskTopicList +
                ", taskWorkList=" + taskWorkList +
                ", taskReminderList=" + taskReminderList +
                ", taskTagList=" + taskTagList +
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

    public void setSubject(String task) {
        this.subject = task;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User user) {
        this.creator = user;
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


    public List<TaskWork> getTaskEffortList() {
        return taskWorkList;
    }

    public void setTaskEffortList(List<TaskWork> taskWorks) {
        this.taskWorkList = taskWorks;
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

    public List<TaskTopic> getTaskTopicList() {
        if (taskTopicList == null) {
            taskTopicList = new ArrayList<>();
        }
        return taskTopicList;
    }

    public void setTaskTopicList(List<TaskTopic> taskTopicList) {
        this.taskTopicList = taskTopicList;
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

    public List<TaskWork> getTaskWorkList() {
        if (taskWorkList == null) {
            taskWorkList = new ArrayList<>();
        }
        return taskWorkList;
    }

    public void setTaskWorkList(List<TaskWork> taskWorkList) {
        this.taskWorkList = taskWorkList;
    }

    public List<TaskReminder> getTaskReminderList() {
        if (taskReminderList == null) {
            taskReminderList = new ArrayList<>();
        }
        return taskReminderList;
    }

    public void setTaskReminderList(List<TaskReminder> taskReminderList) {
        this.taskReminderList = taskReminderList;
    }

    public List<TasksTask> getTasksTaskList() {
        return tasksTaskList;
    }

    public void setTasksTaskList(List<TasksTask> tasksTaskList) {
        this.tasksTaskList = tasksTaskList;
    }
}
