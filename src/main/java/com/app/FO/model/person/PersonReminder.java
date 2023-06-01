package com.app.FO.model.person;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_reminder")
public class PersonReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_reminder_seq")
    @SequenceGenerator(name = "person_reminder_seq",
            sequenceName = "person_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonReminder() {
    }

    public PersonReminder(Person person, Reminder reminder) {
        this.person = person;
        this.reminder = reminder;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonReminder{" +
                "id=" + id +
                ", personId=" + person.getId() +
                ", reminderId=" + reminder.getId() +
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

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
