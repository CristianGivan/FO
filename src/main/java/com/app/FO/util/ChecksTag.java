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
    private Checks checks;

    @Autowired
    public ChecksTag(TagRepository tagRepository,Checks checks) {
        this.tagRepository = tagRepository;
        this.checks=checks;

    }
    public void checkIsTag(Tag tag){
        if(!checks.isTag(tag)){
            throw new TagNotFoundException("Tag not found!");
        }
    }
    public void checkIsTagWithTagText(User user, String tagText){
        Tag tag =tagRepository.getTagsByUserIdAndTagText(user.getId(), tagText);
        if (tag != null) {
            throw new TagAlreadyExistException("Tag already exist");
        }
    }

    public void checkIsTagAndUserAndAreLinked(Tag tag, User user){
        if(!checks.isTag(tag)){
            throw new TagNotFoundException("Tag not found!");
        }else if(!checks.isUser(user)){
            throw new UserNotFoundException("User not found");
        }else if(!checks.tagHasUser(tag, user)) {
            throw new UserNotFoundException("User is not linked to tag");
        }
    }
    public void checkIsTagAndUserAndAreNotLinked(Tag tag, User user){
        if(!checks.isTag(tag)){
            throw new TagNotFoundException("Tag not found!");
        }else if(!checks.isUser(user)){
            throw new UserNotFoundException("User not found");
        }else if(checks.tagHasUser(tag, user)) {
            throw new UserAlreadyExistException("User is linked to tag");
        }
    }
}
