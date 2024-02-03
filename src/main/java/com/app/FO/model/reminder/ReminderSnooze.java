package com.app.FO.model.reminder;

import com.app.FO.model.snooze.Snooze;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_snooze")
public class ReminderSnooze {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_snooze_seq")
    @SequenceGenerator(name = "reminder_snooze_seq",
            sequenceName = "reminder_snooze_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_snooze_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "snooze_id")
    @JsonIgnore
    private Snooze snooze;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "reminder_date")
    private LocalDateTime reminderDate;

    public ReminderSnooze() {
    }

    public ReminderSnooze(Reminder reminder, Snooze snooze) {
        this.snooze = snooze;
        this.reminder = reminder;
        this.reminderDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ReminderTasks{" +
                "id=" + id +
                ", taskId=" + snooze.getId() +
                ", reminder=" + reminder.getId() +
                ", reminderDate=" + reminderDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Snooze getSnooze() {
        return snooze;
    }

    public void setSnooze(Snooze snooze) {
        this.snooze = snooze;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(LocalDateTime reminderDate) {
        this.reminderDate = reminderDate;
    }
}
