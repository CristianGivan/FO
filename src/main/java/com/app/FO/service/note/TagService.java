package com.app.FO.service.note;

import com.app.FO.model.note.Tag;
import com.app.FO.repository.note.TagRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public Tag saveTag(Tag tag){
        return tagRepository.save(tag);
    }
    public List<Tag> getAllTags(){
        return tagRepository.findAll();
    }
}
