package com.app.FO.model.person;

import com.app.FO.model.phoneNumber.PhoneNumber;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_phone_number")
public class PersonPhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_phone_number_seq")
    @SequenceGenerator(name = "person_phone_number_seq",
            sequenceName = "person_phone_number_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_phone_number_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "phoneNumber_id")
    @JsonIgnore
    private PhoneNumber phoneNumber;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonPhoneNumber() {
    }

    public PersonPhoneNumber(Person person, PhoneNumber phoneNumber) {
        this.person = person;
        this.phoneNumber = phoneNumber;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonPhoneNumber{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", phoneNumberId=" + phoneNumber.getId() +
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

    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
