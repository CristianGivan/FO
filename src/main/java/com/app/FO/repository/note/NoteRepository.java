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

    //Todo cum ar trebui sa fac sa imi iasa ca mai sus?
    //List<Note> getNotesByNoteTagsContainsTag(Long tegId);

    @Query("select n from Note as n inner join TopicNote tn on n.id=tn.note.id " +
            "where tn.topic.id=?1")
    List<Note> getNotesByTopicId(Long topicId);

    List<Note> getNotesByNoteContains(String containText);

    //-- get from user
    List<Note> getNotesByUserId(Long userId);
    Note getNoteByUserIdAndId(Long userId, Long noteId);

    List<Note> getNotesByUserIdAndNoteContains(Long userId,String containText);

    @Query(value = "SELECT * FROM notes as n inner join not_tag as nt on n.note_id = nt.note_id where n.user_id=?1 and nt.tag_id=?2"
            ,nativeQuery = true)
    List<Note> getNotesFromUserIdByTagId(Long userId, Long tagId);

    @Query(value = "SELECT * FROM notes as n inner join topic_note as nt on n.note_id = nt.note_id where n.user_id=?1 and nt.topic_id=?2"
            ,nativeQuery = true)
    List<Note> getNotesFromUserIdByTopicId(Long userId, Long tagId);

    @Query(value = "SELECT IF(EXISTS(SELECT * FROM note_tag as nt where nt.note_id = ?1 and nt.tag_id = ?2), 'True', 'False')"
            ,nativeQuery = true)
    Boolean noteHasTag(Long userId, Long tagId);



}
