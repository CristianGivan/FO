package com.app.FO.mapper.dto.reminder;

import java.time.LocalDateTime;

public class ReminderDTO {
    private Long id;
    private String reminder;
    private LocalDateTime createdDateTime;
    private LocalDateTime reminderDateTime;

    public ReminderDTO(String reminder, LocalDateTime createdDateTime, LocalDateTime reminderDateTime) {
        this.reminder = reminder;
        this.createdDateTime = createdDateTime;
        this.reminderDateTime = reminderDateTime;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }
}
