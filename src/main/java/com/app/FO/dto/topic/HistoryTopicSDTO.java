package com.app.FO.dto.topic;

import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;

public class HistoryTopicSDTO {
    private Long historyTopicId;
    private LocalDateTime modifiedDate;
    private UserDTO user;

    public HistoryTopicSDTO() {
    }

    @Override
    public String toString() {
        return "HistoryTopicSDTO{" +
                "historyTopicId=" + historyTopicId +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                '}';
    }

    public HistoryTopicSDTO(Long historyTopicId, LocalDateTime modifiedDate, UserDTO user) {
        this.historyTopicId = historyTopicId;
        this.modifiedDate = modifiedDate;
        this.user = user;
    }

    public Long getHistoryTopicId() {
        return historyTopicId;
    }

    public void setHistoryTopicId(Long historyTopicId) {
        this.historyTopicId = historyTopicId;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }
}
