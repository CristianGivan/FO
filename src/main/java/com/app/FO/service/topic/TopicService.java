package com.app.FO.service.topic;

import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.repository.topic.TopicRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicUserService topicUserService;

    @Autowired
     public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    //-- GET
    public List<Topic> getAllTopics(){
        //todo tbc with from user
        return topicRepository.findAll();
    }

    public List<Topic> getTopicsByTagId(Long tagId){
        return topicRepository.getTopicListByTagId(tagId);
    }

    public Topic getTopicByTopicId(Long topicId){
       return topicRepository.getTopicFromUserByTopicId(userService.getLogInUser().getId(),topicId);
    }

    public List<Topic> getTopicsByNote(Long noteId) {
        return topicRepository.getTopicsByNoteId(noteId);
    }



    //-- Post

    public Topic postTopic(String topicName){
        Topic topic =topicRepository.save(new Topic(topicName,userService.getLogInUser()));
        TopicUser topicUser = topicUserService.postUsersTopics(new TopicUser(userService.getLogInUser(),topic));
        return topic;
    }

    //-- Put



    //--Delete


    //-- Other



    //-- ChecksNote



    //-- Redefine

    //todo tbdel
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }








}
