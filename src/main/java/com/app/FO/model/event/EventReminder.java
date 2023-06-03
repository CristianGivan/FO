package com.app.FO.model.event;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_reminder")
public class EventReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_reminder_seq")
    @SequenceGenerator(name = "event_reminder_seq",
            sequenceName = "event_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    public EventReminder() {
    }

    public EventReminder(Event event, Reminder reminder) {
        this.event = event;
        this.reminder = reminder;
        this.eventDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventReminder{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", reminderId=" + reminder.getId() +
                ", eventDate=" + eventDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
