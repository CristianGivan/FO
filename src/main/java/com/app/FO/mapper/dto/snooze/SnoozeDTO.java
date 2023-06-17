package com.app.FO.mapper.dto.snooze;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class SnoozeDTO {
    private Long snoozeId;
    private String subject;
    private LocalTime snoozeTime;
    private LocalDateTime createdDateTime;

    public SnoozeDTO(Long snoozeId, String subject, LocalTime snoozeTime, LocalDateTime createdDateTime) {
        this.snoozeId = snoozeId;
        this.subject = subject;
        this.snoozeTime = snoozeTime;
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "SnoozeDTO{" +
                "snoozeId=" + snoozeId +
                ", subject='" + subject + '\'' +
                ", snoozeTime=" + snoozeTime +
                ", createdDateTime=" + createdDateTime +
                '}';
    }

    public Long getSnoozeId() {
        return snoozeId;
    }

    public void setSnoozeId(Long snoozeId) {
        this.snoozeId = snoozeId;
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
}
