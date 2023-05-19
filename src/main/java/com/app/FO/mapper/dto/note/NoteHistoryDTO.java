package com.app.FO.mapper.dto.note;

import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;

public class NoteHistoryDTO {
    private Long id;
    private LocalDateTime modifiedDate;
    private UserDTO user;

    private NoteDTO note;

    private String noteText;


    public NoteHistoryDTO(Long id, LocalDateTime modifiedDate, UserDTO user, NoteDTO note,
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public NoteDTO getNote() {
        return note;
    }

    public void setNote(NoteDTO note) {
        this.note = note;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }
}
