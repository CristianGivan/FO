package com.app.FO.model.tasks;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks_topic")
public class TasksTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_topic_seq")
    @SequenceGenerator(name = "tasks_topic_seq",
            sequenceName = "tasks_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TasksTopic() {
    }

    public TasksTopic(Tasks tasks, Topic topic) {
        this.tasks = tasks;
        this.topic = topic;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TasksTopic{" +
                "id=" + id +
                ", tasksId=" + tasks.getId() +
                ", topicId=" + topic.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
