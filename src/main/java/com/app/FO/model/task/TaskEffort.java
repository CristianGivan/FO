package com.app.FO.model.task;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

//effort
@Entity
@Table(name = "task_effort")
public class TaskEffort {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_effort_seq")
    @SequenceGenerator(name = "task_effort_seq",
            sequenceName = "task_effort_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_effort_id")
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

}
