package com.app.FO.model.event;

import com.app.FO.model.person.Person;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_person")
public class EventPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_person_seq")
    @SequenceGenerator(name = "event_person_seq",
            sequenceName = "event_person_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_person_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    public EventPerson() {
    }

    public EventPerson(Event event, Person person) {
        this.event = event;
        this.person = person;
        this.eventDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventPerson{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", personId=" + person.getId() +
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }
}
