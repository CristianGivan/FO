package com.app.FO.service.tag;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.util.ChecksTag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;
    private TagDTOMapper tagDTOMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private TagUserService tagUserService;

    @Autowired
    private ChecksTag checksTag;
    @Autowired
    public TagService(TagRepository tagRepository, TagDTOMapper tagDTOMapper) {
        this.tagRepository = tagRepository;
        this.tagDTOMapper = tagDTOMapper;
    }

    public TagService() {
    }


    //-- Post

    public Tag postTag(String tagText) {
        User user = userService.getLogInUser();
        checksTag.checkIsTagWithTagText(user,tagText);
        Tag tag = new Tag(tagText,user);
        TagUser tagUser = new TagUser(user, tag);
        tag.getUserTagList().add(tagUser);
        return tagRepository.save(tag);
    }

    //-- Put



    //-- GET

    public Tag getTagByTagId(Long tagId) {
        Tag tag =tagRepository.getTagByUserIdAndTagId(userService.getLogInUser().getId(),tagId);
        checksTag.checkIsTag(tag);
        return tag;
    }
    public List<Tag> getTagListByUserId(Long userId) {
        List<Tag> tagList = tagRepository.getTagListByUserId(userId);
        return tagList;
    }


    //--Delete



    //-- Other



    //-- GET


    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId).orElseThrow(
                () -> new TagNotFoundException("Tag not found"));
    }


    public Tag getTagByName(String tagName) {
        return tagRepository.findTagByTagText(tagName);
    }

    public TagDTO getTagDTOByName(String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagByName(tagName));
    }


    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }


    public List<Tag> getListOfTagByNoteId(Long noteId) {
        return tagRepository.getTagsByNoteId(noteId);
    }

    public List<Tag> getTagsByTopicId(Long topicId) {
        return tagRepository.getTagsByTopicId(topicId);
    }


    //-- actual user







    public List<Tag> getTagsOfLogInUser() {
        return getTagListByUserId(userService.getLogInUser().getId());
    }

    public List<TagDTO> getTagsDTOOfLogInUser() {
        return tagDTOMapper.tagListToTagDTOList(getTagsOfLogInUser());
    }

    public Tag getTagByUserIdAndTagName(Long id, String tagName) {
        return tagRepository.getTagsByUserIdAndTagText(id, tagName);
    }

    public TagDTO getTagDTOByUserIdAndTagName(Long userId, String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagByUserIdAndTagName(userId, tagName));
    }

    public Tag getTagOfLogInUserByTagName(String tagName) {
        return tagRepository.getTagsByUserIdAndTagText(userService.getLogInUser().getId(), tagName);
    }

    public TagDTO getTagDTOOfLogInUserByTagName(String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagOfLogInUserByTagName(tagName));
    }


    //-- Set


    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }



    public TagDTO saveTagDTOFromText(String tagText) {
        return tagDTOMapper.tagToTagDTO(postTag(tagText));
    }

    public TagFDTO saveTagFDTOFromText(String tagText) {
        return tagDTOMapper.tagToTagFDTO(postTag(tagText));
    }

    //-- Other


}
