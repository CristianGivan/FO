package com.app.FO.model.reminder;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_user")
public class ReminderUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_user_seq")
    @SequenceGenerator(name = "reminder_user_seq",
            sequenceName = "reminder_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "reminder_date")
    private LocalDateTime reminderDate;

    public ReminderUser() {
    }

    public ReminderUser(Reminder reminder, User user) {
        this.user = user;
        this.reminder = reminder;
        this.reminderDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ReminderTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
