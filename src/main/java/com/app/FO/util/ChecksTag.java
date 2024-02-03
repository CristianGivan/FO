package com.app.FO.util;

import com.app.FO.exceptions.TagAlreadyExistException;
import com.app.FO.exceptions.TagNotFoundException;
import com.app.FO.exceptions.UserAlreadyExistException;
import com.app.FO.exceptions.UserNotFoundException;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.user.User;
import com.app.FO.repository.tag.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChecksTag {
    private TagRepository tagRepository;
    private ServiceAll serviceAll;

    @Autowired
    public ChecksTag(TagRepository tagRepository, ServiceAll serviceAll) {
        this.tagRepository = tagRepository;
        this.serviceAll = serviceAll;

    }

    public void checkIsTag(Tag tag) {
        if (!serviceAll.isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        }
    }

    public void checkIsTagWithTagText(User user, String tagText) {
        Tag tag = tagRepository.getTagsByUserIdAndTagText(user.getId(), tagText);
        if (tag != null) {
            throw new TagAlreadyExistException("Tag already exist");
        }
    }

    public void checkIsTagAndUserAndAreLinked(Tag tag, User user) {
        if (!serviceAll.isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        } else if (!serviceAll.isUser(user)) {
            throw new UserNotFoundException("User not found");
        } else if (!serviceAll.tagHasUser(tag, user)) {
            throw new UserNotFoundException("User is not linked to tag");
        }
    }

    public void checkIsTagAndTheCreatorAndAreLinked(Tag tag, User user) {
        if (!serviceAll.isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        } else if (!serviceAll.isUser(user)) {
            throw new UserNotFoundException("User not found");
        } else if (!serviceAll.isUserTagCreator(user, tag)) {
            throw new UserNotFoundException("User not the creator");
        } else if (!serviceAll.tagHasUser(tag, user)) {
            throw new UserNotFoundException("User is not linked to tag");
        }
    }

    public void checkIsTagAndUserAndAreNotLinked(Tag tag, User user) {
        if (!serviceAll.isTag(tag)) {
            throw new TagNotFoundException("Tag not found!");
        } else if (!serviceAll.isUser(user)) {
            throw new UserNotFoundException("User not found");
        } else if (serviceAll.tagHasUser(tag, user)) {
            throw new UserAlreadyExistException("User is linked to tag");
        }
    }
}
