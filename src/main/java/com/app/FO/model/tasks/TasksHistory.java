package com.app.FO.model.tasks;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class TasksHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_history_seq")
    @SequenceGenerator(name = "tasks_history_seq",
            sequenceName = "tasks_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    public TasksHistory() {
    }

    @Override
    public String toString() {
        return "TasksHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + tasks.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Tasks getTaskList() {
        return tasks;
    }

    public void setTaskList(Tasks tasks) {
        this.tasks = tasks;
    }
}
