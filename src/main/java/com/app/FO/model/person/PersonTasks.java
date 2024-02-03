package com.app.FO.model.person;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "person_tasks")
public class PersonTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_tasks_seq")
    @SequenceGenerator(name = "person_tasks_seq",
            sequenceName = "person_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "person_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @JsonIgnore
    private Person person;

    @Column(name = "person_date")
    private LocalDateTime personDate;

    public PersonTasks() {
    }

    public PersonTasks(Person person, Tasks tasks) {
        this.person = person;
        this.tasks = tasks;
        this.personDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "PersonTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
