package com.app.FO.mapper.dto.note;

import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.mapper.dto.tag.TagDTO;
import com.app.FO.mapper.dto.topic.TopicDTO;
import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class NoteFDTO {

    private Long noteId;
    private String noteText;
    private LocalDateTime createdDateTime;
    private UserDTO creator;
    private List<UserDTO> userDTOList;
    private List<TagDTO> tagDTOList;
    private List<TopicDTO> topicDTOList;
    private List<ReminderDTO> reminderDTOList;
    private List<NoteHistoryDTO> noteHistoryDTOList;

    public NoteFDTO(Long noteId, String noteText, LocalDateTime createdDateTime, UserDTO creator, List<UserDTO> userDTOList, List<TagDTO> tagDTOList, List<TopicDTO> topicDTOList, List<ReminderDTO> reminderDTOList, List<NoteHistoryDTO> noteHistoryDTOList) {
        this.noteId = noteId;
        this.noteText = noteText;
        this.createdDateTime = createdDateTime;
        this.creator = creator;
        this.userDTOList = userDTOList;
        this.tagDTOList = tagDTOList;
        this.topicDTOList = topicDTOList;
        this.reminderDTOList = reminderDTOList;
        this.noteHistoryDTOList = noteHistoryDTOList;
    }

    @Override
    public String toString() {
        return "NoteFDTO{" +
                "noteId=" + noteId +
                ", noteText='" + noteText + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator.getUserId() +
                ", userDTOList=" + userDTOList +
                ", tagDTOList=" + tagDTOList +
                ", topicDTOList=" + topicDTOList +
                ", reminderDTOList=" + reminderDTOList +
                ", noteHistoryDTOList=" + noteHistoryDTOList +
                '}';
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteText() {
        return noteText;
    }

    public void setNoteText(String noteText) {
        this.noteText = noteText;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }

    public List<TagDTO> getTagDTOList() {
        return tagDTOList;
    }

    public void setTagDTOList(List<TagDTO> tagDTOList) {
        this.tagDTOList = tagDTOList;
    }

    public List<TopicDTO> getTopicDTOList() {
        return topicDTOList;
    }

    public void setTopicDTOList(List<TopicDTO> topicDTOList) {
        this.topicDTOList = topicDTOList;
    }

    public List<ReminderDTO> getReminderDTOList() {
        return reminderDTOList;
    }

    public void setReminderDTOList(List<ReminderDTO> reminderDTOList) {
        this.reminderDTOList = reminderDTOList;
    }

    public List<NoteHistoryDTO> getNoteHistoryDTOList() {
        return noteHistoryDTOList;
    }

    public void setNoteHistoryDTOList(List<NoteHistoryDTO> noteHistoryDTOList) {
        this.noteHistoryDTOList = noteHistoryDTOList;
    }
}
