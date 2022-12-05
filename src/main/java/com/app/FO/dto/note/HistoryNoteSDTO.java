package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class HistoryNoteSDTO {
    private Long id;
    private LocalDateTime modifiedDate;

    public HistoryNoteSDTO(Long id, LocalDateTime modifiedDate) {
        this.id = id;
        this.modifiedDate = modifiedDate;
    }

    @Override
    public String toString() {
        return "HistoryNoteSDTO{" +
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
