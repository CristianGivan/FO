package com.app.FO.model.phoneNumber;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "phoneNumber_reminder")
public class PhoneNumberReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "phoneNumber_reminder_seq")
    @SequenceGenerator(name = "phoneNumber_reminder_seq",
            sequenceName = "phoneNumber_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "phoneNumber_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "phoneNumber_date")
    private LocalDateTime phoneNumberDate;

    public PhoneNumberReminder() {
    }

    public PhoneNumberReminder(PhoneNumber phoneNumber, Reminder reminder) {
        this.phoneNumber = phoneNumber;
        this.reminder = reminder;
        this.phoneNumberDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PhoneNumberReminder{" +
                "id=" + id +
                ", phoneNumberId=" + phoneNumber.getId() +
                ", reminderId=" + reminder.getId() +
                ", phoneNumberDate=" + phoneNumberDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getPhoneNumberDate() {
        return phoneNumberDate;
    }

    public void setPhoneNumberDate(LocalDateTime phoneNumberDate) {
        this.phoneNumberDate = phoneNumberDate;
    }
}
