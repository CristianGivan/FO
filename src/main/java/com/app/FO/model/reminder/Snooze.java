package com.app.FO.model.reminder;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table (name = "snooze")
public class Snooze {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "snooze_seq")
    @SequenceGenerator(name = "snooze_seq",
            sequenceName = "snooze_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "snooze_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "remainder_id")
    private Reminder reminder;

    @Column(name = "snooze_time")
    private LocalTime snoozeTime;

    @Column(name = "snooze_count")
    private Integer snoozeCount;

    public Snooze() {
    }

    @Override
    public String toString() {
        return "Snooze{" +
                "id=" + id +
                ", remainderId=" + reminder.getId() +
                ", snoozeTime=" + snoozeTime +
                ", snoozeCount=" + snoozeCount +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Reminder getRemainder() {
        return reminder;
    }

    public void setRemainder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalTime getSnoozeTime() {
        return snoozeTime;
    }

    public void setSnoozeTime(LocalTime snoozeTime) {
        this.snoozeTime = snoozeTime;
    }

    public Integer getSnoozeCount() {
        return snoozeCount;
    }

    public void setSnoozeCount(Integer snoozeCount) {
        this.snoozeCount = snoozeCount;
    }
}