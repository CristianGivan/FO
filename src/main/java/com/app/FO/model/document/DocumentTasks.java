package com.app.FO.model.document;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_tasks")
public class DocumentTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_tasks_seq")
    @SequenceGenerator(name = "document_tasks_seq",
            sequenceName = "document_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    public DocumentTasks() {
    }

    public DocumentTasks(Document document, Tasks tasks) {
        this.document = document;
        this.tasks = tasks;
        this.documentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DocumentTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
