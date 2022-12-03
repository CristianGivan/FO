package com.app.FO.dto.note.unclear;

import java.time.LocalDateTime;
import java.util.List;

public class ShowTopicsWithIdsDTO {
    private Long id;
    private String subject;
    private List<Long> notesId;
    private List<Long> tagsId;
    private Long userId;
    private LocalDateTime createdDate;
    private List<Long> topicHistoriesId;

}
