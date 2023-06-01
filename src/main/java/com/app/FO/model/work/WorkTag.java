package com.app.FO.model.work;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "work_tag")
public class WorkTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "work_tag_seq")
    @SequenceGenerator(name = "work_tag_seq",
            sequenceName = "work_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "work_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "work_id")
    @JsonIgnore
    private Work work;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public WorkTag() {
    }

    public WorkTag(Work work, Tag tag) {
        this.work = work;
        this.tag = tag;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "WorkTag{" +
                "id=" + id +
                ", workId=" + work.getId() +
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

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
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
