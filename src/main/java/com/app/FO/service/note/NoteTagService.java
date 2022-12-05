package com.app.FO.service.note;

import com.app.FO.model.note.Tag;
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
}
