package com.app.FO.mapper.dto.reminder;

import java.time.LocalDateTime;

public class ReminderDTO {
    private Long reminderId;
    private String subject;
    private LocalDateTime reminderDateTime;
    private LocalDateTime createdDateTime;

    public ReminderDTO(Long reminderId, String subject, LocalDateTime reminderDate, LocalDateTime createdDateTime) {
        this.reminderId = reminderId;
        this.subject = subject;
        this.reminderDateTime = reminderDate;
        this.createdDateTime = createdDateTime;
    }

    @Override
    public String toString() {
        return "ReminderDTO{" +
                "reminderId=" + reminderId +
                ", subject='" + subject + '\'' +
                ", reminderDate=" + reminderDateTime +
                ", createdDateTime=" + createdDateTime +
                '}';
    }

    public Long getReminderId() {
        return reminderId;
    }

    public void setReminderId(Long reminderId) {
        this.reminderId = reminderId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
