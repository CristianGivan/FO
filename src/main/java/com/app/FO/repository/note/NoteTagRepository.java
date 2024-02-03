package com.app.FO.repository.note;

import com.app.FO.model.note.NoteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTagRepository extends JpaRepository<NoteTag, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM note_tag as tt where tt.note_id=?1 and tt.tag_id=?2")
    NoteTag getNoteTagByNoteIdAndTagId(Long noteId, Long tagId);


}
