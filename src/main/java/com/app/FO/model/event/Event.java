package com.app.FO.model.event;

import com.app.FO.model.Remainder;
import com.app.FO.model.Tag;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expenseslist.ExpensesList;
import com.app.FO.model.tasklist.TaskList;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "events")
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
    private List<EventTags> tags;

    @OneToMany(mappedBy = "event")
    private List<EventUsers> users;

    @OneToMany(mappedBy = "event")
    private List<EventTopics> topics;

    @OneToMany(mappedBy = "event")
    private List<EventTaskLists> taskLists;

    @OneToMany(mappedBy = "event")
    private List<EventExpenseLists> expenses;

    @OneToMany(mappedBy = "event")
    private List<Remainder> remainders;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tags +
                ", users=" + users +
                ", topics=" + topics +
                ", taskLists=" + taskLists +
                ", expenses=" + expenses +
                ", remainders=" + remainders +
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

    public List<EventTags> getTags() {
        return tags;
    }

    public void setTags(List<EventTags> tags) {
        this.tags = tags;
    }

    public List<EventUsers> getUsers() {
        return users;
    }

    public void setUsers(List<EventUsers> users) {
        this.users = users;
    }

    public List<EventTopics> getTopics() {
        return topics;
    }

    public void setTopics(List<EventTopics> topics) {
        this.topics = topics;
    }

    public List<EventTaskLists> getTaskLists() {
        return taskLists;
    }

    public void setTaskLists(List<EventTaskLists> taskLists) {
        this.taskLists = taskLists;
    }

    public List<EventExpenseLists> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<EventExpenseLists> expenses) {
        this.expenses = expenses;
    }

    public List<Remainder> getRemainders() {
        return remainders;
    }

    public void setRemainders(List<Remainder> remainders) {
        this.remainders = remainders;
    }
}
