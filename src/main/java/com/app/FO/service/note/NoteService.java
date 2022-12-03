package com.app.FO.service.note;

import com.app.FO.dto.note.ShowNoteDTO;
import com.app.FO.model.note.Note;
import com.app.FO.repository.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

}
