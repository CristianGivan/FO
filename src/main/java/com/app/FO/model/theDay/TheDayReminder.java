package com.app.FO.model.theDay;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_reminder")
public class TheDayReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_reminder_seq")
    @SequenceGenerator(name = "the_day_reminder_seq",
            sequenceName = "the_day_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "the_day_date")
    private LocalDateTime theDayDate;

    public TheDayReminder() {
    }

    public TheDayReminder(TheDay theDay, Reminder reminder) {
        this.theDay = theDay;
        this.reminder = reminder;
        this.theDayDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDayReminder{" +
                "id=" + id +
                ", theDayId=" + theDay.getId() +
                ", reminderId=" + reminder.getId() +
                ", theDayDate=" + theDayDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TheDay getTheDay() {
        return theDay;
    }

    public void setTheDay(TheDay theDay) {
        this.theDay = theDay;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getTheDayDate() {
        return theDayDate;
    }

    public void setTheDayDate(LocalDateTime theDayDate) {
        this.theDayDate = theDayDate;
    }
}
