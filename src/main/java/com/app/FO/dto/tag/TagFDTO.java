package com.app.FO.dto.tag;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class TagFDTO {
    private Long tagId;
    private String tagName;

    private UserDTO user;

    private LocalDateTime createdDate;
    private List<NoteDTO> noteDTOList;
    private List<TopicDTO> topicDTOList;

    @Override
    public String toString() {
        return "TagFDTO{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", notes=" + noteDTOList +
                ", topics=" + topicDTOList +
                '}';
    }

    public TagFDTO(Long tagId, String tagName, UserDTO user, LocalDateTime createdDate,
                   List<NoteDTO> noteDTOList, List<TopicDTO> topicDTOList) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.user = user;
        this.createdDate = createdDate;
        this.noteDTOList = noteDTOList;
        this.topicDTOList = topicDTOList;
    }


    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<NoteDTO> getNoteDTOList() {
        return noteDTOList;
    }

    public void setNoteDTOList(List<NoteDTO> noteDTOList) {
        this.noteDTOList = noteDTOList;
    }

    public List<TopicDTO> getTopicDTOList() {
        return topicDTOList;
    }

    public void setTopicDTOList(List<TopicDTO> topicDTOList) {
        this.topicDTOList = topicDTOList;
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
}
