package com.app.FO.dto.tag;

import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;

public class TagDTO {
    private Long tagId;
    private String tagText;
    private LocalDateTime createdDateTime;
    private UserDTO creator;


    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", tagText='" + tagText + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", creator=" + creator.getUserId() +
                '}';
    }

    public TagDTO(Long tagId, String tagText, LocalDateTime createdDateTime, UserDTO creator) {
        this.tagId = tagId;
        this.tagText = tagText;
        this.createdDateTime = createdDateTime;
        this.creator=creator;
    }

    public UserDTO getCreator() {
        return creator;
    }

    public void setCreator(UserDTO creator) {
        this.creator = creator;
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

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }
}
