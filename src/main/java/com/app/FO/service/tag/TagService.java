package com.app.FO.service.tag;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserTag;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.service.user.UserService;
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
    public TagService(TagRepository tagRepository, TagDTOMapper tagDTOMapper) {
        this.tagRepository = tagRepository;
        this.tagDTOMapper = tagDTOMapper;
    }

    public TagService() {
    }


    //-- GET


    public Tag getTagById(Long tagId) {
        return tagRepository.findById(tagId).orElseThrow(
                () -> new TagNotFoundException("Tag not found"));
    }

    public TagDTO getTagDTOById(Long tagId) {
        return tagDTOMapper.tagToTagDTO(getTagById(tagId));
    }

    public Tag getTagByName(String tagName) {
        return tagRepository.findTagByTagName(tagName);
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

    public List<Tag> getTagsByUserId(Long userId) {
        return tagRepository.getTagsByUserId(userId);
    }


    public Tag getTagByTagIdFromUser(Long tagId) {
        return tagRepository.getTagByUserIdAndTagId(userService.getLogInUser().getId(),tagId);
    }


    public List<Tag> getTagsOfLogInUser() {
        return getTagsByUserId(userService.getLogInUser().getId());
    }

    public List<TagDTO> getTagsDTOOfLogInUser() {
        return tagDTOMapper.tagListToTagDTOList(getTagsOfLogInUser());
    }

    public Tag getTagByUserIdAndTagName(Long id, String tagName) {
        return tagRepository.getTagsByUserIdAndTagName(id, tagName);
    }

    public TagDTO getTagDTOByUserIdAndTagName(Long userId, String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagByUserIdAndTagName(userId, tagName));
    }

    public Tag getTagOfLogInUserByTagName(String tagName) {
        return tagRepository.getTagsByUserIdAndTagName(userService.getLogInUser().getId(), tagName);
    }

    public TagDTO getTagDTOOfLogInUserByTagName(String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagOfLogInUserByTagName(tagName));
    }


    //-- Set


    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag saveTagFromText(String tagText) {
        User logInUser = userService.getLogInUser();
        Tag newTag = getTagOfLogInUserByTagName(tagText);
        if (newTag != null) {
            throw new TagAlreadyExistException("Tag already exist");
        }

        // todo chiar trebuie sa fortez salvarea tagului si dupa aia salvarea usertagului sau se poate face si alt fel,decamdata merge.
        newTag = tagRepository.save(new Tag(tagText));
        UserTag userTag = tagUserService.saveUserTag(new UserTag(logInUser, newTag));
        logInUser.getUserTagList().add(userTag);
        newTag.getUserTagList().add(userTag);
        return tagRepository.save(newTag);
    }

    public TagDTO saveTagDTOFromText(String tagText) {
        return tagDTOMapper.tagToTagDTO(saveTagFromText(tagText));
    }

    public TagFDTO saveTagFDTOFromText(String tagText) {
        return tagDTOMapper.tagToTagFDTO(saveTagFromText(tagText));
    }

    //-- Other


}
