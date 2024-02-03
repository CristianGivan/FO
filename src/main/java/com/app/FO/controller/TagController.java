package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.tag.TagDTO;
import com.app.FO.mapper.mappers.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.service.tag.TagService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {
    private TagService tagService;
    private TagDTOMapper tagDTOMapper;

    @Autowired
    public TagController(TagService tagService, TagDTOMapper tagDTOMapper) {
        this.tagService = tagService;
        this.tagDTOMapper = tagDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postTag")
    public TagDTO postTag(@RequestBody TextDTO tagText) {
        Tag tag = tagService.postTag(tagText.getText());
        return tagDTOMapper.tagToTagDTO(tag);
    }

    //-- PutMapping

    @PutMapping("/putSubjectToTag/")
    public TagDTO putSubjectToTag(@RequestParam Long tagId, @RequestParam String subject) {
        Tag tag = tagService.putSubjectToTag(tagId, subject);
        return tagDTOMapper.tagToTagDTO(tag);
    }

    @PutMapping("/putUserToTag/")
    public TagDTO putUserToTag(@RequestParam Long tagId, @RequestParam Long userId) {
        Tag tag = tagService.putUserToTag(tagId, userId);
        return tagDTOMapper.tagToTagDTO(tag);
    }


    //-- DeleteMapping

    @DeleteMapping("/deleteUserFromTag")
    public TagDTO deleteUserFromTag(@RequestParam Long tagId, @RequestParam Long userId) {
        Tag tag = tagService.deleteUserFromTag(tagId, userId);
        return tagDTOMapper.tagToTagDTO(tag);
    }

    @DeleteMapping("/deleteTag/")
    public List<Tag> deleteTag(@RequestParam Long tagId) {
        List<Tag> tagList = tagService.deleteTag(tagId);
        return tagList;
    }

    //-- GetMapping


    @GetMapping("/getAllTag")
    public List<TagDTO> getAllTag() {
        List<Tag> tagList = tagService.getAllTag();
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagByTagId/")
    public TagDTO getTagByTagId(@RequestParam Long tagId) {
        Tag tag = tagService.getTagByTagId(tagId);
        return tagDTOMapper.tagToTagDTO(tag);
    }

    @GetMapping("/getTagBySubject/")
    public TagDTO getTagBySubject(@RequestParam String tagText) {
        Tag tagList = tagService.getTagBySubject(tagText);
        return tagDTOMapper.tagToTagDTO(tagList);
    }

    @GetMapping("/getTagListByContainingText/")
    public List<TagDTO> getTagListByContainingText(@RequestParam String containingText) {
        List<Tag> tagList = tagService.getTagListBySubjectContains(containingText);
        return tagDTOMapper.tagListToTagDTOList(tagList);

    }

    @GetMapping("/getTagByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public TagDTO getTagByCreatedDate(@RequestParam String createdDate) {
        Tag tag = tagService.getTagByCreatedDate(createdDate);
        return tagDTOMapper.tagToTagDTO(tag);
    }

    @GetMapping("/getTagListByCreatedDateBetween")
    public List<TagDTO> getTagListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Tag> tagList = tagService.getTagListByCreatedDateBetween(createdDateMin, createdDateMax);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    @GetMapping("/getTagListByUserId/")
    public List<TagDTO> getTagListByUserId(@RequestParam Long userId) {
        List<Tag> tagList = tagService.getTagListByUserId(userId);
        return tagDTOMapper.tagListToTagDTOList(tagList);
    }

    //--- Other


}
