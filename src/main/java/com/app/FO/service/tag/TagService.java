package com.app.FO.service.tag;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.tag.TagRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TagService {
    private TagRepository tagRepository;

    private ServiceAll serviceAll;

    @Autowired
    public TagService(TagRepository tagRepository, ServiceAll serviceAll) {
        this.tagRepository = tagRepository;
        this.serviceAll = serviceAll;
    }

    public TagService() {
    }


    //-- Post
    public Tag postTag(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Tag tag = tagRepository.getTagFromUserIdBySubject(logInUser.getId(), subject);
        if (tag != null) {
            throw new TagAlreadyExistException("Tag with this subject already exist");
        }

        tag = tagRepository.save(new Tag(subject, logInUser));

        TagUser tagUser = new TagUser(tag, logInUser);
        tag.getTagUserList().add(tagUser);

        return tagRepository.save(tag);
    }

    //-- Put


    public Tag putSubjectToTag(Long tagId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Tag tag = tagRepository.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found in your list");
        }

        if (tag.getSubject().equals(subject)) {
            throw new TagAlreadyExistException("Tag has already the same subject");
        }

        tag.setSubject(subject);

        return tagRepository.save(tag);
    }

    public Tag putUserToTag(Long tagId, Long userId) {
        User logInUser = serviceAll.getLogInUser();
        Tag tag = tagRepository.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TagUser tagUser = serviceAll.getTagUser(tagId, userId);
        if (tagUser != null) {
            throw new TagUserAlreadyExistException("The tag already has the user");
        }

        tagUser = new TagUser(tag, user);
        tag.getTagUserList().add(tagUser);

        return tagRepository.save(tag);
    }

    //--Delete

    public Tag deleteUserFromTag(Long tagId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Tag tag = tagRepository.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TagUser tagUser = serviceAll.getTagUser(tagId, userId);
        if (tagUser == null) {
            throw new TagUserNotFoundException("The tag don't has the user");
        }
        tag.getTagUserList().remove(tagUser);

        return tagRepository.save(tag);
    }

    public List<Tag> deleteTag(Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Tag tag = tagRepository.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found in your list");
        }
        tagRepository.delete(tag);
        return getAllTag();
    }

    //-- GET

    public List<Tag> getAllTag() {
        User logInUser = serviceAll.getLogInUser();
        List<Tag> tagList = tagRepository.getTagListFromUserId(logInUser.getId());
        if (tagList.isEmpty()) {
            throw new TagNotFoundException("No tag found");
        }
        return tagList;
    }

    public Tag getTagByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        Tag tag = tagRepository.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("No tag found");
        }
        return tag;
    }

    public Tag getTagBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Tag tag = tagRepository.getTagFromUserIdBySubject(logInUser.getId(), subject);
        if (tag == null) {
            throw new TagNotFoundException("No tag found");
        }
        return tag;
    }

    public List<Tag> getTagListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Tag> tagList = tagRepository.getTagListFromUserIdBySubjectContains(logInUser.getId(), subjectContains);
        if (tagList.isEmpty()) {
            throw new TagNotFoundException("No tag found");
        }
        return tagList;
    }

    public Tag getTagByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Tag tag = tagRepository.getTagFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (tag == null) {
            throw new TagNotFoundException("No tag found");
        }
        return tag;
    }

    public List<Tag> getTagListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Tag> tagList = tagRepository.getTagListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (tagList.isEmpty()) {
            throw new TagNotFoundException("No tag found");
        }
        return tagList;
    }


    public List<Tag> getTagListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tag> tagList = tagRepository.getTagListFromUserIdByUserId(logInUser.getId(), userId);
        if (tagList.isEmpty()) {
            throw new TagNotFoundException("No tag found");
        }
        return tagList;
    }


    //-- Other


}
