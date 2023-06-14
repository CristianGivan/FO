package com.app.FO.model.person;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_person")
public class PersonPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_person_seq")
    @SequenceGenerator(name = "person_person_seq",
            sequenceName = "person_person_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_person_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "related_person_id")
    @JsonIgnore
    private Person relatedPerson;

    @Column(name = "linked_date")
    private LocalDateTime linkedDate;

    public PersonPerson() {
    }

    public PersonPerson(Person person, Person relatedPerson) {
        this.person = person;
        this.relatedPerson = relatedPerson;
        this.linkedDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonPerson{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", relatedPersonId=" + relatedPerson.getId() +
                ", personDate=" + linkedDate +
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

    public Person getRelatedPerson() {
        return relatedPerson;
    }

    public void setRelatedPerson(Person relatedPerson) {
        this.relatedPerson = relatedPerson;
    }

    public LocalDateTime getLinkedDate() {
        return linkedDate;
    }

    public void setLinkedDate(LocalDateTime linkedDate) {
        this.linkedDate = linkedDate;
    }
}
