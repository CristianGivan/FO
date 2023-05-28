package com.app.FO.model.tasks;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_user")
public class TasksUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_user_seq")
    @SequenceGenerator(name = "tasks_user_seq",
            sequenceName = "tasks_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TasksUser() {
    }

    @Override
    public String toString() {
        return "TasksTask{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", tasks=" + tasks.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
