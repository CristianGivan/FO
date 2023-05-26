package com.app.FO.service.topic;

import com.app.FO.model.topic.TopicUser;
import com.app.FO.repository.topic.TopicUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicUserService {
    private TopicUserRepository topicUserRepository;

    @Autowired
    public TopicUserService(TopicUserRepository topicUserRepository) {
        this.topicUserRepository = topicUserRepository;
    }


    //-- GET

//    public TagUser findUserTagById(Long userTagId){
//        return userTagRepository.findById(userTagId).orElseThrow(
//                ()->new UserTagNotFoundException("TagUser not found"));


    //-- Post

    public TopicUser postUsersTopics(TopicUser topicUser) {
        return topicUserRepository.save(topicUser);
    }

    //-- Put


    //--Delete


    //-- Other


    //-- ChecksNote
}