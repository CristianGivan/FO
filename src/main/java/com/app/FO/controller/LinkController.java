package com.app.FO.controller;

import com.app.FO.mapper.dto.link.LinkDTO;
import com.app.FO.mapper.mappers.LinkDTOMapper;
import com.app.FO.model.link.Link;
import com.app.FO.service.link.LinkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("link")
public class LinkController {
    private LinkService linkService;

    private LinkDTOMapper linkDTOMapper;

    @Autowired
    public LinkController(LinkService linkService, LinkDTOMapper linkDTOMapper) {
        this.linkService = linkService;
        this.linkDTOMapper = linkDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewLink")
    public LinkDTO postNewLink(@RequestParam String subject, @RequestParam String reference) {
        Link link = linkService.postLink(subject, reference);
        return linkDTOMapper.linkToLinkDTO(link);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToLink")
    public LinkDTO putSubjectToLink(@RequestParam Long linkId, @RequestParam String subject) {
        Link link = linkService.putSubjectToLink(linkId, subject);
        return linkDTOMapper.linkToLinkDTO(link);
    }


    //-- PutMapping
    @PutMapping("/putReferenceToLink")
    public LinkDTO putReferenceToLink(@RequestParam Long linkId, @RequestParam String reference) {
        Link link = linkService.putReferenceToLink(linkId, reference);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @PutMapping("/putUserToLink")
    public LinkDTO putUserToLink(@RequestParam Long linkId, @RequestParam Long userId) {
        Link link = linkService.putUserToLink(linkId, userId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @PutMapping("/putTagToLink")
    public LinkDTO putTagToLink(@RequestParam Long linkId, @RequestParam Long tagId) {
        Link link = linkService.putTagToLink(linkId, tagId);
        return linkDTOMapper.linkToLinkDTO(link);
    }


    @PutMapping("/putReminderToLink")
    public LinkDTO putReminderToLink(@RequestParam Long linkId, @RequestParam Long reminderId) {
        Link link = linkService.putReminderToLink(linkId, reminderId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @PutMapping("/putTopicToLink")
    public LinkDTO putTopicToLink(@RequestParam Long linkId, @RequestParam Long topicId) {
        Link link = linkService.putTopicToLink(linkId, topicId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @PutMapping("/putTasksToLink")
    public LinkDTO putTasksToLink(@RequestParam Long linkId, @RequestParam Long tasksId) {
        Link link = linkService.putTasksToLink(linkId, tasksId);
        return linkDTOMapper.linkToLinkDTO(link);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromLink")
    public LinkDTO deleteRoleFromLink(@RequestParam Long linkId, @RequestParam Long userId) {
        Link link = linkService.deleteUserFromLink(linkId, userId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @DeleteMapping("/deleteTagFromLink")
    public LinkDTO deleteTagFromLink(@RequestParam Long linkId, @RequestParam Long tagId) {
        Link link = linkService.deleteTagFromLink(linkId, tagId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @DeleteMapping("/deleteReminderFromLink")
    public LinkDTO deleteReminderFromLink(@RequestParam Long linkId, @RequestParam Long reminderId) {
        Link link = linkService.deleteReminderFromLink(linkId, reminderId);
        return linkDTOMapper.linkToLinkDTO(link);
    }


    @DeleteMapping("/deleteTopicFromLink")
    public LinkDTO deleteTopicFromLink(@RequestParam Long linkId, @RequestParam Long topicId) {
        Link link = linkService.deleteTopicFromLink(linkId, topicId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @DeleteMapping("/deleteTasksFromLink")
    public LinkDTO deleteTasksFromLink(@RequestParam Long linkId, @RequestParam Long tasksId) {
        Link link = linkService.deleteTasksFromLink(linkId, tasksId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @DeleteMapping("/deleteLink")
    public List<LinkDTO> deleteLink(@RequestParam Long linkId) {
        List<Link> linkList = linkService.deleteLink(linkId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }


    //---GetMapping

    @GetMapping("/getAllLink")
    public List<LinkDTO> getAllLink() {
        List<Link> linkList = linkService.getAllLink();
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkById")
    public LinkDTO getLinkById(@RequestParam Long linkId) {
        Link link = linkService.getLinkByLinkId(linkId);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @GetMapping("/getLinkBySubject")
    public LinkDTO getLinkBySubject(@RequestParam String subject) {
        Link link = linkService.getLinkBySubject(subject);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @GetMapping("/getLinkListBySubjectContains")
    public List<LinkDTO> getLinkListBySubjectContains(@RequestParam String subjectContain) {
        List<Link> linkList = linkService.getLinkListBySubjectContains(subjectContain);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkByReference")
    public LinkDTO getLinkByReference(@RequestParam String reference) {
        Link link = linkService.getLinkByReference(reference);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @GetMapping("/getLinkListByReferenceContains")
    public List<LinkDTO> getLinkListByReferenceContains(@RequestParam String referenceContain) {
        List<Link> linkList = linkService.getLinkListByReferenceContains(referenceContain);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public LinkDTO getLinkByCreatedDate(@RequestParam String createdDate) {
        Link link = linkService.getLinkByCreatedDate(createdDate);
        return linkDTOMapper.linkToLinkDTO(link);
    }

    @GetMapping("/getLinkListByCreatedDateBetween")
    public List<LinkDTO> getLinkListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Link> linkList = linkService.getLinkListByCreatedDateBetween(createdDateMin, createdDateMax);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkListByUserId")
    public List<LinkDTO> getLinkListByUserId(@RequestParam Long userId) {
        List<Link> linkList = linkService.getLinkListByUserId(userId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkListByTagId")
    public List<LinkDTO> getLinkListByTagId(@RequestParam Long tagId) {
        List<Link> linkList = linkService.getLinkListByTagId(tagId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkListByReminderId")
    public List<LinkDTO> getLinkListByReminderId(@RequestParam Long reminderId) {
        List<Link> linkList = linkService.getLinkListByReminderId(reminderId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkListByTopicId")
    public List<LinkDTO> getLinkListByTopicId(@RequestParam Long topicId) {
        List<Link> linkList = linkService.getLinkListByTopicId(topicId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }

    @GetMapping("/getLinkListByTasksId")
    public List<LinkDTO> getLinkListByTasksId(@RequestParam Long tasksId) {
        List<Link> linkList = linkService.getLinkListByTasksId(tasksId);
        return linkDTOMapper.linkListToLinkDTOList(linkList);
    }


    //--- Other


}
