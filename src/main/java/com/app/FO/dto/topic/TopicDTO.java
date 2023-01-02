package com.app.FO.dto.topic;

import java.time.LocalDateTime;

public class TopicDTO {
    private Long topicId;
    private String subject;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "TopicDTO{" +
                "topicId=" + topicId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public TopicDTO(Long topicId, String subject, LocalDateTime createdDate) {
        this.topicId = topicId;
        this.subject = subject;
        this.createdDate = createdDate;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
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
