package com.app.FO.dto.note;

import com.app.FO.dto.user.UserSDTO;

import java.time.LocalDateTime;
import java.util.List;

public class NoteDTO {

    private Long id;
    private String note;
    private List<TagSDTO> tags;
    private UserSDTO user;
    private LocalDateTime createdDateTime;
    private List<TopicSDTO> topicsThatContainTheNote;
    private List<HistoryNoteSDTO> noteHistory;


    public NoteDTO(Long id, String note, List<TagSDTO> tags, UserSDTO user,
                   LocalDateTime createdDateTime, List<TopicSDTO> topicsThatContainTheNote,
                   List<HistoryNoteSDTO> noteHistory) {
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
        return "NoteFDTO{" +
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

    public List<TagSDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagSDTO> tags) {
        this.tags = tags;
    }

    public UserSDTO getUser() {
        return user;
    }

    public void setUser(UserSDTO user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<TopicSDTO> getTopicsThatContainTheNote() {
        return topicsThatContainTheNote;
    }

    public void setTopicsThatContainTheNote(List<TopicSDTO> topicsThatContainTheNote) {
        this.topicsThatContainTheNote = topicsThatContainTheNote;
    }

    public List<HistoryNoteSDTO> getNoteHistory() {
        return noteHistory;
    }

    public void setNoteHistory(List<HistoryNoteSDTO> noteHistory) {
        this.noteHistory = noteHistory;
    }
}
