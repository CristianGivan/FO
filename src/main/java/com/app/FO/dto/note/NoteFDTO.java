package com.app.FO.dto.note;

import com.app.FO.dto.remainder.RemainderSDTO;
import com.app.FO.dto.tag.TagSDTO;
import com.app.FO.dto.topic.TopicSDTO;
import com.app.FO.dto.user.UserSDTO;
import com.app.FO.model.task.TaskNote;

import java.time.LocalDateTime;
import java.util.List;

public class NoteFDTO {

    private Long noteId;
    private String note;
    private List<TagSDTO> tags;
    private UserSDTO user;
    private LocalDateTime createdDateTime;
    private List<TopicSDTO> topicsThatContainTheNote;
    //todo adaug DTO
    private List<TaskNote> tasksThatContainTheNote;
    private List<NoteHistoryDTO> noteHistory;
    private List<RemainderSDTO> remainders;


    //todo adaug celelate elemente
    public NoteFDTO(Long noteId, String note, List<TagSDTO> tags, UserSDTO user,
                    LocalDateTime createdDateTime, List<TopicSDTO> topicsThatContainTheNote,
                    List<NoteHistoryDTO> noteHistory) {
        this.noteId = noteId;
        this.note = note;
        this.tags = tags;
        this.user = user;
        this.createdDateTime = createdDateTime;
        this.topicsThatContainTheNote = topicsThatContainTheNote;
        this.noteHistory = noteHistory;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                ", user=" + user +
                ", createdDateTime=" + createdDateTime +
                ", topicsThatContainTheNote=" + topicsThatContainTheNote +
                ", noteHistory=" + noteHistory +
                ", remainders=" + remainders +
                '}';
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
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

    public List<NoteHistoryDTO> getNoteHistory() {
        return noteHistory;
    }

    public void setNoteHistory(List<NoteHistoryDTO> noteHistory) {
        this.noteHistory = noteHistory;
    }

}
