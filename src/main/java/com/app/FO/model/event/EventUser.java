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
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventUser() {
    }

    @Override
    public String toString() {
        return "EventUser{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", userId=" + user.getId() +
                ", linkDate=" + linkDate +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
