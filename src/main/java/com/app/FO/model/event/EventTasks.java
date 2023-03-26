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
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventTasks() {
    }

    @Override
    public String toString() {
        return "EventTasks{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTaskList() {
        return tasks;
    }

    public void setTaskList(Tasks tasks) {
        this.tasks = tasks;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
