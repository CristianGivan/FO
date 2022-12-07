package com.app.FO.service.note;

import com.app.FO.dto.ConvertToDTO;
import com.app.FO.dto.note.TagDTO;
import com.app.FO.dto.note.TagSDTO;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.note.Tag;
import com.app.FO.model.note.Topic;
import com.app.FO.repository.note.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    //private ConvertToDTO convertToDTO;

    @Autowired
    public TagService(TagRepository tagRepository/*, ConvertToDTO convertToDTO*/) {
        this.tagRepository = tagRepository;
        //this.convertToDTO = convertToDTO;
    }

    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }


    public List<Tag> getListOfTagByNote(Note note){
        return tagRepository.getTagsByNoteId(note.getId());
    }

    public List<Tag> getTagsByTopic(Topic topic){
        return tagRepository.getTagsByTopicId(topic.getId());
    }
    public Tag getTagById(Long tagId){
        return tagRepository.findById(tagId).orElseThrow(
                ()->new TagNotFoundException("Tag not found"));
    }

}
