package com.app.FO.model.tasklist;

import com.app.FO.model.task.Task;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_list_histories" +
        "")
public class TaskListHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_lis_history_seq")
    @SequenceGenerator(name = "task_lis_history_seq",
            sequenceName = "task_lis_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_lis_history_id")
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "task_list_id")
    @JsonIgnore
    private TaskList taskList;
}
