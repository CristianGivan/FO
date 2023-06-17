package com.app.FO.model.snooze;

import com.app.FO.model.reminder.ReminderSnooze;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "snooze")
public class Snooze {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snooze_seq")
    @SequenceGenerator(name = "snooze_seq",
            sequenceName = "snooze_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "snooze_id")
    private Long id;

    @Column(name = "subject")
    private String subject;

    @Column(name = "snooze_time")
    private LocalTime snoozeTime;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @OneToMany(mappedBy = "snooze", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<SnoozeUser> snoozeUserList;

    @OneToMany(mappedBy = "snooze", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<ReminderSnooze> reminderSnoozeList;

    public Snooze() {
    }

    public Snooze(String subject, User creator) {
        this.subject = subject;
        this.createdDateTime = LocalDateTime.now();
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Snooze{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", snoozeTime=" + snoozeTime +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator +
                ", snoozeUserList=" + snoozeUserList +
                ", reminderSnoozeList=" + reminderSnoozeList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalTime getSnoozeTime() {
        return snoozeTime;
    }

    public void setSnoozeTime(LocalTime snoozeTime) {
        this.snoozeTime = snoozeTime;
    }


    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public List<SnoozeUser> getSnoozeUserList() {
        if (snoozeUserList == null) {
            snoozeUserList = new ArrayList<>();
        }
        return snoozeUserList;
    }

    public void setSnoozeUserList(List<SnoozeUser> snoozeUserList) {
        this.snoozeUserList = snoozeUserList;
    }

    public List<ReminderSnooze> getReminderSnoozeList() {
        return reminderSnoozeList;
    }

    public void setReminderSnoozeList(List<ReminderSnooze> reminderSnoozeList) {
        this.reminderSnoozeList = reminderSnoozeList;
    }
}
