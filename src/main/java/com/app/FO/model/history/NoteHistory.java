package com.app.FO.model.history;

import com.app.FO.model.note.Note;
import com.app.FO.model.note.Topic;
import com.app.FO.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_history")
public class NoteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_history_seq")
    @SequenceGenerator(name = "note_history_seq",
            sequenceName = "note_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_history_id")
    private Long id;

    @Column(name = "modifed_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;
// ToDO sa mai adaug celelte atribute care le vreau salvate in history sa vad daca nu pot sa las si asa si se salveaza automat
//    @Column(name = "note")
//    private NoteDTO noteOldVersion;

}
