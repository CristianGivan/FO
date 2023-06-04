package com.app.FO.model.event;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_tasks")
public class EventTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_tasks_seq")
    @SequenceGenerator(name = "event_tasks_seq",
            sequenceName = "event_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @Column(name = "event_date")
    private LocalDateTime eventDate;

    public EventTasks() {
    }

    public EventTasks(Event event, Tasks tasks) {
        this.event = event;
        this.tasks = tasks;
        this.eventDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "EventTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
