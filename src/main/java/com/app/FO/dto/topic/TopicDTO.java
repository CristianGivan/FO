package com.app.FO.dto.topic;

import com.app.FO.dto.note.NoteSDTO;
import com.app.FO.dto.tag.TagSDTO;
import com.app.FO.dto.user.UserSDTO;

import java.time.LocalDateTime;
import java.util.List;

public class TopicDTO {
    private Long topicId;
    private String subject;
    private List<NoteSDTO> notes;
    private List<TagSDTO> tags;
    private UserSDTO user;
    private LocalDateTime createdDate;
    private List<HistoryTopicSDTO> topicHistory;

    public TopicDTO() {
    }

    @Override
    public String toString() {
        return "TopicDTO{" +
                "topicId=" + topicId +
                ", subject='" + subject + '\'' +
                ", notes=" + notes +
                ", tags=" + tags +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", topicHistory=" + topicHistory +
                '}';
    }

    public TopicDTO(Long topicId, String subject, List<NoteSDTO> notes, List<TagSDTO> tags,
                    UserSDTO user, LocalDateTime createdDate, List<HistoryTopicSDTO> topicHistory) {
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

    public List<NoteSDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteSDTO> notes) {
        this.notes = notes;
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
