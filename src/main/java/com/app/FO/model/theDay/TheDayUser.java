package com.app.FO.model.theDay;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_user")
public class TheDayUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_user_seq")
    @SequenceGenerator(name = "the_day_user_seq",
            sequenceName = "the_day_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    @Column(name = "the_day_date")
    private LocalDateTime theDayDate;

    public TheDayUser() {
    }

    public TheDayUser(TheDay theDay, User user) {
        this.user = user;
        this.theDay = theDay;
        this.theDayDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TheDayTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
