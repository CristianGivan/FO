package com.app.FO.model.snooze;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "snooze_user")
public class SnoozeUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snooze_user_seq")
    @SequenceGenerator(name = "snooze_user_seq",
            sequenceName = "snooze_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "snooze_user_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "snooze_id")
    @JsonIgnore
    private Snooze snooze;

    @Column(name = "snooze_date")
    private LocalDateTime snoozeDate;

    public SnoozeUser() {
    }

    public SnoozeUser(Snooze snooze, User user) {
        this.user = user;
        this.snooze = snooze;
        this.snoozeDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "SnoozeTasks{" +
                "id=" + id +
                ", taskId=" + user.getId() +
                ", snooze=" + snooze.getId() +
                ", snoozeDate=" + snoozeDate +
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

    public Snooze getSnooze() {
        return snooze;
    }

    public void setSnooze(Snooze snooze) {
        this.snooze = snooze;
    }

    public LocalDateTime getSnoozeDate() {
        return snoozeDate;
    }

    public void setSnoozeDate(LocalDateTime snoozeDate) {
        this.snoozeDate = snoozeDate;
    }
}
