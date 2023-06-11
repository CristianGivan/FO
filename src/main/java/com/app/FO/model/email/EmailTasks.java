package com.app.FO.model.email;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_tasks")
public class EmailTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_tasks_seq")
    @SequenceGenerator(name = "email_tasks_seq",
            sequenceName = "email_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @Column(name = "email_date")
    private LocalDateTime emailDate;

    public EmailTasks() {
    }

    public EmailTasks(Email email, Tasks tasks) {
        this.email = email;
        this.tasks = tasks;
        this.emailDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmailTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", email=" + email.getId() +
                ", emailDate=" + emailDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public LocalDateTime getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(LocalDateTime emailDate) {
        this.emailDate = emailDate;
    }
}
