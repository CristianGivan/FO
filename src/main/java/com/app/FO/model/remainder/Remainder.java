package com.app.FO.model.remainder;

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
@Table(name = "remainders")
public class Remainder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "remainder_seq")
    @SequenceGenerator(name = "remainder_seq",
            sequenceName = "remainder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "remainder_id")
    private Long id;

    @Column(name = "remainder")
    private String remainder;

    @Column(name = "created_date")
    private LocalDateTime createdDateTime;

    @Column(name = "data_time")
    private LocalDateTime remainderDateTime;

    //is a table mostly for statistics
    @OneToMany(mappedBy = "remainder", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Snooze> snoozes;

    //todo ar putea fi un tabel de legatura?
    @OneToMany
    @JoinColumn(name = "remainders")
    private List<Remainder> repeatedReminders;

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
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    public Remainder() {
    }

    @Override
    public String toString() {
        return "Remainder{" +
                "id=" + id +
                ", remainder='" + remainder + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", remainderDateTime=" + remainderDateTime +
                ", snoozed='" + snoozes + '\'' +
                ", repeatedReminders=" + repeatedReminders +
                ", noteId=" + note.getId() +
                ", taskId=" + task.getId() +
                ", topicId=" + topic.getId() +
                ", userId=" + user.getId() +
                ", eventId=" + event.getId() +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getRemainderDateTime() {
        return remainderDateTime;
    }

    public void setRemainderDateTime(LocalDateTime remainderDateTime) {
        this.remainderDateTime = remainderDateTime;
    }

    public List<Snooze> getSnoozes() {
        return snoozes;
    }

    public void setSnoozes(List<Snooze> snoozes) {
        this.snoozes = snoozes;
    }

    public List<Remainder> getRepeatedReminders() {
        return repeatedReminders;
    }

    public void setRepeatedReminders(List<Remainder> repeatedReminders) {
        this.repeatedReminders = repeatedReminders;
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
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
