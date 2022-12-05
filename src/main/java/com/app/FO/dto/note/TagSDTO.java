package com.app.FO.dto.note;

public class TagSDTO {
    private Long id;
    private String tagName;

    @Override
    public String toString() {
        return "TagSDTO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    public TagSDTO(Long id, String tagName) {
        this.id = id;
        this.tagName = tagName;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
