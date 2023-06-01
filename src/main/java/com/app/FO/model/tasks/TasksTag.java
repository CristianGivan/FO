package com.app.FO.model.tasks;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_tag")
public class TasksTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_tag_seq")
    @SequenceGenerator(name = "tasks_tag_seq",
            sequenceName = "tasks_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_tag_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TasksTag() {
    }

    public TasksTag(Tasks tasks, Tag tag) {
        this.tasks = tasks;
        this.tag = tag;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TasksTag{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
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

    public Tasks getTasks() {
        return tasks;
    }

    public void setTasks(Tasks tasks) {
        this.tasks = tasks;
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
