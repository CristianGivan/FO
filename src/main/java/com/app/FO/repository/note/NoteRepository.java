package com.app.FO.repository.note;

import com.app.FO.model.note.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1")
    List<Note> getNoteListFromUserId(Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and tu.note_id=?2")
    Note getNoteFromUserIdByNoteId(Long userId, Long noteId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and t.subject=?2")
    Note getNoteFromUserIdBySubject(Long userId, String subject);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user ut on t.note_id = ut.note_id where ut.user_id=:userId and t.subject like %:containingText%")
    List<Note> getNoteListFromUserIdBySubjectContains(@Param("userId") Long UserId, @Param("containingText") String subjectText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and t.type=?2")
    Note getNoteFromUserIdByType(Long userId, String type);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user ut on t.note_id = ut.note_id where ut.user_id=:userId and t.type like %:containingText%")
    List<Note> getNoteListFromUserIdByTypeContains(@Param("userId") Long UserId, @Param("containingText") String typeText);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and t.created_date=?2")
    Note getNoteFromUserIdByCreatedDate(Long userId, LocalDateTime createdDate);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_user ut on t.note_id = ut.note_id where ut.user_id=?1 and t.created_date between ?2 and ?3")
    List<Note> getNoteListFromUserIdByCreatedDateBetween(Long UserId, LocalDateTime createdDateMin, LocalDateTime createdDateMax);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join (SELECT ti.note_id FROM (SELECT t.note_id FROM note as t inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1) as ti inner join note_user tu on ti.note_id = tu.note_id where tu.user_id=?2)as tr on tr.note_id=t.note_id")
    List<Note> getNoteListFromUserIdByUserId(Long logInUserId, Long userId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_tag as tt on t.note_id = tt.note_id inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and tt.tag_id=?2")
    List<Note> getNoteListFromUserIdByTagId(Long userId, Long tagId);

    @Query(nativeQuery = true, value =
            "SELECT * FROM note as t inner join note_reminder as tr on t.note_id = tr.note_id inner join note_user tu on t.note_id = tu.note_id where tu.user_id=?1 and tr.reminder_id=?2")
    List<Note> getNoteListFromUserIdByReminderId(Long userId, Long reminderId);

}
