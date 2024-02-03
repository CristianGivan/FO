package com.app.FO.model.tasks;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_reminder")
public class TasksReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_reminder_seq")
    @SequenceGenerator(name = "tasks_reminder_seq",
            sequenceName = "tasks_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TasksReminder() {
    }

    public TasksReminder(Tasks tasks, Reminder reminder) {
        this.tasks = tasks;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TasksReminder{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", reminderId=" + reminder.getId() +
                ", linkDate=" + linkDate +
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

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
