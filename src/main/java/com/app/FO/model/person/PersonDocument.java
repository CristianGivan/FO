package com.app.FO.model.person;

import com.app.FO.model.document.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_document")
public class PersonDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_document_seq")
    @SequenceGenerator(name = "person_document_seq",
            sequenceName = "person_document_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_document_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "document_id")
    @JsonIgnore
    private Document document;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonDocument() {
    }

    public PersonDocument(Person person, Document document) {
        this.person = person;
        this.document = document;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonDocument{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", documentId=" + document.getId() +
                ", personDate=" + personDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
