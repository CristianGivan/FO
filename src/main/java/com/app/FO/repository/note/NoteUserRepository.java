package com.app.FO.repository.note;

import com.app.FO.model.note.NoteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteUserRepository extends JpaRepository<NoteUser, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM note_user as nu where nu.note_id=?1 and nu.user_id=?2")
    NoteUser getNoteUserByNoteIdAndUserId(Long noteId, Long userId);


}
