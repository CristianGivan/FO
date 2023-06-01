package com.app.FO.model.dates;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dates_user")
public class DatesUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_user_seq")
    @SequenceGenerator(name = "dates_user_seq",
            sequenceName = "dates_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private com.app.FO.model.dates.Dates dates;

    @Column(name = "dates_date")
    private LocalDateTime datesDate;

    public DatesUser() {
    }

    public DatesUser(com.app.FO.model.dates.Dates dates, User user) {
        this.user = user;
        this.dates = dates;
        this.datesDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "DatesTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.app.FO.model.dates.Dates getDates() {
        return dates;
    }

    public void setDates(com.app.FO.model.dates.Dates dates) {
        this.dates = dates;
    }

    public LocalDateTime getDatesDate() {
        return datesDate;
    }

    public void setDatesDate(LocalDateTime datesDate) {
        this.datesDate = datesDate;
    }
}
