package com.app.FO.model.person;

import com.app.FO.model.address.Address;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_address")
public class PersonAddress {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_address_seq")
    @SequenceGenerator(name = "person_address_seq",
            sequenceName = "person_address_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_address_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "address_id")
    @JsonIgnore
    private Address address;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonAddress() {
    }

    public PersonAddress(Person person, Address address) {
        this.person = person;
        this.address = address;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonAddress{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", addressId=" + address.getId() +
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
