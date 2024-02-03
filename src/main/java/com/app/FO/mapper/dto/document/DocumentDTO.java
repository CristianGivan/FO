package com.app.FO.mapper.dto.document;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class DocumentDTO {
    private Long documentId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public DocumentDTO(Long documentId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.documentId = documentId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "DocumentDTO{" +
                "documentId=" + documentId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
    }

    public Long getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Long documentId) {
        this.documentId = documentId;
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
