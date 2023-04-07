package com.app.FO.model.note;

import com.app.FO.model.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "note_history")
@Getter
@Setter
@NoArgsConstructor
public class NoteHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "note_history_seq")
    @SequenceGenerator(name = "note_history_seq",
            sequenceName = "note_history_seq",
            initialValue = 1,
            allocationSize = 1)
    @Column(name = "note_history_id")
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    @ManyToOne
    @JoinColumn(name = "note_id")
    @JsonIgnore
    private Note note;

    @Column(name = "text")
    private String noteText;
// ToDO sa mai adaug celelte atribute care le vreau salvate in history sa vad daca nu pot sa las si asa si se salveaza automat
//  sa ma gandesc cum ar fi mai bine sa salvez tot ce este in note sau  sa salvez doar diferentele gen Git
//    @Column(name = "note")
//    private NoteDTO noteOldVersion;

    @Override
    public String toString() {
        return "NoteHistory{" +
                "id=" + id +
                ", modifiedDate=" + modifiedDate +
                ", userId=" + user.getId() +
                ", noteId=" + note.getId() +
                '}';
    }

    public NoteHistory(LocalDateTime modifiedDate, User user, Note note, String noteText) {
        this.modifiedDate = modifiedDate;
        this.user = user;
        this.note = note;
        this.noteText = noteText;
    }
}
