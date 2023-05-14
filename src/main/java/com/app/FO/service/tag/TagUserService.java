package com.app.FO.service.tag;

import com.app.FO.exceptions.UserTagNotFoundException;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tag.TagUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.tag.TagUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagUserService {
    private TagUserRepository tagUserRepository;

    @Autowired
    public TagUserService(TagUserRepository tagUserRepository) {
        this.tagUserRepository = tagUserRepository;
    }


    //-- GET

    public TagUser findUserTagById(Long userTagId){
        return tagUserRepository.findById(userTagId).orElseThrow(
                ()->new UserTagNotFoundException("TagUser not found"));
    }


    //-- Post

    public TagUser saveUserTag(TagUser tagUser){
        return tagUserRepository.save(tagUser);
    }


    //-- Put



    //--Delete

    public void deleteUserFromTag(Tag tag, User user){
       TagUser tagUser= tagUserRepository.getTagUserByTagIdAndUserId(tag.getId(),user.getId());
       tagUserRepository.delete(tagUser);
    }


    //-- Other



    //-- ChecksNote

}
