package com.app.FO.model.event;

import com.app.FO.model.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_tags")
public class EventTags {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_tag_seq")
    @SequenceGenerator(name = "event_tag_seq",
            sequenceName = "event_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public EventTags() {
    }

    @Override
    public String toString() {
        return "EventTags{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
