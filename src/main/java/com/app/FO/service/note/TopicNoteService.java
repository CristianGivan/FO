package com.app.FO.service.note;

import com.app.FO.exceptions.NoteTagNotFoundException;
import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.exceptions.TopicNoteNotFoundException;
import com.app.FO.model.note.Note;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.model.user.User;
import com.app.FO.model.user.UsersTopics;
import com.app.FO.repository.note.TopicNoteRepository;
import com.app.FO.repository.note.TopicRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.service.user.UsersTopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicNoteService {

    private TopicNoteRepository topicNoteRepository;

    @Autowired
    public TopicNoteService(TopicNoteRepository topicNoteRepository) {
        this.topicNoteRepository = topicNoteRepository;
    }

    //-- GET

    public TopicNote getTopicNoteById(Long topicNoteId){
       return topicNoteRepository.findById(topicNoteId).orElseThrow(
                ()->new TopicNoteNotFoundException("TopicNote note find"));
    }

    public TopicNote getTopicNoteOfANoteIdByTopicId(Long noteId, Long topicId){

        return topicNoteRepository.findTopicNoteByNote_IdAndTopic_Id(noteId, topicId);
    }

    //-- Post



    //-- Put



    //--Delete

    public void deleteTopicNoteById(Long topicNoteId){
        topicNoteRepository.delete(getTopicNoteById(topicNoteId));
    }

    //-- Other



    //-- Checks



    //-- Redefine




}
