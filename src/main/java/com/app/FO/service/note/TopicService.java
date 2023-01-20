package com.app.FO.service.note;

import com.app.FO.config.AllServices;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.exceptions.NoteNotFoundException;
import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.mapper.TopicDTOMapper;
import com.app.FO.model.note.Note;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.Topic;
import com.app.FO.repository.note.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    @Autowired
    private TopicDTOMapper topicDTOMapper;

    @Autowired
     public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    //-- GET
    public List<Topic> getTopicsByTagId(Long tagId){
        return topicRepository.getTopicsByTagId(tagId);
    }

    //-- GetDTO
    public List<TopicDTO> getTopicsDTOByTagId(Long tagId){
        return topicDTOMapper.TopicsToTopicsDTO(getTopicsByTagId(tagId));
    }
    public List<TopicDTO> getTopicsDTOByNoteId(Long noteId){
        List<Topic> foundTopics=topicRepository.getTopicsByNoteId(noteId);
        return topicDTOMapper.TopicsToTopicsDTO(foundTopics);
    }


    //-- Other

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
