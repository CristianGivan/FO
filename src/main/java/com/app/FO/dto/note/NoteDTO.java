package com.app.FO.dto.note;

import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;

public class NoteDTO {
    private Long noteId;
    private String noteText;
    private LocalDateTime createdDate;
    private UserDTO creator;

    public NoteDTO(Long noteId, String noteText, LocalDateTime createdDate, UserDTO creator) {
        this.noteId = noteId;
        this.noteText = noteText;
        this.createdDate = createdDate;
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "noteId=" + noteId +
                ", noteText='" + noteText + '\'' +
                ", createdDate=" + createdDate +
                ", creator=" + creator +
                '}';
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


