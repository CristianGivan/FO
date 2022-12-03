package com.app.FO.model.note;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tag_seq")
    @SequenceGenerator(name = "tag_seq",
            sequenceName = "tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tag_id")
    private Long id;

    @Column(name = "tag")
    private String tagName;

    @OneToMany(mappedBy = "tag")
    private List<NoteTag> noteTags;
    @OneToMany(mappedBy = "tag")
    private List<TopicTag> topicTags;


    public Tag() {
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", noteTags=" + noteTags +
                ", topicTags=" + topicTags +
                ", tagName='" + tagName + '\'' +
                '}';
    }

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public Long getId() {
        return id;
    }

    public List<NoteTag> getNoteTags() {
        return noteTags;
    }

    public void setNoteTags(List<NoteTag> noteTags) {
        this.noteTags = noteTags;
    }

    public List<TopicTag> getTopicTags() {
        return topicTags;
    }

    public void setTopicTags(List<TopicTag> topicTags) {
        this.topicTags = topicTags;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
