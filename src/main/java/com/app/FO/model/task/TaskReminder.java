package com.app.FO.model.task;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_reminder")
public class TaskReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_reminder_seq")
    @SequenceGenerator(name = "task_reminder_seq",
            sequenceName = "task_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskReminder() {
    }

    public TaskReminder(Task task, Reminder reminder) {
        this.task = task;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskReminder{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", reminderId=" + reminder.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
