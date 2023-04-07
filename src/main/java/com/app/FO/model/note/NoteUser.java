package com.app.FO.model.note;

import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_user")
@Getter
@Setter
@NoArgsConstructor
public class NoteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_user_seq")
    @SequenceGenerator(name = "note_user_seq",
            sequenceName = "note_user_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_user_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @Column(name = "created_date")
    private LocalDateTime createdDate;

    public NoteUser(User user, Note note){
        this.user=user;
        this.note=note;
        this.createdDate=LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "TopicUser{" +
                "id=" + id +
                ", userId=" + user.getId() +
                ", noteId=" + note.getId() +
                ", createdDate=" + createdDate +
                '}';
    }
}