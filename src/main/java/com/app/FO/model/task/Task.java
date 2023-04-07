package com.app.FO.model.task;

import com.app.FO.model.remainder.Remainder;
import com.app.FO.model.tasks.TasksTask;
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
@Table(name = "task")
@Getter
@Setter
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_seq")
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_id")
    @Setter(AccessLevel.NONE)
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

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Remainder> remainderList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskEffort> taskEffortList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskTag> taskTagList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskNote> taskNoteList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TasksTask> tasksTaskList;

    @OneToMany(mappedBy = "task",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<TaskHistory> taskHistoryList;

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", userId=" + user.getId() +
                ", createdDate=" + createdDate +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", taskStatus=" + taskStatus +
                ", remainders=" + remainderList +
                ", taskEfforts=" + taskEffortList +
                ", noteTags=" + taskTagList +
                ", taskNotes=" + taskNoteList +
                ", tasksTasks=" + tasksTaskList +
                ", taskHistories=" + taskHistoryList +
                '}';
    }
}
