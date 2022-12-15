package com.app.FO.repository.note;

import com.app.FO.model.note.NoteTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTagRepository extends JpaRepository<NoteTag,Long> {

    NoteTag findNoteTagByTag_Id(Long tagId);
    NoteTag findNoteTagByNote_IdAndTag_Id(Long noteId, Long tagId);

}
