package com.app.FO.model.event;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_user")
@Getter
@Setter
@NoArgsConstructor
public class EventUser {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_user_seq")
    @SequenceGenerator(name = "event_user_seq",
            sequenceName = "event_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_user_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "EventUser{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", userId=" + user.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
