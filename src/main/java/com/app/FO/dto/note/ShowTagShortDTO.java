package com.app.FO.dto.note;

import java.time.LocalDateTime;

public class ShowTagShortDTO {
    private Long id;
    private String tagName;


    public ShowTagShortDTO(Long id, String tagName) {
        this.id = id;
        this.tagName = tagName;

    }
}
