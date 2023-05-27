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

    @Override
    public String toString() {
        return "TasksTag{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
