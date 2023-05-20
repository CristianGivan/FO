package com.app.FO.service.note;

import com.app.FO.model.note.NoteReminder;
import com.app.FO.repository.note.NoteReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteReminderService {
    private NoteReminderRepository noteReminderRepository;

    @Autowired
    public NoteReminderService(NoteReminderRepository noteReminderRepository) {
        this.noteReminderRepository = noteReminderRepository;
    }

    //-- Post


    //-- Put


    //-- GET

    public List<NoteReminder> getAllNoteUser() {
        return noteReminderRepository.findAll();
    }

    public NoteReminder getNoteReminderByNoteIdAndReminderId(Long noteId, Long reminderId) {
        return noteReminderRepository.getNoteReminderByNoteIdAndReminderId(noteId,reminderId);
    }


    //--Delete

    public void deleteNoteReminderFormNoteIdByReminderId(Long noteId, Long reminderId){
        NoteReminder noteReminder = getNoteReminderByNoteIdAndReminderId(noteId,reminderId);
        noteReminderRepository.delete(noteReminder);
    }

    //-- Other

}
