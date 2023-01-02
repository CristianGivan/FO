package com.app.FO.dto.topic;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class TopicFDTO {
    private Long topicId;
    private String subject;
    private List<NoteDTO> notes;
    private List<TagDTO> tags;
    private UserDTO user;
    private LocalDateTime createdDate;
    private List<HistoryTopicSDTO> topicHistory;

    public TopicFDTO() {
    }

    @Override
    public String toString() {
        return "TopicFDTO{" +
                "topicId=" + topicId +
                ", subject='" + subject + '\'' +
                ", notes=" + notes +
                ", tags=" + tags +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistory +
                '}';
    }

    public TopicFDTO(Long topicId, String subject, List<NoteDTO> notes, List<TagDTO> tags,
                     UserDTO user, LocalDateTime createdDate, List<HistoryTopicSDTO> topicHistory) {
        this.topicId = topicId;
        this.subject = subject;
        this.notes = notes;
        this.tags = tags;
        this.user = user;
        this.createdDate = createdDate;
        this.topicHistory = topicHistory;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public List<HistoryTopicSDTO> getTopicHistory() {
        return topicHistory;
    }

    public void setTopicHistory(List<HistoryTopicSDTO> topicHistory) {
        this.topicHistory = topicHistory;
    }
}
