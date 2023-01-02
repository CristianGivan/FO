package com.app.FO.dto.note;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class NoteFDTO {

    private Long noteId;
    private String note;
    private LocalDateTime createdDateTime;
    private UserDTO user;
    private List<TagDTO> tags;
//    private List<TopicDTO> topicsThatContainTheNote;
//    //todo adaug DTO
//    private List<TaskNote> tasksThatContainTheNote;
//    private List<NoteHistoryDTO> noteHistory;
//    private List<RemainderSDTO> remainders;


    //todo adaug celelate elemente
    public NoteFDTO(Long noteId, String note, LocalDateTime createdDateTime, UserDTO user, List<TagDTO> tags
//                      ,List<TopicDTO> topicsThatContainTheNote, List<NoteHistoryDTO> noteHistory
                    ) {
        this.noteId = noteId;
        this.note = note;
        this.createdDateTime = createdDateTime;
        this.user = user;
        this.tags = tags;
//        this.topicsThatContainTheNote = topicsThatContainTheNote;
//        this.noteHistory = noteHistory;
    }

    @Override
    public String toString() {
        return "NoteDTO{" +
                "noteId=" + noteId +
                ", note='" + note + '\'' +
                ", tags=" + tags +
                ", user=" + user +
                ", createdDateTime=" + createdDateTime +
//                ", topicsThatContainTheNote=" + topicsThatContainTheNote +
//                ", noteHistory=" + noteHistory +
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

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
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

//    public List<TopicDTO> getTopicsThatContainTheNote() {
//        return topicsThatContainTheNote;
//    }
//
//    public void setTopicsThatContainTheNote(List<TopicDTO> topicsThatContainTheNote) {
//        this.topicsThatContainTheNote = topicsThatContainTheNote;
//    }
//
//    public List<NoteHistoryDTO> getNoteHistory() {
//        return noteHistory;
//    }
//
//    public void setNoteHistory(List<NoteHistoryDTO> noteHistory) {
//        this.noteHistory = noteHistory;
//    }

}
