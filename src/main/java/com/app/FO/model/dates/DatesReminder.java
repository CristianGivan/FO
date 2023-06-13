package com.app.FO.model.dates;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_reminder")
public class DatesReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_reminder_seq")
    @SequenceGenerator(name = "dates_reminder_seq",
            sequenceName = "dates_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "dates_date")
    private LocalDateTime datesDate;

    public DatesReminder() {
    }

    public DatesReminder(Dates dates, Reminder reminder) {
        this.dates = dates;
        this.reminder = reminder;
        this.datesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DatesReminder{" +
                "id=" + id +
                ", datesId=" + dates.getId() +
                ", reminderId=" + reminder.getId() +
                ", datesDate=" + datesDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getDatesDate() {
        return datesDate;
    }

    public void setDatesDate(LocalDateTime datesDate) {
        this.datesDate = datesDate;
    }
}
