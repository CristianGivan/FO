package com.app.FO.model.reminder;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_reminder")
public class ReminderReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_reminder_seq")
    @SequenceGenerator(name = "reminder_reminder_seq",
            sequenceName = "reminder_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @ManyToOne
    @JoinColumn(name = "repeated_reminder_id")
    @JsonIgnore
    private Reminder repeatedReminder;

    @Column(name = "linked_date")
    private LocalDateTime linkedDate;

    public ReminderReminder() {
    }

    public ReminderReminder(Reminder reminder, Reminder repeatedReminder) {
        this.reminder = reminder;
        this.repeatedReminder = repeatedReminder;
        this.linkedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ReminderReminder{" +
                "id=" + id +
                ", reminderId=" + reminder.getId() +
                ", relatedReminderId=" + repeatedReminder.getId() +
                ", reminderDate=" + linkedDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public Reminder getRelatedReminder() {
        return repeatedReminder;
    }

    public void setRelatedReminder(Reminder relatedReminder) {
        this.repeatedReminder = relatedReminder;
    }

    public LocalDateTime getLinkedDate() {
        return linkedDate;
    }

    public void setLinkedDate(LocalDateTime linkedDate) {
        this.linkedDate = linkedDate;
    }
}
