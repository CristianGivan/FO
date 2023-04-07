package com.app.FO.model.event;

import com.app.FO.model.remainder.Remainder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "event")
@Getter
@Setter
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_seq")
    @SequenceGenerator(name = "event_seq",
            sequenceName = "event_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "event")
    private List<EventTag> tagList;

    @OneToMany(mappedBy = "event")
    private List<EventUser> userList;

    @OneToMany(mappedBy = "event")
    private List<EventTopic> topicList;

    @OneToMany(mappedBy = "event")
    private List<EventTasks> taskList;

    @OneToMany(mappedBy = "event")
    private List<EventExpense> expenseList;

    @OneToMany(mappedBy = "event")
    private List<Remainder> remainderList;

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", tags=" + tagList +
                ", users=" + userList +
                ", topics=" + topicList +
                ", taskLists=" + taskList +
                ", expenses=" + expenseList +
                ", remainders=" + remainderList +
                '}';
    }
}
