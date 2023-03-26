package com.app.FO.controller.note;

import com.app.FO.dto.general.TextDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.mapper.TopicDTOMapper;
import com.app.FO.model.topic.Topic;
import com.app.FO.service.topic.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {
    private TopicService topicService;

    @Autowired
    private TopicDTOMapper topicDTOMapper;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    //---GetMapping

    @GetMapping("/getTopicById/{topicId}")
    public TopicDTO getTopicById(@PathVariable Long topicId) {
        Topic topic = topicService.getTopicById(topicId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @GetMapping("/getAllTopics")
    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return topicDTOMapper.TopicsToTopicsDTO(topics);
    }

    //-- PostMapping

    @PostMapping("/postNewTopic")
    public TopicDTO postNewTopic(@RequestBody TextDTO noteText) {
        Topic topic = topicService.postTopic(noteText.getText());
        return topicDTOMapper.TopicToTopicDTO(topic);
    }


    //-- PutMapping


    //-- DeleteMapping


    //--- Other


}

