package com.app.FO.service.note;

import com.app.FO.dto.ConvertToDTO;
import com.app.FO.dto.note.NoteFDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.repository.note.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    @Autowired
    private ConvertToDTO convertToDTO;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }
    public List<NoteFDTO> getAllNotes(){
        return convertToDTO.convertListOfNoteToListOfShowNoteDTO(noteRepository.findAll());
    }
    public NoteFDTO getNoteById(Long noteId){
        return convertToDTO.convertNoteToShowNoteDTO(noteRepository.findById(noteId)
                .orElseThrow(()->new NoteNotFoundException(" Note not found")));
    }



}
