package com.app.FO.dto.snooze;

import com.app.FO.dto.remainder.RemainderDTO;

import java.time.LocalTime;

public class SnoozeDTO {
    private RemainderDTO remainder;
    private LocalTime snoozeTime;
    private Integer snoozeCount;

    @Override
    public String toString() {
        return "SnoozeDTO{" +
                "remainder=" + remainder +
                ", snoozeTime=" + snoozeTime +
                ", snoozeCount=" + snoozeCount +
                '}';
    }

    public SnoozeDTO(RemainderDTO remainder, LocalTime snoozeTime, Integer snoozeCount) {
        this.remainder = remainder;
        this.snoozeTime = snoozeTime;
        this.snoozeCount = snoozeCount;
    }

    public RemainderDTO getRemainder() {
        return remainder;
    }

    public void setRemainder(RemainderDTO remainder) {
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
