package com.app.FO.model.reminder;

import com.app.FO.model.event.Event;
import com.app.FO.model.note.Note;
import com.app.FO.model.task.Task;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reminder")
public class Reminder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reminder_seq")
    @SequenceGenerator(name = "reminder_seq",
            sequenceName = "reminder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "reminder_id")
    private Long id;

    @Column(name = "reminder")
    private String reminder;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "data_time")
    private LocalDateTime reminderDateTime;

    //is a table mostly for statistics
    @OneToMany(mappedBy = "reminder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Snooze> snoozes;

    //todo ar putea fi un tabel de legatura?
    @OneToMany
    @JoinColumn(name = "repeated_reminders")
    private List<Reminder> repeatedReminderList;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User creator;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;



    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    public Reminder() {
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "id=" + id +
                ", remainder='" + reminder + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", remainderDateTime=" + reminderDateTime +
                ", snoozes=" + snoozes +
                ", repeatedReminders=" + repeatedReminderList +
                ", creatorId=" + creator.getId() +
                ", noteId=" + note.getId() +
                ", taskId=" + task.getId() +
                ", topicId=" + topic.getId() +
                ", eventId=" + event.getId() +
                '}';
    }

    public Reminder(String reminder, User creator) {
        this.reminder = reminder;
        this.createdDateTime = LocalDateTime.now();
        this.creator=creator;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String remainder) {
        this.reminder = remainder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime remainderDateTime) {
        this.reminderDateTime = remainderDateTime;
    }

    public List<Snooze> getSnoozes() {
        return snoozes;
    }

    public void setSnoozes(List<Snooze> snoozes) {
        this.snoozes = snoozes;
    }

    public List<Reminder> getRepeatedReminderList() {
        return repeatedReminderList;
    }

    public void setRepeatedReminderList(List<Reminder> repeatedReminders) {
        this.repeatedReminderList = repeatedReminders;
    }

    public Note getNote() {
        return note;
    }

    public void setNote(Note note) {
        this.note = note;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public User getUser() {
        return creator;
    }

    public void setUser(User user) {
        this.creator = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}