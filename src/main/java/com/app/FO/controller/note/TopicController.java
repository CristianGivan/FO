package com.app.FO.controller.note;

import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.topic.TopicFDTO;
import com.app.FO.mapper.TopicDTOMapper;
import com.app.FO.service.note.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {
    private TopicService topicService;



    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }


    //---GetMapping

    @GetMapping("/getTopicById/{topicId}")
    public TopicDTO getTopicById(@PathVariable Long topicId) {
        return TopicDTOMapper.INSTANCE.TopicToTopicDTO(topicService.getTopicById(topicId));
    }
//
//    @GetMapping("/getTopicFById/{topicId}")
//    public TopicFDTO getTopicFById(@PathVariable Long topicId) {
//        return converterDTO.convertTopicToTopicDTO(topicService.getTopicById(topicId));
//    }
//
//    @GetMapping("/getAllTopics")
//    public List<TopicFDTO> getAllTopics() {
//        return converterDTO.convertListOfTopicToListOfTopicDTO(topicService.getAllTopics());
//    }

}

