package com.app.FO.dto.tag;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.topic.TopicSDTO;

import java.util.List;

public class TagDTO {
    private Long tagId;
    private String tagName;
    private List<NoteDTO> notes;
    private List<TopicSDTO> topics;

    @Override
    public String toString() {
        return "TagDTO{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", notes=" + notes +
                ", topics=" + topics +
                '}';
    }

    public TagDTO(Long tagId, String tagName, List<NoteDTO> notes, List<TopicSDTO> topics) {
        this.tagId = tagId;
        this.tagName = tagName;
        this.notes = notes;
        this.topics = topics;
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

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

    public List<TopicSDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicSDTO> topics) {
        this.topics = topics;
    }
}
