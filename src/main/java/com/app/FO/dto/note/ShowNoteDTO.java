package com.app.FO.dto.note;

import java.time.LocalDateTime;
import java.util.List;

public class ShowNoteDTO {

    private Long id;
    private String note;
    private List<ShowTagShortDTO> tags;
    private ShowTagShortDTO user;
    private LocalDateTime createdDateTime;
    private List<ShowTopicDTO> topicsContaining;
    private List<ShowNoteHistoryShortDTO> noteHistory;


    public ShowNoteDTO(Long id, String note, List<ShowTagShortDTO> tags, ShowTagShortDTO user,
                       LocalDateTime createdDateTime, List<ShowTopicDTO> topicsContaining,
                       List<ShowNoteHistoryShortDTO> noteHistory) {
        this.id = id;
        this.note = note;
        this.tags = tags;
        this.user = user;
        this.createdDateTime = createdDateTime;
        this.topicsContaining = topicsContaining;
        this.noteHistory = noteHistory;
    }
}
