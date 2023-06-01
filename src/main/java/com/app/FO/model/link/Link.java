package com.app.FO.model.link;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "link")
public class Link {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_seq")
    @SequenceGenerator(name = "link_seq",
            sequenceName = "link_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;
    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkUser> linkUserList;


    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkTopic> linkTopicList;

    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkTasks> linkTasksList;

    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkTag> linkTagList;

    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkReminder> linkReminderList;

    @OneToMany(mappedBy = "link", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<LinkHistory> linkHistoryList;


    public Link() {
    }

    public Link(String subject, User creator) {
        this.subject = subject;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Link{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", linkUserList=" + linkUserList +
                ", linkTopicList=" + linkTopicList +
                ", linkTasksList=" + linkTasksList +
                ", linkUserList=" + linkUserList +
                ", linkTagList=" + linkTagList +
                ", linkReminderList=" + linkReminderList +
                ", linkHistoryList=" + linkHistoryList +
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<LinkUser> getLinkUserList() {
        return linkUserList;
    }

    public void setLinkUserList(List<LinkUser> linkUserList) {
        this.linkUserList = linkUserList;
    }

    public List<LinkTag> getLinkTagList() {
        return linkTagList;
    }

    public void setLinkTagList(List<LinkTag> linkTagList) {
        this.linkTagList = linkTagList;
    }

    public List<LinkReminder> getLinkReminderList() {
        return linkReminderList;
    }

    public void setLinkReminderList(List<LinkReminder> linkReminderList) {
        this.linkReminderList = linkReminderList;
    }

    public List<LinkHistory> getLinkHistoryList() {
        return linkHistoryList;
    }

    public void setLinkHistoryList(List<LinkHistory> linkHistoryList) {
        this.linkHistoryList = linkHistoryList;
    }

    public List<LinkTopic> getLinkTopicList() {
        return linkTopicList;
    }

    public void setLinkTopicList(List<LinkTopic> linkTopicList) {
        this.linkTopicList = linkTopicList;
    }

    public List<LinkTasks> getLinkTasksList() {
        return linkTasksList;
    }

    public void setLinkTasksList(List<LinkTasks> linkTasksList) {
        this.linkTasksList = linkTasksList;
    }
}
