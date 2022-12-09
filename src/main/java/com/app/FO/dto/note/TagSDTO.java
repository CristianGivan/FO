package com.app.FO.dto.note;

public class TagSDTO {
    private Long tagId;
    private String tag;

    @Override
    public String toString() {
        return "TagSDTO{" +
                "tagId=" + tagId +
                ", tag='" + tag + '\'' +
                '}';
    }

    public TagSDTO(Long tagId, String tagName) {
        this.tagId = tagId;
        this.tag = tagName;

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
