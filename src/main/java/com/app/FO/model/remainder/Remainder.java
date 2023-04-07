package com.app.FO.model.remainder;

import com.app.FO.model.event.Event;
import com.app.FO.model.note.Note;
import com.app.FO.model.task.Task;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "remainders")
@Getter
@Setter
@NoArgsConstructor
public class Remainder {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "remainder_seq")
    @SequenceGenerator(name = "remainder_seq",
            sequenceName = "remainder_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "remainder_id")
    @Setter(AccessLevel.NONE)
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
}