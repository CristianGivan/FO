package com.app.FO.model.task;

import com.app.FO.model.topic.Topic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_topic")
public class TaskTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_topic_seq")
    @SequenceGenerator(name = "task_topic_seq",
            sequenceName = "task_topic_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_topic_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    public TaskTopic() {
    }

    public TaskTopic(Task task, Topic topic) {
        this.task = task;
        this.topic = topic;
        this.linkDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TaskTopic{" +
                "id=" + id +
                ", taskId=" + task.getId() +
                ", topicId=" + topic.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
