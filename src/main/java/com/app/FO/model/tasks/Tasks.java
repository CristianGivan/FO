package com.app.FO.model.tasks;

import com.app.FO.model.event.EventTasks;
import com.app.FO.model.task.TaskStatus;
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
@Table(name = "tasks")
@Getter
@Setter
@NoArgsConstructor
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_seq")
    @SequenceGenerator(name = "tasks_seq",
            sequenceName = "tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name")
    private String taskListName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "task_status")
    private TaskStatus tasksStatuList;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<TasksHistory> tasksHistoryList;

    @OneToMany(mappedBy = "tasks", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<EventTasks> eventTasksList;

    @Override
    public String toString() {
        return "Tasks{" +
                "id=" + id +
                ", taskListName='" + taskListName + '\'' +
                ", user=" + user +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + tasksStatuList +
                ", tasksTasks=" + tasksTaskList +
                ", TasksHistory=" + tasksHistoryList +
                ", eventTaskLists=" + eventTasksList +
                '}';
    }
}
