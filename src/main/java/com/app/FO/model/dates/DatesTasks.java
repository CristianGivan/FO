package com.app.FO.model.dates;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_tasks")
public class DatesTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_tasks_seq")
    @SequenceGenerator(name = "dates_tasks_seq",
            sequenceName = "dates_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    @Column(name = "dates_date")
    private LocalDateTime datesDate;

    public DatesTasks() {
    }

    public DatesTasks(Dates dates, Tasks tasks) {
        this.dates = dates;
        this.tasks = tasks;
        this.datesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DatesTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", dates=" + dates.getId() +
                ", datesDate=" + datesDate +
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

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }

    public LocalDateTime getDatesDate() {
        return datesDate;
    }

    public void setDatesDate(LocalDateTime datesDate) {
        this.datesDate = datesDate;
    }
}
