package com.app.FO.model.dates;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class DatesHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dates_history_seq")
    @SequenceGenerator(name = "dates_history_seq",
            sequenceName = "dates_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "dates_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "dates_id")
    @JsonIgnore
    private Dates dates;

    public DatesHistory() {
    }

    @Override
    public String toString() {
        return "DatesHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + dates.getId() +
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

    public Dates getDates() {
        return dates;
    }

    public void setDates(Dates dates) {
        this.dates = dates;
    }
}
