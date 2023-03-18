package com.app.FO.dto.tag;

import java.time.LocalDateTime;

public class TagDTO {
    private Long tagId;
    private String tag;


    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                '}';
    }

    public TagDTO(Long tagId, String tag) {
        this.tagId = tagId;
        this.tag = tag;
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

}
