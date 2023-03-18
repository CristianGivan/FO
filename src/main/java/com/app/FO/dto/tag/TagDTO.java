package com.app.FO.dto.tag;

import java.time.LocalDateTime;

public class TagDTO {
    private Long tagId;
    private String tag;
    private LocalDateTime createdDate;

    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    public TagDTO(Long tagId, String tag, LocalDateTime createdDate) {
        this.tagId = tagId;
        this.tag = tag;
        this.createdDate = createdDate;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
