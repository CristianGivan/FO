package com.app.FO.model.tag;

import com.app.FO.model.event.EventTag;
import com.app.FO.model.expense.ExpenseTag;
import com.app.FO.model.expenses.ExpensesTag;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq",
            sequenceName = "tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag_text")
    private String tagText;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TagUser> tagUserList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<NoteTag> noteTagList;
    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TopicTag> topicTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTag> expenseTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTag> eventTagList;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagText='" + tagText + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator.getId() +
                ", tagUserList=" + tagUserList +
                ", noteTagList=" + noteTagList +
                ", topicTagList=" + topicTagList +
                ", taskTagList=" + taskTagList +
                ", expenseTagList=" + expenseTagList +
                ", expensesTagList=" + expensesTagList +
                ", eventTagList=" + eventTagList +
                '}';
    }

    public Tag() {
    }

    public Tag(String tagText, User creator) {
        this.tagText = tagText;
        this.creator = creator;
        this.createdDateTime = LocalDateTime.now();
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<TagUser> getTagUserList() {
        if (tagUserList == null) {
            tagUserList = new ArrayList<>();
        }
        return tagUserList;
    }

    public void setTagUserList(List<TagUser> tagUserList) {
        this.tagUserList = tagUserList;
    }

    public List<ExpensesTag> getExpensesTagList() {
        return expensesTagList;
    }

    public void setExpensesTagList(List<ExpensesTag> expensesTagList) {
        this.expensesTagList = expensesTagList;
    }

    public Long getId() {
        return id;
    }

    public List<NoteTag> getNoteTagList() {
        return noteTagList;
    }

    public void setNoteTagList(List<NoteTag> noteTags) {
        this.noteTagList = noteTags;
    }

    public List<TopicTag> getTopicTagList() {
        return topicTagList;
    }

    public void setTopicTagList(List<TopicTag> topicTags) {
        this.topicTagList = topicTags;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagName) {
        this.tagText = tagName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<TaskTag> getTaskTagList() {
        return taskTagList;
    }

    public void setTaskTagList(List<TaskTag> taskTags) {
        this.taskTagList = taskTags;
    }

    public List<ExpenseTag> getExpenseTagList() {
        return expenseTagList;
    }

    public void setExpenseTagList(List<ExpenseTag> expenseTags) {
        this.expenseTagList = expenseTags;
    }

    public List<ExpensesTag> getExpensesListTags() {
        return expensesTagList;
    }

    public void setExpensesListTags(List<ExpensesTag> expensesTags) {
        this.expensesTagList = expensesTags;
    }

    public List<EventTag> getEventTagList() {
        return eventTagList;
    }

    public void setEventTagList(List<EventTag> eventTags) {
        this.eventTagList = eventTags;
    }
}
