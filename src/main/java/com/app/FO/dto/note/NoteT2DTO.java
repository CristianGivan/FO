package com.app.FO.dto.note;

import com.app.FO.dto.tag.TagDTO;

import java.util.List;

public class NoteT2DTO {
    private Long noteId;
    private String note;
    private List<TagDTO> tags;

    @Override
    public String toString() {
        return "NoteT2DTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                '}';
    }

    public NoteT2DTO(Long noteId, String note, List<TagDTO> tags) {
        this.noteId = noteId;
        this.note = note;
        this.tags = tags;
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

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
}
