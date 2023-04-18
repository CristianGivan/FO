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

    List<Note> getNotesByNoteContains(String containText);

    //-- get from user
    List<Note> getNotesByCreatorId(Long userId);
    Note getNoteByCreatorIdAndId(Long userId, Long noteId);

    List<Note> getNotesByCreatorIdAndNoteContains(Long userId, String containText);

    //todo td
/*    @Query(value = "SELECT * FROM note as n inner join note_tag as nt on n.note_id = nt.note_id where n.user_id=?1 and nt.tag_id=?2"//todo aici ceva nu ii bine trebuie sa fie user_note table
            ,nativeQuery = true)
    List<Note> getNotesFromUserIdByTagId(Long noteId, Long userId);*/
    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_tag as nt on n.note_id = nt.note_id inner join note_user nu on n.note_id = nu.note_id where n.user_id=?1 and nt.tag_id=?2")
    List<Note> getNotesFromUserIdByTagId(Long noteId, Long userId);

    @Query(value = "SELECT * FROM note as n inner join topic_note as nt on n.note_id = nt.note_id where n.user_id=?1 and nt.topic_id=?2"
            ,nativeQuery = true)
    List<Note> getNotesFromUserIdByTopicId(Long noteId, Long topicId);

    @Query(value = "SELECT IF(EXISTS(SELECT * FROM note_tag as nt where nt.note_id = ?1 and nt.tag_id = ?2), 'True', 'False')"
            ,nativeQuery = true)
    Boolean noteHasTag(Long noteId, Long tagId);
    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM topic_note as tn where tn.note_id = ?1 and tn.topic_id = ?2), 'True', 'False')")
    Boolean isTopicAtNote(Long noteId, Long topicId);
    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_remainder as nr where nr.note_id = ?1 and nr.remainder_id = ?2), 'True', 'False')")
    Boolean isRemainderAtNote(Long noteId, Long topicId);
    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_user as nu where nu.note_id = 3 and nu.user_id = 3), 'True', 'False')")
    Boolean isUserAtNote(Long noteId, Long topicId);

}
