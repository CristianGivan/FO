package com.app.FO.model.link;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link_tag")
public class LinkTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_tag_seq")
    @SequenceGenerator(name = "link_tag_seq",
            sequenceName = "link_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public LinkTag() {
    }

    public LinkTag(Link link, Tag tag) {
        this.link = link;
        this.tag = tag;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LinkTag{" +
                "id=" + id +
                ", linkId=" + link.getId() +
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
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
