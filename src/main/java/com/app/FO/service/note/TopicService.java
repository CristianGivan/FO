package com.app.FO.service.note;

import com.app.FO.config.AllServices;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.mapper.TopicDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.note.TopicRepository;
import com.app.FO.service.user.UserService;
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
     public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    //-- GET
    public User getLogInUser() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return userService.getUserByUsername(userDetails.getUsername());
    }

    public List<Topic> getTopicsByTagId(Long tagId){
        return topicRepository.getTopicsByTagId(tagId);
    }


    //-- Post

    public Topic postTopic(String topicName){
        return topicRepository.save(new Topic(topicName,getLogInUser()));
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

    public List<Topic> getTopicsByNote(Note note) {
        return topicRepository.getTopicsByNoteId(note.getId());
    }



}
