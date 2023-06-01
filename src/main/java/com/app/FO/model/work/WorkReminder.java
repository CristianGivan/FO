package com.app.FO.model.work;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_reminder")
public class WorkReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_reminder_seq")
    @SequenceGenerator(name = "work_reminder_seq",
            sequenceName = "work_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "work_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public WorkReminder() {
    }

    public WorkReminder(Work work, Reminder reminder) {
        this.work = work;
        this.reminder = reminder;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "WorkReminder{" +
                "id=" + id +
                ", workId=" + work.getId() +
                ", reminderId=" + reminder.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
