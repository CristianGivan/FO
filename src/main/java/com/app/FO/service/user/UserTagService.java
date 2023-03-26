package com.app.FO.service.user;

import com.app.FO.exceptions.UserTagNotFoundException;
import com.app.FO.model.user.UserTag;
import com.app.FO.repository.user.UserTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserTagService {
    private UserTagRepository userTagRepository;

    @Autowired
    public UserTagService(UserTagRepository userTagRepository) {
        this.userTagRepository = userTagRepository;
    }


    //-- GET

    public UserTag findUserTagById(Long userTagId){
        return userTagRepository.findById(userTagId).orElseThrow(
                ()->new UserTagNotFoundException("UserTag not found"));
    }



    //-- Post

    public UserTag saveUserTag(UserTag userTag){
        return userTagRepository.save(userTag);
    }


    //-- Put



    //--Delete



    //-- Other



    //-- Checks

}
