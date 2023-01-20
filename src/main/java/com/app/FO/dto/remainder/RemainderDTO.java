package com.app.FO.dto.remainder;

import java.time.LocalDateTime;

public class RemainderDTO {
    private Long id;
    private String remainder;
    private LocalDateTime createdDateTime;
    private LocalDateTime remainderDateTime;

    public RemainderDTO(String remainder, LocalDateTime createdDateTime, LocalDateTime remainderDateTime) {
        this.remainder = remainder;
        this.createdDateTime = createdDateTime;
        this.remainderDateTime = remainderDateTime;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getRemainderDateTime() {
        return remainderDateTime;
    }

    public void setRemainderDateTime(LocalDateTime remainderDateTime) {
        this.remainderDateTime = remainderDateTime;
    }
}
