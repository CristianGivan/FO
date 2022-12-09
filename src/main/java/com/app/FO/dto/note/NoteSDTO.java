package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class NoteSDTO {
    private Long noteId;
    private String note;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "NoteSDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public NoteSDTO(Long noteId, String note, LocalDateTime createdDate) {
        this.noteId = noteId;
        this.note = note;
        this.createdDate = createdDate;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
