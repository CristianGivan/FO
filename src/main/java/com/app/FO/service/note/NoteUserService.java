package com.app.FO.service.note;

import com.app.FO.exceptions.NoteTagNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.NoteTag;
import com.app.FO.model.note.NoteUser;
import com.app.FO.model.tag.Tag;
import com.app.FO.repository.note.NoteTagRepository;
import com.app.FO.repository.note.NoteUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteUserService {
    private NoteUserRepository noteUserRepository;

    @Autowired
    public NoteUserService(NoteUserRepository noteUserRepository) {
        this.noteUserRepository = noteUserRepository;
    }

    //-- Post


    //-- Put


    //-- GET

    public List<NoteUser> getAllNoteUser() {
        return noteUserRepository.findAll();
    }

    public NoteUser getNoteUserByNoteIdAndUserId(Long noteId, Long userId) {
        return noteUserRepository.getNoteUserByNoteIdAndUserId(noteId,userId);
    }


    //--Delete

    public void deleteNoteUserFormNoteIdByUserId(Long noteId, Long userId){
        NoteUser noteUser=getNoteUserByNoteIdAndUserId(noteId,userId);
        noteUserRepository.delete(noteUser);
    }

    //-- Other


/*

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
    }*/
}
