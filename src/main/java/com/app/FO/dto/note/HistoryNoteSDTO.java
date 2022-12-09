package com.app.FO.dto.note;

import com.app.FO.dto.user.UserSDTO;

import java.time.LocalDateTime;

public class HistoryNoteSDTO {
    private Long historyNoteId;
    private LocalDateTime modifiedDate;
    private UserSDTO user;


    public HistoryNoteSDTO(Long HistoryNoteId, LocalDateTime modifiedDate, UserSDTO user) {
        this.historyNoteId = HistoryNoteId;
        this.modifiedDate = modifiedDate;
        this.user = user;
    }

    @Override
    public String toString() {
        return "HistoryNoteSDTO{" +
                "historyNoteId=" + historyNoteId +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                '}';
    }

    public Long getHistoryNoteId() {
        return historyNoteId;
    }

    public void setHistoryNoteId(Long historyNoteId) {
        this.historyNoteId = historyNoteId;
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