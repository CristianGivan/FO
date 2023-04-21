package com.app.FO.service.note;

import com.app.FO.model.note.NoteRemainder;
import com.app.FO.model.note.NoteUser;
import com.app.FO.repository.note.NoteRemainderRepository;
import com.app.FO.repository.note.NoteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteRemainderService {
    private NoteRemainderRepository noteRemainderRepository;

    @Autowired
    public NoteRemainderService(NoteRemainderRepository noteRemainderRepository) {
        this.noteRemainderRepository = noteRemainderRepository;
    }

    //-- Post


    //-- Put


    //-- GET

    public List<NoteRemainder> getAllNoteUser() {
        return noteRemainderRepository.findAll();
    }

    public NoteRemainder getNoteRemainderByNoteIdAndRemainderId(Long noteId, Long remainderId) {
        return noteRemainderRepository.getNoteRemainderByNoteIdAndRemainderId(noteId,remainderId);
    }


    //--Delete

    public void deleteNoteRemainderFormNoteIdByRemainderId(Long noteId, Long remainderId){
        NoteRemainder noteRemainder=getNoteRemainderByNoteIdAndRemainderId(noteId,remainderId);
        noteRemainderRepository.delete(noteRemainder);
    }

    //-- Other

}
