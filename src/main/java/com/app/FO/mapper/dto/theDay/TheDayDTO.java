package com.app.FO.mapper.dto.theDay;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class TheDayDTO {
    private Long theDayId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public TheDayDTO(Long theDayId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.theDayId = theDayId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TheDayDTO{" +
                "theDayId=" + theDayId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getTheDayId() {
        return theDayId;
    }

    public void setTheDayId(Long theDayId) {
        this.theDayId = theDayId;
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
