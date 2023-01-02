package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class NoteDTO {
    private Long noteId;
    private String note;


    @Override
    public String toString() {
        return "NoteDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                '}';
    }

    public NoteDTO(Long noteId, String note) {
        this.noteId = noteId;
        this.note = note;
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
}


