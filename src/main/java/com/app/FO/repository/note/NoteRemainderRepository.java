package com.app.FO.repository.note;

import com.app.FO.model.note.NoteRemainder;
import com.app.FO.model.note.NoteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRemainderRepository extends JpaRepository<NoteRemainder,Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM note_remainder as nr where nr.note_id=?1 and nr.remainder_id=?2")
    public NoteRemainder getNoteRemainderByNoteIdAndRemainderId(Long noteId, Long remainderId);


}
