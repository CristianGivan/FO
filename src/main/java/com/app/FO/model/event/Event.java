package com.app.FO.model.event;

import com.app.FO.model.remainder.Remainder;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq",
            sequenceName = "event_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "event")
    private List<EventTag> tags;

    @OneToMany(mappedBy = "event")
    private List<EventUsers> users;

    @OneToMany(mappedBy = "event")
    private List<EventTopic> topic;

    @OneToMany(mappedBy = "event")
    private List<EventTasks> tasks;

    @OneToMany(mappedBy = "event")
    private List<EventExpense> expenses;

    @OneToMany(mappedBy = "event")
    private List<Remainder> remainder;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                ", users=" + users +
                ", topics=" + topic +
                ", taskLists=" + tasks +
                ", expenses=" + expenses +
                ", remainders=" + remainder +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EventTag> getTags() {
        return tags;
    }

    public void setTags(List<EventTag> tags) {
        this.tags = tags;
    }

    public List<EventUsers> getUsers() {
        return users;
    }

    public void setUsers(List<EventUsers> users) {
        this.users = users;
    }

    public List<EventTopic> getTopic() {
        return topic;
    }

    public void setTopic(List<EventTopic> topics) {
        this.topic = topics;
    }

    public List<EventTasks> getTasks() {
        return tasks;
    }

    public void setTasks(List<EventTasks> taskLists) {
        this.tasks = taskLists;
    }

    public List<EventExpense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<EventExpense> expenses) {
        this.expenses = expenses;
    }

    public List<Remainder> getRemainder() {
        return remainder;
    }

    public void setRemainder(List<Remainder> remainders) {
        this.remainder = remainders;
    }
}
