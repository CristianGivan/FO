package com.app.FO.model;

import com.app.FO.model.event.EventTags;
import com.app.FO.model.expense.Expense;
import com.app.FO.model.expense.ExpenseTag;
import com.app.FO.model.expenseslist.ExpensesListTags;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.topic.TopicTag;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq",
            sequenceName = "tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag")
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<NoteTag> noteTags;
    @OneToMany(mappedBy = "tag")
    private List<TopicTag> topicTags;

    @OneToMany(mappedBy = "tag")
    private List<TaskTag> taskTags;

    @OneToMany(mappedBy = "tag")
    private List<ExpenseTag> expenseTags;

    @OneToMany(mappedBy = "tag")
    private List<ExpensesListTags> expensesListTags;

    @OneToMany(mappedBy = "tag")
    private List<EventTags> eventTags;

    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", noteTags=" + noteTags +
                ", topicTags=" + topicTags +
                ", taskTags=" + taskTags +
                ", expenseTags=" + expenseTags +
                ", expensesListTags=" + expensesListTags +
                ", eventTags=" + eventTags +
                '}';
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public List<NoteTag> getNoteTags() {
        return noteTags;
    }

    public void setNoteTags(List<NoteTag> noteTags) {
        this.noteTags = noteTags;
    }

    public List<TopicTag> getTopicTags() {
        return topicTags;
    }

    public void setTopicTags(List<TopicTag> topicTags) {
        this.topicTags = topicTags;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TaskTag> getTaskTags() {
        return taskTags;
    }

    public void setTaskTags(List<TaskTag> taskTags) {
        this.taskTags = taskTags;
    }

    public List<ExpenseTag> getExpenseTags() {
        return expenseTags;
    }

    public void setExpenseTags(List<ExpenseTag> expenseTags) {
        this.expenseTags = expenseTags;
    }

    public List<ExpensesListTags> getExpensesListTags() {
        return expensesListTags;
    }

    public void setExpensesListTags(List<ExpensesListTags> expensesListTags) {
        this.expensesListTags = expensesListTags;
    }

    public List<EventTags> getEventTags() {
        return eventTags;
    }

    public void setEventTags(List<EventTags> eventTags) {
        this.eventTags = eventTags;
    }
}
