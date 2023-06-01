package com.app.FO.mapper.dto.person;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class PersonDTO {
    private Long personId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public PersonDTO(Long personId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.personId = personId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "personId=" + personId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getPersonId() {
        return personId;
    }

    public void setPersonId(Long personId) {
        this.personId = personId;
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
