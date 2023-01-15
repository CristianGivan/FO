package com.app.FO.dto.tag;

import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserTagDTO;

import java.util.List;

public class TagFDTO {
    private Long tagId;
    private String tagName;
    private List<UserTagDTO> userTags;
    private List<NoteDTO> notes;
    private List<TopicDTO> topics;

    @Override
    public String toString() {
        return "TagFDTO{" +
                "tagId=" + tagId +
                ", tagName='" + tagName + '\'' +
                ", usersTag=" + userTags +
                ", notes=" + notes +
                ", topics=" + topics +
                '}';
    }

    public TagFDTO(String tagName, List<UserTagDTO> usersTag, List<NoteDTO> notes,
                   List<TopicDTO> topics) {
        this.tagName = tagName;
        this.userTags = usersTag;
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

    public List<UserTagDTO> getUserTags() {
        return userTags;
    }

    public void setUserTags(List<UserTagDTO> userTags) {
        this.userTags = userTags;
    }


    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }

    public List<TopicDTO> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicDTO> topics) {
        this.topics = topics;
    }
}
