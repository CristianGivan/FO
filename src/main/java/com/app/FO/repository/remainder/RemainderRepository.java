package com.app.FO.repository.remainder;

import com.app.FO.model.remainder.Remainder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RemainderRepository extends JpaRepository<Remainder, Long> {
    //-- Create



    //-- Read

    @Query(value = "SELECT * FROM  remainder as r where r.remainder_id=?1 and r.user_id=?2"
            ,nativeQuery = true)
    Remainder getRemainderFromUserByRemainderId(Long remainderId, Long userId);
    @Query(value = "SELECT * FROM  remainder as r where r.user_id=?1 and r.note_id=?2 and  r.remainder_id=?3"
            ,nativeQuery = true)
    Remainder getRemainderFromUserIdByNoteIdAndRemainderId(Long userId, Long noteId, Long remainderId);

    @Query(nativeQuery = true,value =
            "SELECT * FROM  remainder as r where r.user_id=?1")
    List<Remainder> getRemainderListByUserId(Long userId);

    @Query(nativeQuery = true,value =
            "SELECT * FROM  remainder as r where r.note_id=?1")
    List<Remainder> getRemainderListByNoteId(Long noteId);

    //-- Update



    //-- Delete



    //-- Check
    @Query(nativeQuery = true,value =
            "SELECT IF(EXISTS(SELECT * FROM  remainder as r where r.note_id=?1 and  r.remainder_id=?2), 'True', 'False')")
    Boolean isRemainderAtNote(Long NoteId, Long RemainderId);

    @Query(nativeQuery = true,value =
            "SELECT IF(EXISTS(SELECT * FROM  remainder as r where r.user_id=?1 and r.note_id=?2 and  r.remainder_id=?3), 'True', 'False')")
    Boolean isRemainderAtNoteAndUser(Long userId, Long NoteId, Long RemainderId);
}
