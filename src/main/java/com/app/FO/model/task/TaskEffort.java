package com.app.FO.model.task;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

//effort
@Entity
@Table(name = "task_effort")
@Getter
@Setter
@NoArgsConstructor
public class TaskEffort {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_effort_seq")
    @SequenceGenerator(name = "task_effort_seq",
            sequenceName = "task_effort_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_effort_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "working_date_time")
    private LocalDate workingDate;

    //todo time or double what should be?
    @Column(name = "woking_time")
    private Double workingTime;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "task_id")
    @JsonIgnore
    private Task task;

    @Override
    public String toString() {
        return "TaskEffort{" +
                "id=" + id +
                ", workingDate=" + workingDate +
                ", workingTime=" + workingTime +
                ", taskId=" + task.getId() +
                '}';
    }
}
