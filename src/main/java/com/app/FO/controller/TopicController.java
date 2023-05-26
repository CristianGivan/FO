package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.topic.TopicDTO;
import com.app.FO.mapper.mappers.TopicDTOMapper;
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

    //-- PostMapping

    @PostMapping("/postNewTopic")
    public TopicDTO postNewTopic(@RequestBody TextDTO noteText) {
        Topic topic = topicService.postTopic(noteText.getText());
        return topicDTOMapper.TopicToTopicDTO(topic);
    }


    //-- PutMapping


    //---GetMapping

    @GetMapping("/getTopicById/{topicId}")
    public TopicDTO getTopicById(@PathVariable Long topicId) {
        Topic topic = topicService.getTopicByTopicId(topicId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @GetMapping("/getAllTopics")
    public List<TopicDTO> getAllTopics() {
        List<Topic> topics = topicService.getAllTopics();
        return topicDTOMapper.TopicListToTopicDTOList(topics);
    }

    @GetMapping("/getTopicListByTagId/{tagId}")
    public List<TopicDTO> getTopicListByTagId(@PathVariable Long tagId) {
        List<Topic> topics = topicService.getTopicsByTagId(tagId);
        return topicDTOMapper.TopicListToTopicDTOList(topics);
    }


    //-- DeleteMapping


    //--- Other


}

