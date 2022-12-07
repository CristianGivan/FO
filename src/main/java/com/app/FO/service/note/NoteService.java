package com.app.FO.service.note;

import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.Tag;
import com.app.FO.model.note.Topic;
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
    public Note getNoteById(Long noteId){
        return noteRepository.findById(noteId)
                .orElseThrow(()->new NoteNotFoundException(" Note not found"));
    }
    public List<Note> getNotesByTag(Tag tag){
        return noteRepository.getNotesByTagId(tag.getId());
    }

    public List<Note> getNotesByTopic(Topic topic){
        return noteRepository.getNotesByTopicId(topic.getId());
    }


}
