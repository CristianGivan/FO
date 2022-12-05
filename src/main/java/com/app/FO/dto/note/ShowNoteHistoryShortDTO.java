package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class ShowNoteHistoryShortDTO {
    private Long id;
    private LocalDateTime modifiedDate;

    public ShowNoteHistoryShortDTO(Long id, LocalDateTime modifiedDate) {
        this.id = id;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "ShowNoteHistoryShortDTO{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
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
}
