package com.app.FO.model.task;

import com.app.FO.model.note.Note;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_history_seq")
    @SequenceGenerator(name = "task_history_seq",
            sequenceName = "task_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;
}
