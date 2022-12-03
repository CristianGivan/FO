package com.app.FO.dto;

import java.time.LocalDateTime;
import java.util.List;

public class NoteDTO {

    private String subject;
    private List<String> details;
    private List<String> tags;
    private Long userId;
    private LocalDateTime createdDate;
}
