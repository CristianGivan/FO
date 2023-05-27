package com.app.FO.model.tasks;

import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tasks.Tasks;
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

    @Override
    public String toString() {
        return "TasksReminder{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", reminderId=" + reminder.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
