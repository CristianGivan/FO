package com.app.FO.service.user;

import com.app.FO.model.topic.TopicUser;
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

    public TopicUser postUsersTopics(TopicUser topicUser){
        return usersTopicsRepository.save(topicUser);
    }

    //-- Put


    //--Delete


    //-- Other


    //-- Checks
}