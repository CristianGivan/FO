package com.app.FO.model.document;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_reminder")
public class DocumentReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_reminder_seq")
    @SequenceGenerator(name = "document_reminder_seq",
            sequenceName = "document_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    public DocumentReminder() {
    }

    public DocumentReminder(Document document, Reminder reminder) {
        this.document = document;
        this.reminder = reminder;
        this.documentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DocumentReminder{" +
                "id=" + id +
                ", documentId=" + document.getId() +
                ", reminderId=" + reminder.getId() +
                ", documentDate=" + documentDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDateTime documentDate) {
        this.documentDate = documentDate;
    }
}
