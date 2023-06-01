package com.app.FO.model.person;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_tag")
public class PersonTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_tag_seq")
    @SequenceGenerator(name = "person_tag_seq",
            sequenceName = "person_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonTag() {
    }

    public PersonTag(Person person, Tag tag) {
        this.person = person;
        this.tag = tag;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonTag{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", tagId=" + tag.getId() +
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
