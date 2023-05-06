package com.app.FO.controller;

import com.app.FO.dto.general.TextDTO;
import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.tag.TagService;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    private TagService tagService;
    private TagDTOMapper tagDTOMapper;

    @Autowired
    private UserService userService;

    @Autowired
    public TagController(TagService tagService, TagDTOMapper tagDTOMapper) {
        this.tagService = tagService;
        this.tagDTOMapper=tagDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postTag")
    public TagFDTO addNewTag(@RequestBody TextDTO tagText) {
        Tag tag = tagService.postTag(tagText.getText());
        return tagDTOMapper.tagToTagFDTO(tag);
    }

    //-- GetMapping

    @GetMapping("/getTagById/{tagId}")
    public TagFDTO getTagById(@PathVariable Long tagId) {
        Tag tag = tagService.getTagByTagId(tagId);
        return tagDTOMapper.tagToTagFDTO(tag);
    }

    @GetMapping("/getTagByText/{tagText}")
    public TagDTO getTagByName(@PathVariable String tagText) {
        return tagService.getTagDTOByName(tagText);
    }


    @GetMapping("/getAllTags")
    public List<TagDTO> getAllTagsDTO() {
        List<Tag> tagList = tagService.getTagListByUserId(userService.getLogInUser().getId());
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagByNoteId/{noteId}")
    public List<TagDTO> getTagByNoteId(@PathVariable Long noteId) {
        List<Tag> tagList =tagService.getListOfTagByNoteId(noteId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagByTopicId/{topicId}")
    public List<TagDTO> getTagByTopicId(@PathVariable Long topicId) {
        List<Tag> tagList =tagService.getTagsByTopicId(topicId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
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



    //-- PutMapping



    //-- DeleteMapping
    //-- Converter

    //--- Other


}
