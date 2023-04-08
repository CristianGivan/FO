package com.app.FO.dto.note;

import com.app.FO.dto.remainder.RemainderDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class NoteFDTO {

    private Long noteId;
    private String note;
    private LocalDateTime createdDateTime;
    private UserDTO user;
    private List<TagDTO> tagDTOList;
    private List<TopicDTO> topicsThatContainTheNote;
    private List<RemainderDTO> remainderDTOList;
    private List<NoteHistoryDTO> noteHistoryDTOList;
//    //todo adaug DTO
//    private List<TaskNote> tasksThatContainTheNote;

    public NoteFDTO(Long noteId, String note, LocalDateTime createdDateTime, UserDTO user, List<TagDTO> tags
            , List<TopicDTO> topicsThatContainTheNote, List<RemainderDTO> remainderDTOList, List<NoteHistoryDTO> noteHistoryDTOList
    ) {
        this.noteId = noteId;
        this.note = note;
        this.createdDateTime = createdDateTime;
        this.user = user;
        this.tagDTOList = tags;
        this.topicsThatContainTheNote = topicsThatContainTheNote;
        this.remainderDTOList = remainderDTOList;
        this.noteHistoryDTOList = noteHistoryDTOList;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", tags=" + tagDTOList +
                ", user=" + user +
                ", createdDateTime=" + createdDateTime +
                ", topicsThatContainTheNote=" + topicsThatContainTheNote +
                ", noteHistory=" + noteHistoryDTOList +
//                ", remainders=" + remainders +
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

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<TopicDTO> getTopicsThatContainTheNote() {
        return topicsThatContainTheNote;
    }

    public void setTopicsThatContainTheNote(List<TopicDTO> topicsThatContainTheNote) {
        this.topicsThatContainTheNote = topicsThatContainTheNote;
    }

    public List<RemainderDTO> getRemainderDTOList() {
        return remainderDTOList;
    }

    public void setRemainderDTOList(List<RemainderDTO> remainderDTOList) {
        this.remainderDTOList = remainderDTOList;
    }

    public List<NoteHistoryDTO> getNoteHistoryDTOList() {
        return noteHistoryDTOList;
    }

    public void setNoteHistoryDTOList(List<NoteHistoryDTO> noteHistoryDTOList) {
        this.noteHistoryDTOList = noteHistoryDTOList;
    }

}
