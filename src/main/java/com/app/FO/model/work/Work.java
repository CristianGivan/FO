package com.app.FO.model.work;

import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.task.TaskWork;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//work
@Entity
@Table(name = "work")
public class Work {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_seq")
    @SequenceGenerator(name = "work_seq",
            sequenceName = "work_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "work_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "working_date")
    private LocalDateTime workingDateTime;

    //todo time or double what should be?
    @Column(name = "working_effort")
    private Double workingTime;

    @Column(name = "estimated_time")
    private Double estimatedTime;
    @Column(name = "working_progress")
    private Double workingProgress;
    @Column(name = "task_status")
    private TaskStatus taskStatus;
    @Column(name = "created_Date")
    private LocalDateTime createdDate;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkUser> workUserList;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkTag> workTagList;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkReminder> workReminderList;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkTopic> workTopicList;
    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskWork> taskWorkList;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkHistory> workHistoryList;


    public Work(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    public Work() {
    }

    @Override
    public String toString() {
        return "Work{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", workingDateTime=" + workingDateTime +
                ", workingTime=" + workingTime +
                ", estimatedTime=" + estimatedTime +
                ", workingProgress=" + workingProgress +
                ", taskStatus=" + taskStatus +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", workUserList=" + workUserList +
                ", workTagList=" + workTagList +
                ", workReminderList=" + workReminderList +
                ", workTopicList=" + workTopicList +
                ", taskWorkList=" + taskWorkList +
                ", workHistoryList=" + workHistoryList +
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

    public LocalDateTime getWorkingDateTime() {
        return workingDateTime;
    }

    public void setWorkingDateTime(LocalDateTime workingDate) {
        this.workingDateTime = workingDate;
    }

    public Double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Double workingEfort) {
        this.workingTime = workingEfort;
    }

    public Double getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(Double estimatedTime) {
        this.estimatedTime = estimatedTime;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<WorkUser> getWorkUserList() {
        if (workUserList == null) {
            workUserList = new ArrayList<>();
        }
        return workUserList;
    }

    public void setWorkUserList(List<WorkUser> workUserList) {
        this.workUserList = workUserList;
    }

    public List<WorkTag> getWorkTagList() {
        if (workUserList == null) {
            workUserList = new ArrayList<>();
        }
        return workTagList;
    }

    public void setWorkTagList(List<WorkTag> workTagList) {
        this.workTagList = workTagList;
    }

    public List<WorkReminder> getWorkReminderList() {
        if (workReminderList == null) {
            workReminderList = new ArrayList<>();
        }
        return workReminderList;
    }

    public void setWorkReminderList(List<WorkReminder> workReminderList) {
        this.workReminderList = workReminderList;
    }

    public List<WorkTopic> getWorkTopicList() {
        if (workTopicList == null) {
            workTopicList = new ArrayList<>();
        }
        return workTopicList;
    }

    public void setWorkTopicList(List<WorkTopic> topicList) {
        this.workTopicList = topicList;
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

    public List<WorkHistory> getWorkHistoryList() {
        if (workHistoryList == null) {
            workHistoryList = new ArrayList<>();
        }
        return workHistoryList;
    }

    public void setWorkHistoryList(List<WorkHistory> workHistoryList) {
        this.workHistoryList = workHistoryList;
    }

}
