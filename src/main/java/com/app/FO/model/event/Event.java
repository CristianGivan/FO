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
    private List<EventTag> tagList;

    @OneToMany(mappedBy = "event")
    private List<EventUser> userList;

    @OneToMany(mappedBy = "event")
    private List<EventTopic> topicList;

    @OneToMany(mappedBy = "event")
    private List<EventTasks> taskList;

    @OneToMany(mappedBy = "event")
    private List<EventExpense> expenseList;

    @OneToMany(mappedBy = "event")
    private List<Remainder> remainderList;

    public Event() {
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tagList +
                ", users=" + userList +
                ", topics=" + topicList +
                ", taskLists=" + taskList +
                ", expenses=" + expenseList +
                ", remainders=" + remainderList +
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

    public List<EventTag> getTagList() {
        return tagList;
    }

    public void setTagList(List<EventTag> tags) {
        this.tagList = tags;
    }

    public List<EventUser> getUserList() {
        return userList;
    }

    public void setUserList(List<EventUser> users) {
        this.userList = users;
    }

    public List<EventTopic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<EventTopic> topics) {
        this.topicList = topics;
    }

    public List<EventTasks> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<EventTasks> taskLists) {
        this.taskList = taskLists;
    }

    public List<EventExpense> getExpenseList() {
        return expenseList;
    }

    public void setExpenseList(List<EventExpense> expenses) {
        this.expenseList = expenses;
    }

    public List<Remainder> getRemainderList() {
        return remainderList;
    }

    public void setRemainderList(List<Remainder> remainders) {
        this.remainderList = remainders;
    }
}
