package com.app.FO.model;

import com.app.FO.model.note.Note;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;

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

    @Column(name = "creted_date")
    private LocalDateTime createdDateTime;

    @Column(name = "data_time")
    private LocalDateTime remainderDateTime;

    @Column(name = "snooze_time")
    private LocalDateTime snoozeTime;

    @Column(name = "snoozed")
    private String snoozed;

    @OneToMany
    @JoinColumn(name = "remainder")
    private List<Remainder> repeatedReminders;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;



}
