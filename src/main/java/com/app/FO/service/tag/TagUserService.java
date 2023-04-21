package com.app.FO.service.tag;

import com.app.FO.exceptions.UserTagNotFoundException;
import com.app.FO.model.user.UserTag;
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

    public UserTag findUserTagById(Long userTagId){
        return tagUserRepository.findById(userTagId).orElseThrow(
                ()->new UserTagNotFoundException("UserTag not found"));
    }



    //-- Post

    public UserTag saveUserTag(UserTag userTag){
        return tagUserRepository.save(userTag);
    }


    //-- Put



    //--Delete



    //-- Other



    //-- Checks

}
