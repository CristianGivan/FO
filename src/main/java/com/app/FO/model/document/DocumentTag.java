package com.app.FO.model.document;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "document_tag")
public class DocumentTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "document_tag_seq")
    @SequenceGenerator(name = "document_tag_seq",
            sequenceName = "document_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "document_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "document_date")
    private LocalDateTime documentDate;

    public DocumentTag() {
    }

    public DocumentTag(Document document, Tag tag) {
        this.document = document;
        this.tag = tag;
        this.documentDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DocumentTag{" +
                "id=" + id +
                ", documentId=" + document.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getDocumentDate() {
        return documentDate;
    }

    public void setDocumentDate(LocalDateTime documentDate) {
        this.documentDate = documentDate;
    }
}
