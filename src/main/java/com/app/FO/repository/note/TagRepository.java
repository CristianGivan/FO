package com.app.FO.repository.note;

import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    List<Tag> findAll();
    Tag findTagByNoteTags(NoteTag noteTag);

    @Query("select t from Tag as t inner join NoteTag nt on t.id=nt.tag.id " +
            "where nt.note.id=?1")
    List<Tag> getTagsByNoteId(Long noteId);
}
