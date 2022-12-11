package com.app.FO.repository.note;

import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteTagRepository extends JpaRepository<NoteTag,Long> {

    NoteTag findNoteTagByTag_Id(Long tagId);
    NoteTag findNoteTagByNote_IdAndTag_Id(Long noteId, Long tagId);

}
