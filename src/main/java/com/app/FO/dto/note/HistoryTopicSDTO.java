package com.app.FO.dto.note;

import com.app.FO.dto.user.UserSDTO;
import com.app.FO.model.user.User;

import java.time.LocalDateTime;

public class HistoryTopicSDTO {
    private Long id;
    private LocalDateTime modifiedDate;
    private UserSDTO user;

    public HistoryTopicSDTO() {
    }

    @Override
    public String toString() {
        return "HistoryTopicSDTO{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                '}';
    }

    public HistoryTopicSDTO(Long id, LocalDateTime modifiedDate, UserSDTO user) {
        this.id = id;
        this.modifiedDate = modifiedDate;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public UserSDTO getUser() {
        return user;
    }

    public void setUser(UserSDTO user) {
        this.user = user;
    }
}
