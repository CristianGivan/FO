package com.app.FO.model.tag;

import com.app.FO.model.account.AccountTag;
import com.app.FO.model.event.EventTag;
import com.app.FO.model.expense.ExpenseTag;
import com.app.FO.model.expenses.ExpensesTag;
import com.app.FO.model.link.LinkTag;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.person.PersonTag;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.tasks.TasksTag;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.transaction.TransactionTag;
import com.app.FO.model.user.User;
import com.app.FO.model.work.WorkTag;
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

    @Column(name = "subject")
    private String subject;

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
    private List<WorkTag> workTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTag> tasksTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkTag> linkTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<PersonTag> personTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTag> eventTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpenseTag> expenseTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ExpensesTag> expensesTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TransactionTag> transactionTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<AccountTag> accountTagList;

    @OneToMany(mappedBy = "tag", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TagHistory> tagHistoryList;


    public Tag() {
    }

    public Tag(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator +
                ", tagUserList=" + tagUserList +
                ", noteTagList=" + noteTagList +
                ", topicTagList=" + topicTagList +
                ", taskTagList=" + taskTagList +
                ", workTagList=" + workTagList +
                ", tasksTagList=" + tasksTagList +
                ", linkTagList=" + linkTagList +
                ", personTafList=" + personTagList +
                ", eventTagList=" + eventTagList +
                ", expenseTagList=" + expenseTagList +
                ", expensesTagList=" + expensesTagList +
                ", transactionTagList=" + transactionTagList +
                ", accountTagList=" + accountTagList +
                ", tagHistoryList=" + tagHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
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

    public List<NoteTag> getNoteTagList() {
        return noteTagList;
    }

    public void setNoteTagList(List<NoteTag> noteTagList) {
        this.noteTagList = noteTagList;
    }

    public List<TopicTag> getTopicTagList() {
        return topicTagList;
    }

    public void setTopicTagList(List<TopicTag> topicTagList) {
        this.topicTagList = topicTagList;
    }

    public List<TaskTag> getTaskTagList() {
        return taskTagList;
    }

    public void setTaskTagList(List<TaskTag> taskTagList) {
        this.taskTagList = taskTagList;
    }

    public List<WorkTag> getWorkTagList() {
        return workTagList;
    }

    public void setWorkTagList(List<WorkTag> workTagList) {
        this.workTagList = workTagList;
    }

    public List<TasksTag> getTasksTagList() {
        return tasksTagList;
    }

    public void setTasksTagList(List<TasksTag> tasksTagList) {
        this.tasksTagList = tasksTagList;
    }

    public List<LinkTag> getLinkTagList() {
        return linkTagList;
    }

    public void setLinkTagList(List<LinkTag> linkTagList) {
        this.linkTagList = linkTagList;
    }

    public List<PersonTag> getPersonTagList() {
        return personTagList;
    }

    public void setPersonTagList(List<PersonTag> personTafList) {
        this.personTagList = personTafList;
    }

    public List<EventTag> getEventTagList() {
        return eventTagList;
    }

    public void setEventTagList(List<EventTag> eventTagList) {
        this.eventTagList = eventTagList;
    }

    public List<ExpenseTag> getExpenseTagList() {
        return expenseTagList;
    }

    public void setExpenseTagList(List<ExpenseTag> expenseTagList) {
        this.expenseTagList = expenseTagList;
    }

    public List<ExpensesTag> getExpensesTagList() {
        return expensesTagList;
    }

    public void setExpensesTagList(List<ExpensesTag> expensesTagList) {
        this.expensesTagList = expensesTagList;
    }

    public List<TransactionTag> getTransactionTagList() {
        return transactionTagList;
    }

    public void setTransactionTagList(List<TransactionTag> transactionTagList) {
        this.transactionTagList = transactionTagList;
    }

    public List<AccountTag> getAccountTagList() {
        return accountTagList;
    }

    public void setAccountTagList(List<AccountTag> accountTagList) {
        this.accountTagList = accountTagList;
    }

    public List<TagHistory> getTagHistoryList() {
        return tagHistoryList;
    }

    public void setTagHistoryList(List<TagHistory> tagHistoryList) {
        this.tagHistoryList = tagHistoryList;
    }
}
