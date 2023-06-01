package com.app.FO.mapper.dto.link;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class LinkDTO {
    private Long linkId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public LinkDTO(Long linkId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.linkId = linkId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "LinkDTO{" +
                "linkId=" + linkId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getLinkId() {
        return linkId;
    }

    public void setLinkId(Long linkId) {
        this.linkId = linkId;
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
