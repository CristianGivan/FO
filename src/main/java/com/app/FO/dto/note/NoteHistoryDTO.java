package com.app.FO.dto.note;

import com.app.FO.dto.user.UserSDTO;

import java.time.LocalDateTime;

public class NoteHistoryDTO {
    private Long id;
    private LocalDateTime modifiedDate;
    private UserSDTO user;

    private NoteSDTO note;

    private String noteText;


    public NoteHistoryDTO(Long id, LocalDateTime modifiedDate, UserSDTO user, NoteSDTO note,
                          String noteText) {
        this.id = id;
        this.modifiedDate = modifiedDate;
        this.user = user;
        this.note = note;
        this.noteText = noteText;
    }

    @Override
    public String toString() {
        return "HistoryNoteSDTO{" +
                "historyNoteId=" + id +
                ", modifiedDate=" + modifiedDate +
                ", user=" + user +
                '}';
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

    public NoteSDTO getNote() {
        return note;
    }

    public void setNote(NoteSDTO note) {
        this.note = note;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
