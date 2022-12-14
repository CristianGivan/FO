package com.app.FO.service.note;

import com.app.FO.dto.tag.TagDTO;
import com.app.FO.dto.tag.TagFDTO;
import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.mapper.TagDTOMapper;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UserTag;
import com.app.FO.repository.note.TagRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.service.user.UserTagService;
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
    private UserTagService userTagService;

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

    public List<TagDTO> getAllTagsDTO() {
        return tagDTOMapper.tagsToTagsDTO(getAllTags());
    }

    public List<Tag> getListOfTagByNoteId(Long noteId) {
        return tagRepository.getTagsByNoteId(noteId);
    }

    public List<TagDTO> getListOfTagsDTOByNoteId(Long noteId) {
        return tagDTOMapper.tagsToTagsDTO(getListOfTagByNoteId(noteId));
    }

    public List<Tag> getTagsByTopicId(Long topicId) {
        return tagRepository.getTagsByTopicId(topicId);
    }

    public List<TagDTO> getTagsDTOByTopicId(Long topicId) {
        return tagDTOMapper.tagsToTagsDTO(getTagsByTopicId(topicId));
    }

    public List<Tag> getTagsByUserId(Long userId) {
        return tagRepository.getTagsByUserId(userId);
    }

    public List<TagDTO> getTagsDTOByUserId(Long userId) {
        return tagDTOMapper.tagsToTagsDTO(getTagsByUserId(userId));
    }

    public List<Tag> getTagsOfLogInUser() {
        return getTagsByUserId(userService.getLogInUser().getId());
    }

    public List<TagDTO> getTagsDTOOfLogInUser() {
        return tagDTOMapper.tagsToTagsDTO(getTagsOfLogInUser());
    }

    public Tag getTagByUserIdAndTagName(Long id, String tagName) {
        return tagRepository.getTagsByUserIdAndTagName(id, tagName);
    }

    public TagDTO getTagDTOByUserIdAndTagName(Long id, String tagName) {
        return tagDTOMapper.tagToTagDTO(getTagByUserIdAndTagName(id, tagName));
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
        UserTag userTag = userTagService.saveUserTag(new UserTag(logInUser, newTag));
        logInUser.getUserTags().add(userTag);
        newTag.getUserTags().add(userTag);
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
