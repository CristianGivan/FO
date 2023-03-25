package com.app.FO.controller.note;

import com.app.FO.dto.general.TextDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.note.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {
    private TagService tagService;
    private TagDTOMapper tagDTOMapper;

    @Autowired
    public TagController(TagService tagService, TagDTOMapper tagDTOMapper) {
        this.tagService = tagService;
        this.tagDTOMapper=tagDTOMapper;
    }

    //-- GetMapping

    @GetMapping("/getTagById/{tagId}")
    public TagFDTO getTagById(@PathVariable Long tagId) {
        Tag tag = tagService.getTagById(tagId);
        return tagDTOMapper.tagToTagFDTO(tag);
    }

    @GetMapping("/getTagByName/{tagName}")
    public TagDTO getTagByName(@PathVariable String tagName) {
        return tagService.getTagDTOByName(tagName);
    }


    @GetMapping("/getAllTags")
    public List<TagDTO> getAllTagsDTO() {
        return tagService.getAllTagsDTO();
    }

    @GetMapping("/getTagByNoteId/{noteId}")
    public List<TagDTO> getTagByNoteId(@PathVariable Long noteId) {
        return tagService.getListOfTagsDTOByNoteId(noteId);
    }

    @GetMapping("/getTagByTopicId/{topicId}")
    public List<TagDTO> getTagByTopicId(@PathVariable Long topicId) {
        return tagService.getTagsDTOByTopicId(topicId);
    }

    @GetMapping("/getTagOfLogInUser")
    public List<TagDTO> getTagOfLogInUser() {
        List<TagDTO> tagDTOs=tagService.getTagsDTOOfLogInUser();
        return tagDTOs;
    }

    @GetMapping("/getTagOfLogInUserByTagName")
    public TagDTO getTagOfLogInUserByTagName(@RequestBody TextDTO tagText) {
        return tagService.getTagDTOOfLogInUserByTagName(tagText.getText());
    }
    //-- PostMapping

    @PostMapping("/addNewTag")
    public TagFDTO addNewTag(@RequestBody TextDTO tagText) {
        return tagService.saveTagFDTOFromText(tagText.getText());
    }


    //-- PutMapping



    //-- DeleteMapping
    //-- Converter

    //--- Other


}
