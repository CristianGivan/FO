package com.app.FO.repository.note;

import com.app.FO.model.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Query("select n from Note as n inner join NoteTag nt on n.id=nt.note.id " +
            "where nt.tag.id=?1")
    List<Note> getNotesByTagId(Long tegId);

    @Query("select n from Note as n inner join TopicNote tn on n.id=tn.note.id " +
            "where tn.topic.id=?1")
    List<Note> getNotesByTopicId(Long topicId);

}
