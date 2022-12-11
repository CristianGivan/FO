package com.app.FO.dto.note;

import com.app.FO.dto.user.UserSDTO;

import java.time.LocalDateTime;

public class HistoryNoteSDTO {
    private Long historyNoteId;
    private LocalDateTime modifiedDate;
    private UserSDTO user;

    private Long noteId;

    private String noteText;


    public HistoryNoteSDTO(Long historyNoteId, LocalDateTime modifiedDate, UserSDTO user, Long noteId,
                           String noteText) {
        this.historyNoteId = historyNoteId;
        this.modifiedDate = modifiedDate;
        this.user = user;
        this.noteId = noteId;
        this.noteText = noteText;
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

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
