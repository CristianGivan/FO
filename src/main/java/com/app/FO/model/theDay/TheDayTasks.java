package com.app.FO.model.theDay;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_tasks")
public class TheDayTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_tasks_seq")
    @SequenceGenerator(name = "the_day_tasks_seq",
            sequenceName = "the_day_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    @Column(name = "the_day_date")
    private LocalDateTime theDayDate;

    public TheDayTasks() {
    }

    public TheDayTasks(TheDay theDay, Tasks tasks) {
        this.theDay = theDay;
        this.tasks = tasks;
        this.theDayDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDayTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", theDay=" + theDay.getId() +
                ", theDayDate=" + theDayDate +
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

    public TheDay getTheDay() {
        return theDay;
    }

    public void setTheDay(TheDay theDay) {
        this.theDay = theDay;
    }

    public LocalDateTime getTheDayDate() {
        return theDayDate;
    }

    public void setTheDayDate(LocalDateTime theDayDate) {
        this.theDayDate = theDayDate;
    }
}
