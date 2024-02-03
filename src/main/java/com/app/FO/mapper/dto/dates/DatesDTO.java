package com.app.FO.mapper.dto.dates;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class DatesDTO {
    private Long datesId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public DatesDTO(Long datesId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.datesId = datesId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "DatesDTO{" +
                "datesId=" + datesId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getDatesId() {
        return datesId;
    }

    public void setDatesId(Long datesId) {
        this.datesId = datesId;
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
