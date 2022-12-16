package com.app.FO.model.tasklist;

import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "task_lists")
public class TaskList {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_lists_seq")
    @SequenceGenerator(name = "task_lists_seq",
            sequenceName = "task_lists_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_lists_id")
    private Long id;




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

    @OneToMany(mappedBy = "taskList",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskListTask> taskListTasks;

    @OneToMany(mappedBy = "taskList",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskListHistory> TaskListHistory;
}
