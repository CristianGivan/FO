package com.app.FO.model.person;

import com.app.FO.model.dates.Dates;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_dates")
public class PersonDates {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_dates_seq")
    @SequenceGenerator(name = "person_dates_seq",
            sequenceName = "person_dates_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_dates_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "the_dates_id")
    @JsonIgnore
    private Dates dates;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonDates() {
    }

    public PersonDates(Person person, Dates dates) {
        this.person = person;
        this.dates = dates;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonDates{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", datesId=" + dates.getId() +
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

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
