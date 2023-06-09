package com.app.FO.model.document;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class DocumentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_history_seq")
    @SequenceGenerator(name = "document_history_seq",
            sequenceName = "document_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    public DocumentHistory() {
    }

    @Override
    public String toString() {
        return "DocumentHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + document.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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
}
