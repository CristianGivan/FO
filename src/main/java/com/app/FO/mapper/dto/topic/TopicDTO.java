package com.app.FO.mapper.dto.topic;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class TopicDTO {
    private Long topicId;
    private String subject;
    private LocalDateTime createdDate;
    private UserDTO creator;


    public TopicDTO(Long topicId, String subject, LocalDateTime createdDate, UserDTO creator) {
        this.topicId = topicId;
        this.subject = subject;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "topicId=" + topicId +
                ", subject='" + subject + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
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

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }
}
