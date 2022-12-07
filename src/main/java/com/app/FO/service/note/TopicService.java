package com.app.FO.service.note;

import com.app.FO.model.note.Note;
import com.app.FO.model.note.Tag;
import com.app.FO.model.note.Topic;
import com.app.FO.repository.note.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic saveTopic(Topic topic){
        return topicRepository.save(topic);
    }

    public List<Topic> getTopicsByNote(Note note) {
        return topicRepository.getTopicsByNoteId(note.getId());
    }

    public List<Topic> getTopicsByTag(Tag tag){
        return topicRepository.getTopicsByTagId(tag.getId());
    }
}
