package com.app.FO.model.reminder;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_history")
public class ReminderHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_history_seq")
    @SequenceGenerator(name = "reminder_history_seq",
            sequenceName = "reminder_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    //todo o sa adaug si celelate lucri care le veau in History

    public ReminderHistory() {
    }

    @Override
    public String toString() {
        return "ReminderHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", reminderId=" + reminder.getId() +
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

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
