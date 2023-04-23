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

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_tag as nt on n.note_id = nt.note_id inner join note_user nu on n.note_id = nu.note_id where nu.user_id=?1 and nt.tag_id=?2")
    List<Note> getNotesFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join note_remainder as nr on n.note_id = nr.note_id inner join note_user nu on n.note_id = nu.note_id where nu.user_id=?1 and nr.remainder_id=?2")
    List<Note> getNotesFromUserIdByRemainderId(Long noteId, Long remainderId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as n inner join topic_note as tn on n.note_id = tn.note_id inner join note_user nu on n.note_id = nu.note_id where nu.user_id=?1 and tn.topic_id=?2")
    List<Note> getNotesFromUserIdByTopicId(Long noteId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_tag as nt where nt.note_id = ?1 and nt.tag_id = ?2), 'True', 'False')")
    Boolean NoteIdHasTagId(Long noteId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM topic_note as tn where tn.note_id = ?1 and tn.topic_id = ?2), 'True', 'False')")
    Boolean NoteIdHasTopicId(Long noteId, Long topicId);

    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_remainder as nr where nr.note_id = ?1 and nr.remainder_id = ?2), 'True', 'False')")
    Boolean NoteIdHasRemainderId(Long noteId, Long remainderId);

    @Query(nativeQuery = true, value =
            "SELECT IF(EXISTS(SELECT * FROM note_user as nu where nu.note_id = ?1 and nu.user_id = ?2), 'True', 'False')")
    Boolean NoteIdHasUserId(Long noteId, Long userId);

}
