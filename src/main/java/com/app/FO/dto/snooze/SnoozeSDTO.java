package com.app.FO.dto.snooze;

import com.app.FO.dto.remainder.RemainderSDTO;
import com.app.FO.model.remainder.Remainder;

import java.time.LocalTime;

public class SnoozeSDTO {
    private RemainderSDTO remainder;
    private LocalTime snoozeTime;
    private Integer snoozeCount;

    @Override
    public String toString() {
        return "SnoozeSDTO{" +
                "remainder=" + remainder +
                ", snoozeTime=" + snoozeTime +
                ", snoozeCount=" + snoozeCount +
                '}';
    }

    public SnoozeSDTO(RemainderSDTO remainder, LocalTime snoozeTime, Integer snoozeCount) {
        this.remainder = remainder;
        this.snoozeTime = snoozeTime;
        this.snoozeCount = snoozeCount;
    }

    public RemainderSDTO getRemainder() {
        return remainder;
    }

    public void setRemainder(RemainderSDTO remainder) {
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
