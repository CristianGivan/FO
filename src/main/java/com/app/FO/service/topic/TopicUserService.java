package com.app.FO.service.topic;

import com.app.FO.model.topic.TopicUser;
import com.app.FO.repository.topic.TopicsUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicUserService {
    private TopicsUserRepository topicsUserRepository;

    @Autowired
    public TopicUserService(TopicsUserRepository topicsUserRepository) {
        this.topicsUserRepository = topicsUserRepository;
    }


    //-- GET

//    public UserTag findUserTagById(Long userTagId){
//        return userTagRepository.findById(userTagId).orElseThrow(
//                ()->new UserTagNotFoundException("UserTag not found"));


    //-- Post

    public TopicUser postUsersTopics(TopicUser topicUser){
        return topicsUserRepository.save(topicUser);
    }

    //-- Put


    //--Delete


    //-- Other


    //-- Checks
}