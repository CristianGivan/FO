package com.app.FO.model.event;

import com.app.FO.model.tasklist.TaskList;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_task_lists")
public class EventTaskLists {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_task_list_seq")
    @SequenceGenerator(name = "event_task_list_seq",
            sequenceName = "event_task_list_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_task_list_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    @JsonIgnore
    private TaskList taskList;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventTaskLists() {
    }

    @Override
    public String toString() {
        return "EventTaskLists{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", taskListId=" + taskList.getId() +
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

    public TaskList getTaskList() {
        return taskList;
    }

    public void setTaskList(TaskList taskList) {
        this.taskList = taskList;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
