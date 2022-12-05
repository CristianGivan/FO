package com.app.FO.dto.note;

import com.app.FO.dto.user.ShowUserShortDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ShowNoteDTO {

    private Long id;
    private String note;
    private List<ShowTagShortDTO> tags;
    private ShowUserShortDTO user;
    private LocalDateTime createdDateTime;
    private List<ShowTopicShortDTO> topicsThatContainTheNote;
    private List<ShowNoteHistoryShortDTO> noteHistory;


    public ShowNoteDTO(Long id, String note, List<ShowTagShortDTO> tags, ShowUserShortDTO user,
                       LocalDateTime createdDateTime, List<ShowTopicShortDTO> topicsThatContainTheNote,
                       List<ShowNoteHistoryShortDTO> noteHistory) {
        this.id = id;
        this.note = note;
        this.tags = tags;
        this.user = user;
        this.createdDateTime = createdDateTime;
        this.topicsThatContainTheNote = topicsThatContainTheNote;
        this.noteHistory = noteHistory;
    }

    @Override
    public String toString() {
        return "ShowNoteDTO{" +
                "id=" + id +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                ", user=" + user +
                ", createdDateTime=" + createdDateTime +
                ", topicsThatContainTheNote=" + topicsThatContainTheNote +
                ", noteHistory=" + noteHistory +
                '}';
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

    public List<ShowTagShortDTO> getTags() {
        return tags;
    }

    public void setTags(List<ShowTagShortDTO> tags) {
        this.tags = tags;
    }

    public ShowUserShortDTO getUser() {
        return user;
    }

    public void setUser(ShowUserShortDTO user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<ShowTopicShortDTO> getTopicsThatContainTheNote() {
        return topicsThatContainTheNote;
    }

    public void setTopicsThatContainTheNote(List<ShowTopicShortDTO> topicsThatContainTheNote) {
        this.topicsThatContainTheNote = topicsThatContainTheNote;
    }

    public List<ShowNoteHistoryShortDTO> getNoteHistory() {
        return noteHistory;
    }

    public void setNoteHistory(List<ShowNoteHistoryShortDTO> noteHistory) {
        this.noteHistory = noteHistory;
    }
}
