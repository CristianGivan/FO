package com.app.FO.model.document;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "document")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_seq")
    @SequenceGenerator(name = "document_seq",
            sequenceName = "document_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_id")
    private Long id;

    @Column(name = "subject")
    private String subject;
    @Column(name = "reference")
    private String reference;
    @Column(name = "created_date")
    private LocalDateTime createdDate;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentUser> documentUserList;

    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentTag> documentTagList;

    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentReminder> documentReminderList;

    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentTopic> documentTopicList;

    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentTasks> documentTasksList;
    @OneToMany(mappedBy = "document", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<DocumentHistory> documentHistoryList;


    public Document() {
    }

    public Document(String subject, User creator) {
        this.subject = subject;
        this.reference = reference;
        this.creator = creator;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "Document{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", reference='" + reference + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", documentUserList=" + documentUserList +
                ", documentTopicList=" + documentTopicList +
                ", documentTasksList=" + documentTasksList +
                ", documentUserList=" + documentUserList +
                ", documentTagList=" + documentTagList +
                ", documentReminderList=" + documentReminderList +
                ", documentHistoryList=" + documentHistoryList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        if (reference == null) {
            reference = "";
        }
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReference() {
        if (reference == null) {
            reference = "";
        }
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

    public List<DocumentUser> getDocumentUserList() {
        if (documentUserList == null) {
            documentUserList = new ArrayList<>();
        }
        return documentUserList;
    }

    public void setDocumentUserList(List<DocumentUser> documentUserList) {
        this.documentUserList = documentUserList;
    }

    public List<DocumentTag> getDocumentTagList() {
        if (documentTagList == null) {
            documentTagList = new ArrayList<>();
        }
        return documentTagList;
    }

    public void setDocumentTagList(List<DocumentTag> documentTagList) {
        this.documentTagList = documentTagList;
    }

    public List<DocumentReminder> getDocumentReminderList() {
        if (documentReminderList == null) {
            documentReminderList = new ArrayList<>();
        }
        return documentReminderList;
    }

    public void setDocumentReminderList(List<DocumentReminder> documentReminderList) {
        this.documentReminderList = documentReminderList;
    }


    public List<DocumentTopic> getDocumentTopicList() {
        if (documentTopicList == null) {
            documentTopicList = new ArrayList<>();
        }
        return documentTopicList;
    }

    public void setDocumentTopicList(List<DocumentTopic> documentTopicList) {
        this.documentTopicList = documentTopicList;
    }

    public List<DocumentTasks> getDocumentTasksList() {
        if (documentTasksList == null) {
            documentTasksList = new ArrayList<>();
        }
        return documentTasksList;
    }

    public void setDocumentTasksList(List<DocumentTasks> documentTasksList) {
        this.documentTasksList = documentTasksList;
    }

    public List<DocumentHistory> getDocumentHistoryList() {
        if (documentHistoryList == null) {
            documentHistoryList = new ArrayList<>();
        }
        return documentHistoryList;
    }

    public void setDocumentHistoryList(List<DocumentHistory> documentHistoryList) {
        this.documentHistoryList = documentHistoryList;
    }
}
