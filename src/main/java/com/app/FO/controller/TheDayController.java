package com.app.FO.controller;

import com.app.FO.mapper.dto.theDay.TheDayDTO;
import com.app.FO.mapper.mappers.TheDayDTOMapper;
import com.app.FO.model.theDay.TheDay;
import com.app.FO.service.theDay.TheDayService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("theDay")
public class TheDayController {
    private TheDayService theDayService;

    private TheDayDTOMapper theDayDTOMapper;

    @Autowired
    public TheDayController(TheDayService theDayService, TheDayDTOMapper theDayDTOMapper) {
        this.theDayService = theDayService;
        this.theDayDTOMapper = theDayDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewTheDay")
    public TheDayDTO postNewTheDay(@RequestParam String subject, @RequestParam String date) {
        TheDay theDay = theDayService.postTheDay(subject, date);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToTheDay")
    public TheDayDTO putSubjectToTheDay(@RequestParam Long theDayId, @RequestParam String subject) {
        TheDay theDay = theDayService.putSubjectToTheDay(theDayId, subject);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }


    //-- PutMapping
    @PutMapping("/putReferenceToTheDay")
    public TheDayDTO putReferenceToTheDay(@RequestParam Long theDayId, @RequestParam String reference) {
        TheDay theDay = theDayService.putReferenceToTheDay(theDayId, reference);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @PutMapping("/putUserToTheDay")
    public TheDayDTO putUserToTheDay(@RequestParam Long theDayId, @RequestParam Long userId) {
        TheDay theDay = theDayService.putUserToTheDay(theDayId, userId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @PutMapping("/putTagToTheDay")
    public TheDayDTO putTagToTheDay(@RequestParam Long theDayId, @RequestParam Long tagId) {
        TheDay theDay = theDayService.putTagToTheDay(theDayId, tagId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }


    @PutMapping("/putReminderToTheDay")
    public TheDayDTO putReminderToTheDay(@RequestParam Long theDayId, @RequestParam Long reminderId) {
        TheDay theDay = theDayService.putReminderToTheDay(theDayId, reminderId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @PutMapping("/putTopicToTheDay")
    public TheDayDTO putTopicToTheDay(@RequestParam Long theDayId, @RequestParam Long topicId) {
        TheDay theDay = theDayService.putTopicToTheDay(theDayId, topicId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @PutMapping("/putTasksToTheDay")
    public TheDayDTO putTasksToTheDay(@RequestParam Long theDayId, @RequestParam Long tasksId) {
        TheDay theDay = theDayService.putTasksToTheDay(theDayId, tasksId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromTheDay")
    public TheDayDTO deleteRoleFromTheDay(@RequestParam Long theDayId, @RequestParam Long userId) {
        TheDay theDay = theDayService.deleteUserFromTheDay(theDayId, userId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @DeleteMapping("/deleteTagFromTheDay")
    public TheDayDTO deleteTagFromTheDay(@RequestParam Long theDayId, @RequestParam Long tagId) {
        TheDay theDay = theDayService.deleteTagFromTheDay(theDayId, tagId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @DeleteMapping("/deleteReminderFromTheDay")
    public TheDayDTO deleteReminderFromTheDay(@RequestParam Long theDayId, @RequestParam Long reminderId) {
        TheDay theDay = theDayService.deleteReminderFromTheDay(theDayId, reminderId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }


    @DeleteMapping("/deleteTopicFromTheDay")
    public TheDayDTO deleteTopicFromTheDay(@RequestParam Long theDayId, @RequestParam Long topicId) {
        TheDay theDay = theDayService.deleteTopicFromTheDay(theDayId, topicId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @DeleteMapping("/deleteTasksFromTheDay")
    public TheDayDTO deleteTasksFromTheDay(@RequestParam Long theDayId, @RequestParam Long tasksId) {
        TheDay theDay = theDayService.deleteTasksFromTheDay(theDayId, tasksId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @DeleteMapping("/deleteTheDay")
    public List<TheDayDTO> deleteTheDay(@RequestParam Long theDayId) {
        List<TheDay> theDayList = theDayService.deleteTheDay(theDayId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }


    //---GetMapping

    @GetMapping("/getAllTheDay")
    public List<TheDayDTO> getAllTheDay() {
        List<TheDay> theDayList = theDayService.getAllTheDay();
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayById")
    public TheDayDTO getTheDayById(@RequestParam Long theDayId) {
        TheDay theDay = theDayService.getTheDayByTheDayId(theDayId);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @GetMapping("/getTheDayBySubject")
    public TheDayDTO getTheDayBySubject(@RequestParam String subject) {
        TheDay theDay = theDayService.getTheDayBySubject(subject);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @GetMapping("/getTheDayListBySubjectContains")
    public List<TheDayDTO> getTheDayListBySubjectContains(@RequestParam String subjectContain) {
        List<TheDay> theDayList = theDayService.getTheDayListBySubjectContains(subjectContain);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayByReference")
    public TheDayDTO getTheDayByReference(@RequestParam String reference) {
        TheDay theDay = theDayService.getTheDayByReference(reference);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @GetMapping("/getTheDayListByReferenceContains")
    public List<TheDayDTO> getTheDayListByReferenceContains(@RequestParam String referenceContain) {
        List<TheDay> theDayList = theDayService.getTheDayListByReferenceContains(referenceContain);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public TheDayDTO getTheDayByCreatedDate(@RequestParam String createdDate) {
        TheDay theDay = theDayService.getTheDayByCreatedDate(createdDate);
        return theDayDTOMapper.theDayToTheDayDTO(theDay);
    }

    @GetMapping("/getTheDayListByCreatedDateBetween")
    public List<TheDayDTO> getTheDayListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<TheDay> theDayList = theDayService.getTheDayListByCreatedDateBetween(createdDateMin, createdDateMax);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayListByUserId")
    public List<TheDayDTO> getTheDayListByUserId(@RequestParam Long userId) {
        List<TheDay> theDayList = theDayService.getTheDayListByUserId(userId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayListByTagId")
    public List<TheDayDTO> getTheDayListByTagId(@RequestParam Long tagId) {
        List<TheDay> theDayList = theDayService.getTheDayListByTagId(tagId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayListByReminderId")
    public List<TheDayDTO> getTheDayListByReminderId(@RequestParam Long reminderId) {
        List<TheDay> theDayList = theDayService.getTheDayListByReminderId(reminderId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayListByTopicId")
    public List<TheDayDTO> getTheDayListByTopicId(@RequestParam Long topicId) {
        List<TheDay> theDayList = theDayService.getTheDayListByTopicId(topicId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }

    @GetMapping("/getTheDayListByTasksId")
    public List<TheDayDTO> getTheDayListByTasksId(@RequestParam Long tasksId) {
        List<TheDay> theDayList = theDayService.getTheDayListByTasksId(tasksId);
        return theDayDTOMapper.theDayListToTheDayDTOList(theDayList);
    }


    //--- Other


}
