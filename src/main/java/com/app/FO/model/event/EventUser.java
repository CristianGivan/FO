package com.app.FO.model.event;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_user")
public class EventUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_user_seq")
    @SequenceGenerator(name = "event_user_seq",
            sequenceName = "event_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    public EventUser() {
    }

    public EventUser(Event event, User user) {
        this.user = user;
        this.event = event;
        this.eventDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", event=" + event.getId() +
                ", eventDate=" + eventDate +
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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
