package com.app.FO.model.task;

import com.app.FO.model.note.Note;
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
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_history_seq")
    @SequenceGenerator(name = "task_history_seq",
            sequenceName = "task_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "task_history_id")
    @Setter(AccessLevel.NONE)
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

    //todo o sa adaug si celelate lucri care le veau in History

    public TaskHistory() {
    }

    @Override
    public String toString() {
        return "TaskHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", taskId=" + task.getId() +
                '}';
    }
}
