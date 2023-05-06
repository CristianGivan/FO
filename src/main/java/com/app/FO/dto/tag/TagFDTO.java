package com.app.FO.dto.tag;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class TagFDTO {
    private Long tagId;
    private String tagText;

    private LocalDateTime createdDateTime;

    private UserDTO creator;

    private List<UserDTO> userDTOList;

    private List<NoteDTO> noteDTOList;
    private List<TopicDTO> topicDTOList;

    @Override
    public String toString() {
        return "TagFDTO{" +
                "tagId=" + tagId +
                ", tagName='" + tagText + '\'' +
                ", createdDate=" + createdDateTime +
                ", creator=" + creator.getUserId() +
                ", userDTOList=" + userDTOList +
                ", noteDTOList=" + noteDTOList +
                ", topicDTOList=" + topicDTOList +
                '}';
    }


    public TagFDTO(Long tagId, String tagText, LocalDateTime createdDateTime, UserDTO creator,
                   List<UserDTO> userDTOList, List<NoteDTO> noteDTOList, List<TopicDTO> topicDTOList) {
        this.tagId = tagId;
        this.tagText = tagText;
        this.createdDateTime = createdDateTime;
        this.creator = creator;
        this.userDTOList = userDTOList;
        this.noteDTOList = noteDTOList;
        this.topicDTOList = topicDTOList;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTagText() {
        return tagText;
    }

    public void setTagText(String tagText) {
        this.tagText = tagText;
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

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public List<UserDTO> getUserDTOList() {
        return userDTOList;
    }

    public void setUserDTOList(List<UserDTO> userDTOList) {
        this.userDTOList = userDTOList;
    }
}
