package com.app.FO.model.topic;

import com.app.FO.model.reminder.Reminder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_reminder")
public class TopicReminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_reminder_seq")
    @SequenceGenerator(name = "topic_reminder_seq",
            sequenceName = "topic_reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_reminder_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "reminder_id")
    @JsonIgnore
    private Reminder reminder;

    @Column(name = "created_date")
    private LocalDateTime createdDate;


    public TopicReminder() {
    }

    public TopicReminder(Topic topic, Reminder reminder) {
        this.topic = topic;
        this.reminder = reminder;
        this.createdDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "NoteReminder{" +
                "id=" + id +
                ", topicId=" + topic.getId() +
                ", reminderId=" + reminder.getId() +
                ", createdDate=" + createdDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public Topic getNote() {
        return topic;
    }

    public void setNote(Topic topic) {
        this.topic = topic;
    }

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
