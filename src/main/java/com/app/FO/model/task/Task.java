package com.app.FO.model.task;

import com.app.FO.model.Remainder;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.tasklist.TaskListTask;
import com.app.FO.model.topic.TopicTag;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_id")
    private Long id;

    @Column(name = "task")
    private String task;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column (name = "task_status")
    private TaskStatus taskStatus;

    @Column(name = "total_working_time")
    private double totalWorkingTime;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainders;

    //todo date and time when I worked and how much

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskEffort> taskEfforts;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskTag> noteTags;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskNote> taskNotes;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskListTask> taskListTasks;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskHistory> taskHistories;
}
