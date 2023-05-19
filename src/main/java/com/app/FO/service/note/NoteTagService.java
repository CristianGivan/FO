package com.app.FO.service.note;

import com.app.FO.exceptions.NoteTagNotFoundException;
import com.app.FO.model.note.NoteTag;
import com.app.FO.repository.note.NoteTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteTagService {
    private NoteTagRepository noteTagRepository;

    @Autowired
    public NoteTagService(NoteTagRepository noteTagRepository) {
        this.noteTagRepository = noteTagRepository;
    }

    public NoteTag findNteTagById(Long noteTagId) {
        return noteTagRepository.findById(noteTagId).orElseThrow(
                () -> new NoteTagNotFoundException("NoteTag note find"));
    }


    public NoteTag findNoteTagOfANoteIdByTagId(Long noteId, Long tagId) {
        return noteTagRepository.findNoteTagByNote_IdAndTag_Id(noteId, tagId);
    }

    public void deleteNoteTagById(Long noteId, Long tagId) {
        NoteTag noteTag = findNoteTagOfANoteIdByTagId(noteId, tagId);
        noteTagRepository.delete(noteTag);
    }
}
