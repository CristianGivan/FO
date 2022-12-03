package com.app.FO.repository.note;

import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {

    public List<Tag> findAllByNoteTags(List<NoteTag> noteTags);
}
