package com.app.FO.service.topic;

import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.repository.topic.TopicRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.service.user.UsersTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UsersTopicsService usersTopicsService;

    @Autowired
     public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    //-- GET
    //todo tnu can be used usertService.getLogInUser
    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Topic> getTopicsByTagId(Long tagId){
        return topicRepository.getTopicsByTagId(tagId);
    }

    public Topic getTopicByTopicIdFromUser(Long topicId){
       return topicRepository.getTopicFromUserByTopicId(userService.getLogInUser().getId(),topicId);
    }

    public List<Topic> getTopicsByNote(Note note) {
        return topicRepository.getTopicsByNoteId(note.getId());
    }



    //-- Post

    public Topic postTopic(String topicName){
        Topic topic =topicRepository.save(new Topic(topicName,userService.getLogInUser()));
        TopicUser topicUser =usersTopicsService.postUsersTopics(new TopicUser(userService.getLogInUser(),topic));
        return topic;
    }

    //-- Put



    //--Delete


    //-- Other



    //-- Checks



    //-- Redefine

    //todo tbdel
    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics(){
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long topicId){
        return topicRepository.findById(topicId).orElseThrow(
                ()->new TopicNotFoundException("Topic not found"));
    }





}
