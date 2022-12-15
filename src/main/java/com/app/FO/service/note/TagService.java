package com.app.FO.service.note;

import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.model.Tag;
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
    public Tag saveTagFromText(String tagTxt){
        return tagRepository.save(new  Tag(tagTxt));
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public List<Tag> getListOfTagByNoteId(Long noteId){
        return tagRepository.getTagsByNoteId(noteId);
    }

    public List<Tag> getTagsByTopicId(Long topicId){
        return tagRepository.getTagsByTopicId(topicId);
    }

    public Tag getTagById(Long tagId){
        return tagRepository.findById(tagId).orElseThrow(
                ()->new TagNotFoundException("Tag not found"));
    }

    public List<Tag> getTagsByName(String tagName){
        return tagRepository.findTagsByTagName(tagName);
    }


}
