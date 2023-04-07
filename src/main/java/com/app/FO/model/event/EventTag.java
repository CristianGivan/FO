package com.app.FO.model.event;

import com.app.FO.model.tag.Tag;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_tag")
@Getter
@Setter
@NoArgsConstructor
public class EventTag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "event_tag_seq")
    @SequenceGenerator(name = "event_tag_seq",
            sequenceName = "event_tag_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "event_tag_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonIgnore
    private Event event;

    @ManyToOne
    @JoinColumn(name = "tag_id")
    @JsonIgnore
    private Tag tag;

    @Column(name = "link_date")
    private LocalDateTime linkDate;

    @Override
    public String toString() {
        return "EventTag{" +
                "id=" + id +
                ", eventId=" + event.getId() +
                ", tagId=" + tag.getId() +
                ", linkDate=" + linkDate +
                '}';
    }
}
