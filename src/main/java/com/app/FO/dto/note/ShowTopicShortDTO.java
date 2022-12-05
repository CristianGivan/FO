package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class ShowTopicShortDTO {
    private Long id;
    private String subject;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "ShowTopicShortDTO{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public ShowTopicShortDTO(Long id, String subject, LocalDateTime createdDate) {
        this.id = id;
        this.subject = subject;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
