package com.app.FO.service.tag;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
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
        checksTag.checkIsTagWithTagText(user, tagText);
        Tag tag = new Tag(tagText, user);
        TagUser tagUser = new TagUser(tag, user);
        tag.getTagUserList().add(tagUser);
        return tagRepository.save(tag);
    }

    //-- Put

    public Tag putUserToTag(Long tagId, Long userId) {
        /*
         1. Find parameter1 by id (from log in user)
         2. Find parameter2 by id
         3. Check if there are not null else throw an exception)
         4. Check if parameter1 do not have has parameter2
         5. Crate an entry in linking table
         5. Add parameter2 in parameter1 list
         6. Save parameter1
         */
        Tag tag = getTagByTagId(tagId);
        User user = userService.findUserById(userId);
        checksTag.checkIsTagAndUserAndAreNotLinked(tag,user);
        TagUser tagUser = new TagUser(tag, user);
        tag.getTagUserList().add(tagUser);
        return tagRepository.save(tag);
    }

    //-- GET

    public Tag getTagByTagId(Long tagId) {
        Tag tag = tagRepository.getTagByUserIdAndTagId(userService.getLogInUser().getId(), tagId);
        checksTag.checkIsTag(tag);
        return tag;
    }

    public List<Tag> getTagListByUserId(Long userId) {
        List<Tag> tagList = tagRepository.getTagListByUserId(userId);
        return tagList;
    }

    public List<Tag> getTagListByContainingText(String containingText) {
        return tagRepository.getTagListByUserIdAndContainingTagText(userService.getLogInUser().getId(), containingText);
    }


    public List<Tag> getListOfTagByNoteId(Long noteId) {
        return tagRepository.getTagsByNoteId(userService.getLogInUser().getId(),noteId);
    }
    
    public List<Tag> getTagsByTopicId(Long topicId) {
        return tagRepository.getTagListByUserIdAndTopicId(userService.getLogInUser().getId(), topicId);
    }
    //--Delete


    //-- Other


    //-- GET




    //-- actual user


    public List<Tag> getTagsOfLogInUser() {
        return getTagListByUserId(userService.getLogInUser().getId());
    }

    public List<TagDTO> getTagsDTOOfLogInUser() {
        return tagDTOMapper.tagListToTagDTOList(getTagsOfLogInUser());
    }

    public Tag getTagByUserIdAndTagText(String tagName) {
        return tagRepository.getTagsByUserIdAndTagText(userService.getLogInUser().getId(), tagName);
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
