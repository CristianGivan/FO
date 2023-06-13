package com.app.FO.model.theDay;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "the_day_history")
public class TheDayHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "the_day_history_seq")
    @SequenceGenerator(name = "the_day_history_seq",
            sequenceName = "the_day_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "the_day_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "the_day_id")
    @JsonIgnore
    private TheDay theDay;

    public TheDayHistory() {
    }

    @Override
    public String toString() {
        return "TheDayHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + theDay.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
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
}
