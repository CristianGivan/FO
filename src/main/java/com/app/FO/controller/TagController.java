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
    public TagDTO putUserToTag(@RequestBody TextDTO tagText) {
        Tag tag = tagService.postTag(tagText.getText());
        return tagDTOMapper.tagToTagDTO(tag);
    }

    //-- PutMapping

    @PostMapping("/putUserToTag/")
    public TagDTO addNewTag(@RequestParam Long tagId, @RequestParam Long userId) {
        Tag tag = tagService.putUserToTag(tagId,userId);
        return tagDTOMapper.tagToTagDTO(tag);
    }


    //-- GetMapping

    @GetMapping("/getTagById/{tagId}")
    public TagDTO getTagById(@PathVariable Long tagId) {
        Tag tag = tagService.getTagByTagId(tagId);
        return tagDTOMapper.tagToTagDTO(tag);
    }
    @GetMapping("/returnTagById/{tagId}")
    public Tag returnTagById(@PathVariable Long tagId) {
        Tag tag = tagService.getTagByTagId(tagId);
        return tag;
    }

    @GetMapping("/getTagListByContainingText/{containingText}")
    public List<TagDTO> getTagListByContainingText(@PathVariable String containingText) {
        List<Tag> tagList = tagService.getTagListByContainingText(containingText);
        return tagDTOMapper.tagListToTagDTOList(tagList);

    }    @GetMapping("/getTagListByTagText/{tagText}")
    public TagDTO getTagListByTagText(@PathVariable String tagText) {
        Tag tagList = tagService.getTagByUserIdAndTagText(tagText);
        return tagDTOMapper.tagToTagDTO(tagList);
    }

    @GetMapping("/getAllTagList")
    public List<TagDTO> getAllTagList() {
        List<Tag> tagList = tagService.getTagListByUserId(userService.getLogInUser().getId());
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }
    @GetMapping("/getTagListByUserId/{userId}")
    public List<TagDTO> getTagListByUserId(@PathVariable Long userId) {
        List<Tag> tagList = tagService.getTagListByUserId(userId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagListByNoteId/{noteId}")
    public List<TagDTO> getTagListByNoteId(@PathVariable Long noteId) {
        List<Tag> tagList =tagService.getListOfTagByNoteId(noteId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagListByTopicId/{topicId}")
    public List<TagDTO> getTagListByTopicId(@PathVariable Long topicId) {
        List<Tag> tagList =tagService.getTagsByTopicId(topicId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }


    //-- DeleteMapping
    //-- Converter

    //--- Other


}
