package com.app.FO.model.event;

import com.app.FO.model.tasks.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_tasks")
@Getter
@Setter
@NoArgsConstructor
public class EventTasks {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_tasks_seq")
    @SequenceGenerator(name = "event_tasks_seq",
            sequenceName = "event_tasks_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_tasks_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tasks_id")
    @JsonIgnore
    private Tasks tasks;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "EventTasks{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", tasksId=" + tasks.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
