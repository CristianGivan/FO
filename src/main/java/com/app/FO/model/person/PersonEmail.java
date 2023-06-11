package com.app.FO.model.person;

import com.app.FO.model.email.Email;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_email")
public class PersonEmail {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_email_seq")
    @SequenceGenerator(name = "person_email_seq",
            sequenceName = "person_email_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_email_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "email_id")
    @JsonIgnore
    private Email email;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonEmail() {
    }

    public PersonEmail(Person person, Email email) {
        this.person = person;
        this.email = email;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonEmail{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", emailId=" + email.getId() +
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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
