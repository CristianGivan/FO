package com.app.FO.mapper.dto.event;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class EventDTO {
    private Long eventId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public EventDTO(Long eventId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.eventId = eventId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "EventDTO{" +
                "eventId=" + eventId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
