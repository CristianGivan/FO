package com.app.FO.controller.note;

import com.app.FO.dto.ConverterDTO;
import com.app.FO.dto.note.TagDTO;
import com.app.FO.dto.note.TagSDTO;
import com.app.FO.dto.note.TopicDTO;
import com.app.FO.model.note.Tag;
import com.app.FO.service.note.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topics")
public class TopicController {
    private TopicService topicService;
    private ConverterDTO converterDTO;

    @Autowired
    public TopicController(TopicService topicService, ConverterDTO converterDTO) {
        this.topicService = topicService;
        this.converterDTO = converterDTO;
    }

    @GetMapping("/getAllTopics")
    public List<TopicDTO> getAllTopics(){
        return converterDTO.convertListOfTopicToListOfTopicDTO(topicService.getAllTopics());
    }

    @GetMapping("/getTopicById/{topicId}")
    public TopicDTO getTopicById(@PathVariable Long topicId){
        return converterDTO.convertTopicToTopicDTO(topicService.getTopicById(topicId));
    }



    }
