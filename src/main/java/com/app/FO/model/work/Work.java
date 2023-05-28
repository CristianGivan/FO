package com.app.FO.model.work;

import com.app.FO.model.task.TaskWork;
import com.app.FO.model.topic.Topic;
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
    @Column(name = "working_date_time")
    private LocalDateTime workingDate;

    //todo time or double what should be?
    @Column(name = "woking_time")
    private Double workingTime;

    @Column(name = "link_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "topic_id", referencedColumnName = "topic_id")
    private Topic topic;
    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskWork> taskWorkList;

    @OneToMany(mappedBy = "work", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<WorkUser> workUserList;

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
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", topic=" + topic +
                ", taskWorkList=" + taskWorkList +
                ", workUserList=" + workUserList +
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

    public LocalDateTime getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(LocalDateTime workingDate) {
        this.workingDate = workingDate;
    }

    public Double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Double workingTime) {
        this.workingTime = workingTime;
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public List<TaskWork> getTaskWorkList() {
        return taskWorkList;
    }

    public void setTaskWorkList(List<TaskWork> taskWorkList) {
        this.taskWorkList = taskWorkList;
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
}
