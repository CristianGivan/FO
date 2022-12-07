package com.app.FO.dto.note;

import java.util.List;

public class TagDTO {
    private Long id;
    private String tagName;
    private List<NoteSDTO> notes;
    private List<TopicSDTO> topics;

    @Override
    public String toString() {
        return "TagDTO{" +
                "id=" + id +
                ", tagName='" + tagName + '\'' +
                ", notes=" + notes +
                ", topics=" + topics +
                '}';
    }

    public TagDTO(Long id, String tagName, List<NoteSDTO> notes, List<TopicSDTO> topics) {
        this.id = id;
        this.tagName = tagName;
        this.notes = notes;
        this.topics = topics;
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

    public List<NoteSDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteSDTO> notes) {
        this.notes = notes;
    }

    public List<TopicSDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicSDTO> topics) {
        this.topics = topics;
    }
}
