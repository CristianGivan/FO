package com.app.FO.model.tag;

import com.app.FO.model.event.EventTag;
import com.app.FO.model.expense.ExpenseTag;
import com.app.FO.model.expenses.ExpensesTag;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.user.UserTag;

import javax.persistence.*;
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

    @Column(name = "tag")
    private String tagName;

    @OneToMany(mappedBy = "tag",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<UserTag> userTagList;

    @OneToMany(mappedBy = "tag")
    private List<NoteTag> noteTagList;
    @OneToMany(mappedBy = "tag")
    private List<TopicTag> topicTagList;

    @OneToMany(mappedBy = "tag")
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "tag")
    private List<ExpenseTag> expenseTagList;

    @OneToMany(mappedBy = "tag")
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "tag")
    private List<EventTag> eventTagList;

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", userTags=" + userTagList +
                ", noteTags=" + noteTagList +
                ", topicTags=" + topicTagList +
                ", taskTags=" + taskTagList +
                ", expenseTags=" + expenseTagList +
                ", expensesTags=" + expensesTagList +
                ", eventTags=" + eventTagList +
                '}';
    }

    public Tag() {
    }
    public Tag(String tagName) {
        this.tagName = tagName;
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

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
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


    public List<UserTag> getUserTagList() {
        if (userTagList ==null){
            userTagList = new ArrayList<>();
        }
        return userTagList;
    }

    public void setUserTagList(List<UserTag> userTags) {
        this.userTagList = userTags;
    }

}
