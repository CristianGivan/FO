package com.app.FO.model.remainder;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table (name = "snoozes")
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
    private Remainder remainder;

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
                ", remainderId=" + remainder.getId() +
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

    public Remainder getRemainder() {
        return remainder;
    }

    public void setRemainder(Remainder remainder) {
        this.remainder = remainder;
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
