package com.app.FO.model.person;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_user")
public class PersonUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_user_seq")
    @SequenceGenerator(name = "person_user_seq",
            sequenceName = "person_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonUser() {
    }

    public PersonUser(Person person, User user) {
        this.user = user;
        this.person = person;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", person=" + person.getId() +
                ", personDate=" + personDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public LocalDateTime getPersonDate() {
        return personDate;
    }

    public void setPersonDate(LocalDateTime personDate) {
        this.personDate = personDate;
    }
}
