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
    @PutMapping("/putSubjectToTopic")
    public TopicDTO putSubjectToTopic(@RequestParam Long topicId, @RequestParam String subject) {
        Topic topic = topicService.putSubjectToTopic(topicId, subject);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @PutMapping("/putUserToTopic")
    public TopicDTO putUserToTopic(@RequestParam Long topicId, @RequestParam Long userId) {
        Topic topic = topicService.putUserToTopic(topicId, userId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @PutMapping("/putTagToTopic")
    public TopicDTO putTagToTopic(@RequestParam Long topicId, @RequestParam Long tagId) {
        Topic topic = topicService.putTagToTopic(topicId, tagId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @PutMapping("/putNoteToTopic")
    public TopicDTO putNoteToTopic(@RequestParam Long topicId, @RequestParam Long noteId) {
        Topic topic = topicService.putNoteToTopic(topicId, noteId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @PutMapping("/putReminderToTopic")
    public TopicDTO putReminderToTopic(@RequestParam Long topicId, @RequestParam Long reminderId) {
        Topic topic = topicService.putReminderToTopic(topicId, reminderId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    //---GetMapping

    @GetMapping("/getAllTopic")
    public List<TopicDTO> getAllTopic() {
        List<Topic> topicList = topicService.getAllTopic();
        return topicDTOMapper.TopicListToTopicDTOList(topicList);
    }


    @GetMapping("/getTopicBySubject")
    public TopicDTO getTopicBySubject(@RequestParam String subject) {
        Topic topic = topicService.getTopicBySubject(subject);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }

    @GetMapping("/getTopicListBySubjectContains")
    public List<TopicDTO> getTopicListBySubjectContains(@RequestParam String subjectContain) {
        List<Topic> topicList = topicService.getTopicListBySubjectContains(subjectContain);
        return topicDTOMapper.TopicListToTopicDTOList(topicList);
    }

    @GetMapping("/getTopicById")
    public TopicDTO getTopicById(@RequestParam Long topicId) {
        Topic topic = topicService.getTopicByTopicId(topicId);
        return topicDTOMapper.TopicToTopicDTO(topic);
    }


    @GetMapping("/getTopicListByNoteId")
    public List<TopicDTO> getTopicListByNoteId(@RequestParam Long noteId) {
        List<Topic> topicList = topicService.getTopicListByNoteId(noteId);
        return topicDTOMapper.TopicListToTopicDTOList(topicList);
    }

    @GetMapping("/getTopicListByTagId")
    public List<TopicDTO> getTopicListByTagId(@RequestParam Long tagId) {
        List<Topic> topicList = topicService.getTopicListByTagId(tagId);
        return topicDTOMapper.TopicListToTopicDTOList(topicList);
    }

    @GetMapping("/getTopicListByReminderId")
    public List<TopicDTO> getTopicListByReminderId(@RequestParam Long reminderId) {
        List<Topic> topicList = topicService.getTopicListByReminderId(reminderId);
        return topicDTOMapper.TopicListToTopicDTOList(topicList);
    }


    //-- DeleteMapping


    //--- Other


}

