package com.app.FO.service.note;

import com.app.FO.exceptions.NoteTagNotFoundException;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.Tag;
import com.app.FO.repository.note.NoteTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTagService {
    private NoteTagRepository noteTagRepository;

    @Autowired
    public NoteTagService(NoteTagRepository noteTagRepository) {
        this.noteTagRepository = noteTagRepository;
    }
    public List<Tag> findAllTags(){
        return null;
    }
    public NoteTag findNteTagById(Long noteTagId){
        return noteTagRepository.findById(noteTagId).orElseThrow(
                ()->new NoteTagNotFoundException("NoteTag note find"));
    }

    public NoteTag findNoteTagByTagId(Long tagId){
        return noteTagRepository.findNoteTagByTag_Id(tagId);
    }
    public NoteTag findNoteTagOfANoteIdByTagId(Long noteId, Long tagId){
        return noteTagRepository.findNoteTagByNote_IdAndTag_Id(noteId, tagId);
    }

    public void deleteNoteTagById(Long noteTagId){
        noteTagRepository.delete(findNteTagById(noteTagId));
    }
}
