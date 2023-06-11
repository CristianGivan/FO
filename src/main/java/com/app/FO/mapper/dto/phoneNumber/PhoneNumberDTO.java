package com.app.FO.mapper.dto.phoneNumber;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class PhoneNumberDTO {
    private Long phoneNumberId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public PhoneNumberDTO(Long phoneNumberId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.phoneNumberId = phoneNumberId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "PhoneNumberDTO{" +
                "phoneNumberId=" + phoneNumberId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getPhoneNumberId() {
        return phoneNumberId;
    }

    public void setPhoneNumberId(Long phoneNumberId) {
        this.phoneNumberId = phoneNumberId;
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
