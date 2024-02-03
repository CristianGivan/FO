package com.app.FO.model.link;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "link_tasks")
public class LinkTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "link_tasks_seq")
    @SequenceGenerator(name = "link_tasks_seq",
            sequenceName = "link_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "link_tasks_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "link_id")
    @JsonIgnore
    private Link link;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public LinkTasks() {
    }

    public LinkTasks(Link link, Tasks tasks) {
        this.link = link;
        this.tasks = tasks;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "LinkTaskss{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", link=" + link.getId() +
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

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public LocalDateTime getLinkDate() {
        return linkDate;
    }

    public void setLinkDate(LocalDateTime linkDate) {
        this.linkDate = linkDate;
    }
}
