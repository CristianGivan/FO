package com.app.FO.model.topic;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "topic_history")
@Getter
@Setter
@NoArgsConstructor
public class TopicHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_history_seq")
    @SequenceGenerator(name = "topic_history_seq",
            sequenceName = "topic_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "topic_history_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "modifed_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    @JsonIgnore
    private Topic topic;
// ToDO sa mai adaug celelte atribute care le vreau salvate in history sa vad daca nu pot sa las si asa si se salveaza automat
//    @Column(name = "note")
//    private NoteDTO noteOldVersion;

    @Override
    public String toString() {
        return "TopicHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", topicId=" + topic.getId() +
                '}';
    }
}
