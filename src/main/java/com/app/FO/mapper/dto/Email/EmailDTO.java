package com.app.FO.mapper.dto.email;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class EmailDTO {
    private Long emailId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public EmailDTO(Long emailId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.emailId = emailId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "EmailDTO{" +
                "emailId=" + emailId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getEmailId() {
        return emailId;
    }

    public void setEmailId(Long emailId) {
        this.emailId = emailId;
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
