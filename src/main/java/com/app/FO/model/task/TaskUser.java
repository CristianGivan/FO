package com.app.FO.model.task;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_user")
public class TaskUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_user_seq")
    @SequenceGenerator(name = "task_user_seq",
            sequenceName = "task_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskUser() {
    }

    public TaskUser(Task task, User user) {
        this.task = task;
        this.user = user;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskUser{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", userId=" + user.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
