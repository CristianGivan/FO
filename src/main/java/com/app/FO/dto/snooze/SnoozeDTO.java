package com.app.FO.dto.snooze;

import com.app.FO.dto.reminder.ReminderDTO;

import java.time.LocalTime;

public class SnoozeDTO {
    private ReminderDTO reminder;
    private LocalTime snoozeTime;
    private Integer snoozeCount;

    @Override
    public String toString() {
        return "SnoozeDTO{" +
                "reminder=" + reminder +
                ", snoozeTime=" + snoozeTime +
                ", snoozeCount=" + snoozeCount +
                '}';
    }

    public SnoozeDTO(ReminderDTO reminder, LocalTime snoozeTime, Integer snoozeCount) {
        this.reminder = reminder;
        this.snoozeTime = snoozeTime;
        this.snoozeCount = snoozeCount;
    }

    public ReminderDTO getReminder() {
        return reminder;
    }

    public void setReminder(ReminderDTO reminder) {
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
