package com.app.FO.repository.note;

import com.app.FO.model.note.NoteReminder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteReminderRepository extends JpaRepository<NoteReminder, Long> {

    @Query(nativeQuery = true, value =
            "SELECT * FROM note_Reminder as nr where nr.note_id=?1 and nr.Reminder_id=?2")
    NoteReminder getNoteReminderByNoteIdAndReminderId(Long noteId, Long ReminderId);


}
