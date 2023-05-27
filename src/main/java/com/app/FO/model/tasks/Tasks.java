package com.app.FO.model.tasks;

import com.app.FO.model.event.EventTasks;
import com.app.FO.model.task.TaskReminder;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_seq")
    @SequenceGenerator(name = "tasks_seq",
            sequenceName = "tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_id")
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
    private TaskStatus tasksStatus;

    //todo tbc
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    @JsonIgnore
    private Topic topic;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;

    @OneToMany(mappedBy = "tasks", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksUser> tasksUserList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "task", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskReminder> taskReminderList;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksHistory> tasksHistoryList;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTasks> eventTasksList;

    public Tasks() {
    }

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", creator=" + creator.getId() +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", tasksStatus=" + tasksStatus +
                ", topic=" + topic.getId() +
                ", tasksTaskList=" + tasksTaskList +
                ", taskUserList=" + tasksUserList +
                ", taskTagList=" + taskTagList +
                ", taskReminderList=" + taskReminderList +
                ", tasksHistoryList=" + tasksHistoryList +
                ", eventTasksList=" + eventTasksList +
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

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public TaskStatus getTasksStatus() {
        return tasksStatus;
    }

    public void setTasksStatus(TaskStatus tasksStatus) {
        this.tasksStatus = tasksStatus;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<TasksTask> getTasksTaskList() {
        return tasksTaskList;
    }

    public void setTasksTaskList(List<TasksTask> tasksTaskList) {
        this.tasksTaskList = tasksTaskList;
    }

    public List<TasksUser> getTasksUserList() {
        if (tasksUserList == null) {
            tasksUserList = new ArrayList<>();
        }
        return tasksUserList;
    }

    public void setTasksUserList(List<TasksUser> taskUserList) {
        this.tasksUserList = taskUserList;
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

    public List<TasksHistory> getTasksHistoryList() {
        return tasksHistoryList;
    }

    public void setTasksHistoryList(List<TasksHistory> tasksHistoryList) {
        this.tasksHistoryList = tasksHistoryList;
    }

    public List<EventTasks> getEventTasksList() {
        return eventTasksList;
    }

    public void setEventTasksList(List<EventTasks> eventTasksList) {
        this.eventTasksList = eventTasksList;
    }
}
