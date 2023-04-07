package com.app.FO.model.tasks;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task_history")
@Getter
@Setter
@NoArgsConstructor
public class TasksHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tasks_history_seq")
    @SequenceGenerator(name = "tasks_history_seq",
            sequenceName = "tasks_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "tasks_history_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    public TasksHistory() {
    }

    @Override
    public String toString() {
        return "TasksHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskListId=" + tasks.getId() +
                '}';
    }
}
