package com.app.FO.service.note;

import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.NoteRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class NoteService {
    private NoteRepository noteRepository;
    @Autowired
    private UserService userService;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public Note saveNote(Note note){
        return noteRepository.save(note);
    }
    public Note saveNote(String note){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        User user = userService.getUserByUsername(userDetails.getUsername());
        return new Note(note,user, LocalDateTime.now());
    }
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }
    public Note getNoteById(Long noteId){
        return noteRepository.findById(noteId)
                .orElseThrow(()->new NoteNotFoundException(" Note not found"));
    }
    public List<Note> getNotesByTagId(Long tagId){
        return noteRepository.getNotesByTagId(tagId);
    }

    public List<Note> getNotesByTopicId(Long topicId){
        return noteRepository.getNotesByTopicId(topicId);
    }

}
