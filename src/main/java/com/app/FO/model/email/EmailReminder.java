package com.app.FO.model.email;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "email_reminder")
public class EmailReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "email_reminder_seq")
    @SequenceGenerator(name = "email_reminder_seq",
            sequenceName = "email_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "email_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "email_date")
    private LocalDateTime emailDate;

    public EmailReminder() {
    }

    public EmailReminder(Email email, Reminder reminder) {
        this.email = email;
        this.reminder = reminder;
        this.emailDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EmailReminder{" +
                "id=" + id +
                ", emailId=" + email.getId() +
                ", reminderId=" + reminder.getId() +
                ", emailDate=" + emailDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getEmailDate() {
        return emailDate;
    }

    public void setEmailDate(LocalDateTime emailDate) {
        this.emailDate = emailDate;
    }
}
