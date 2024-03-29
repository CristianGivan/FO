package com.app.FO.model.task;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_tag")
public class TaskTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_tag_seq")
    @SequenceGenerator(name = "task_tag_seq",
            sequenceName = "task_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskTag() {
    }

    public TaskTag(Task task, Tag tag) {
        this.task = task;
        this.tag = tag;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskTag{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
