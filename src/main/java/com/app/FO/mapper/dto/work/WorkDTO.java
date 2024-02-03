package com.app.FO.mapper.dto.work;

import com.app.FO.mapper.dto.topic.TopicDTO;
import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class WorkDTO {
    private Long workId;

    private LocalDateTime workingDate;

    private Double workingTime;

    private LocalDateTime createdDate;

    private UserDTO creator;

    private TopicDTO topic;

    public WorkDTO() {
    }

    @Override
    public String toString() {
        return "WorkDTO{" +
                "workId=" + workId +
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                ", topic=" + topic +
                '}';
    }

    public Long getWorkId() {
        return workId;
    }

    public void setWorkId(Long workId) {
        this.workId = workId;
    }

    public LocalDateTime getWorkingDate() {
        return workingDate;
    }

    public void setWorkingDate(LocalDateTime workingDate) {
        this.workingDate = workingDate;
    }

    public Double getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(Double workingTime) {
        this.workingTime = workingTime;
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

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
    }
}
