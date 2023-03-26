package com.app.FO.service.user;

import com.app.FO.exceptions.UserTagNotFoundException;
import com.app.FO.model.user.UserTag;
import com.app.FO.model.user.UsersTopics;
import com.app.FO.repository.user.UserTagRepository;
import com.app.FO.repository.user.UsersTopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersTopicsService {
    private UsersTopicsRepository usersTopicsRepository;

    @Autowired
    public UsersTopicsService(UsersTopicsRepository usersTopicsRepository) {
        this.usersTopicsRepository = usersTopicsRepository;
    }


    //-- GET

//    public UserTag findUserTagById(Long userTagId){
//        return userTagRepository.findById(userTagId).orElseThrow(
//                ()->new UserTagNotFoundException("UserTag not found"));


    //-- Post

    public UsersTopics postUsersTopics(UsersTopics usersTopics){
        return usersTopicsRepository.save(usersTopics);
    }

    //-- Put


    //--Delete


    //-- Other


    //-- Checks
}