package com.app.FO.service.note;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.repository.note.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    private TagDTOMapper tagDTOMapper;

    @Autowired
    public TagService(TagRepository tagRepository, TagDTOMapper tagDTOMapper) {
        this.tagRepository = tagRepository;
        this.tagDTOMapper = tagDTOMapper;
    }

    public TagService() {
    }


    //-- GET


    public Tag getTagById(Long tagId){
        return tagRepository.findById(tagId).orElseThrow(
                ()->new TagNotFoundException("Tag not found"));
    }
    public TagDTO getTagDTOById(Long tagId){
        return tagDTOMapper.tagToTagDTO(getTagById(tagId));
    }

    public Tag getTagByName(String tagName){
        return tagRepository.findTagByTagName(tagName);
    }
    public TagDTO getTagDTOByName(String tagName){
        return tagDTOMapper.tagToTagDTO(getTagByName(tagName));
    }


    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
    public List<TagDTO> getAllTagsDTO(){
        return tagDTOMapper.tagsToTagsDTO(getAllTags());
    }

    public List<Tag> getListOfTagByNoteId(Long noteId){
        return tagRepository.getTagsByNoteId(noteId);
    }

    public List<TagDTO> getListOfTagsDTOByNoteId(Long noteId){
        return tagDTOMapper.tagsToTagsDTO(getListOfTagByNoteId(noteId));
    }
    public List<Tag> getTagsByTopicId(Long topicId){
        return tagRepository.getTagsByTopicId(topicId);
    }

    public List<TagDTO> getTagsDTOByTopicId(Long topicId){
        return tagDTOMapper.tagsToTagsDTO(getTagsByTopicId(topicId));
    }


    //-- Set


    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }
    public Tag saveTagFromText(String tagText){
        return tagRepository.save(new  Tag(tagText));
    }
    public TagDTO saveTagDTOFromText(String tagText){
        return tagDTOMapper.tagToTagDTO( saveTagFromText(tagText));
    }

    //-- Other














}
