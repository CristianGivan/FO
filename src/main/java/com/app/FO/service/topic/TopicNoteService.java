package com.app.FO.service.topic;

import com.app.FO.exceptions.TopicNoteNotFoundException;
import com.app.FO.model.topic.TopicNote;
import com.app.FO.repository.topic.TopicNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public TopicNote getTopicNoteOfANoteIdByTopicId(Long topicId, Long noteId){
        return topicNoteRepository.findTopicNoteByNote_IdAndTopic_Id(noteId, topicId);
    }

    //-- Post



    //-- Put



    //--Delete

    public void deleteTopicNoteById(Long topicId, Long noteId){
        TopicNote topicNote=getTopicNoteOfANoteIdByTopicId(topicId,noteId);
        topicNoteRepository.delete(topicNote);
    }

    //-- Other



    //-- Checks



    //-- Redefine




}
