package com.app.FO.model.document;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_user")
public class DocumentUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_user_seq")
    @SequenceGenerator(name = "document_user_seq",
            sequenceName = "document_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    public DocumentUser() {
    }

    public DocumentUser(Document document, User user) {
        this.user = user;
        this.document = document;
        this.documentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DocumentTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", document=" + document.getId() +
                ", documentDate=" + documentDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDateTime documentDate) {
        this.documentDate = documentDate;
    }
}
