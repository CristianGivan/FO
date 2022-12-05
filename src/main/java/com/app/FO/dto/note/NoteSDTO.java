package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class NoteSDTO {
    private Long id;
    private String note;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "NoteSDTO{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public NoteSDTO(Long id, String note, LocalDateTime createdDate) {
        this.id = id;
        this.note = note;
        this.createdDate = createdDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
