package com.app.FO.repository.note;

import com.app.FO.model.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    //-- get
    List<Note> getNotesByCreatorIdAndNoteTextContains(Long userId, String containText);




    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_user nu on n.note_id = nu.note_id where nu.user_id=?1")
    List<Note> getNoteListByUserId(Long userId);


    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_user nu on n.note_id = nu.note_id where nu.note_id=?1 and nu.user_id=?2")
    Note getNoteByIdAndUserId(Long noteId, Long userId);

    //todo td
/*    @Query(value = "SELECT * FROM note as n inner join note_tag as nt on n.note_id = nt.note_id where n.user_id=?1 and nt.tag_id=?2"//todo aici ceva nu ii bine trebuie sa fie user_note table
            ,nativeQuery = true)
    List<Note> getNotesFromUserIdByTagId(Long noteId, Long userId);*/
    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_tag as nt on n.note_id = nt.note_id inner join note_user nu on n.note_id = nu.note_id where nu.user_id=?1 and nt.tag_id=?2")
    List<Note> getNotesFromUserIdByTagId(Long userId, Long tagId);

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
    Boolean isRemainderAtNote(Long noteId, Long remainderId);
    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_user as nu where nu.note_id = ?1 and nu.user_id = ?2), 'True', 'False')")
    Boolean isUserAtNote(Long noteId, Long userId);

}
