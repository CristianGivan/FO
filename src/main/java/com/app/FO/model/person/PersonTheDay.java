package com.app.FO.model.person;

import com.app.FO.model.theDay.TheDay;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_the_day")
public class PersonTheDay {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_the_day_seq")
    @SequenceGenerator(name = "person_the_day_seq",
            sequenceName = "person_the_day_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_the_day_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "the_theDay_id")
    @JsonIgnore
    private TheDay theDay;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonTheDay() {
    }

    public PersonTheDay(Person person, TheDay theDay) {
        this.person = person;
        this.theDay = theDay;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonTheDay{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", theDayId=" + theDay.getId() +
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

    public TheDay getTheDay() {
        return theDay;
    }

    public void setTheDay(TheDay theDay) {
        this.theDay = theDay;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
