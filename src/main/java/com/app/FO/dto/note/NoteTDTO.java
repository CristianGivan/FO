package com.app.FO.dto.note;

import com.app.FO.model.tag.Tag;

import java.util.ArrayList;
import java.util.List;

public class NoteTDTO {
    private Long noteId;
    private String note;
    private List<Tag> tags;

    public NoteTDTO() {
    }

    public NoteTDTO(Long noteId, String note, List<Tag> tags) {
        this.noteId = noteId;
        this.note = note;
       // this.tags = tags;
    }

    @Override
    public String toString() {
        return "NoteTDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                '}';
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

    public List<Tag> getTags() {
        if (tags==null){
            return new ArrayList<>();
        }
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
