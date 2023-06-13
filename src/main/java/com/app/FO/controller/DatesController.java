package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.dates.DatesDTO;
import com.app.FO.mapper.mappers.DatesDTOMapper;
import com.app.FO.model.dates.Dates;
import com.app.FO.service.dates.DatesService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("dates")
public class DatesController {
    private DatesService datesService;

    private DatesDTOMapper datesDTOMapper;

    @Autowired
    public DatesController(DatesService datesService, DatesDTOMapper datesDTOMapper) {
        this.datesService = datesService;
        this.datesDTOMapper = datesDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewDates")
    public DatesDTO postNewDates(@RequestBody TextDTO noteText) {
        Dates dates = datesService.postDates(noteText.getText());
        return datesDTOMapper.datesToDatesDTO(dates);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToDates")
    public DatesDTO putSubjectToDates(@RequestParam Long datesId, @RequestParam String subject) {
        Dates dates = datesService.putSubjectToDates(datesId, subject);
        return datesDTOMapper.datesToDatesDTO(dates);
    }


    //-- PutMapping
    @PutMapping("/putReferenceToDates")
    public DatesDTO putReferenceToDates(@RequestParam Long datesId, @RequestParam String reference) {
        Dates dates = datesService.putReferenceToDates(datesId, reference);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @PutMapping("/putUserToDates")
    public DatesDTO putUserToDates(@RequestParam Long datesId, @RequestParam Long userId) {
        Dates dates = datesService.putUserToDates(datesId, userId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @PutMapping("/putTagToDates")
    public DatesDTO putTagToDates(@RequestParam Long datesId, @RequestParam Long tagId) {
        Dates dates = datesService.putTagToDates(datesId, tagId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }


    @PutMapping("/putReminderToDates")
    public DatesDTO putReminderToDates(@RequestParam Long datesId, @RequestParam Long reminderId) {
        Dates dates = datesService.putReminderToDates(datesId, reminderId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @PutMapping("/putTopicToDates")
    public DatesDTO putTopicToDates(@RequestParam Long datesId, @RequestParam Long topicId) {
        Dates dates = datesService.putTopicToDates(datesId, topicId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @PutMapping("/putTasksToDates")
    public DatesDTO putTasksToDates(@RequestParam Long datesId, @RequestParam Long tasksId) {
        Dates dates = datesService.putTasksToDates(datesId, tasksId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromDates")
    public DatesDTO deleteRoleFromDates(@RequestParam Long datesId, @RequestParam Long userId) {
        Dates dates = datesService.deleteUserFromDates(datesId, userId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @DeleteMapping("/deleteTagFromDates")
    public DatesDTO deleteTagFromDates(@RequestParam Long datesId, @RequestParam Long tagId) {
        Dates dates = datesService.deleteTagFromDates(datesId, tagId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @DeleteMapping("/deleteReminderFromDates")
    public DatesDTO deleteReminderFromDates(@RequestParam Long datesId, @RequestParam Long reminderId) {
        Dates dates = datesService.deleteReminderFromDates(datesId, reminderId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }


    @DeleteMapping("/deleteTopicFromDates")
    public DatesDTO deleteTopicFromDates(@RequestParam Long datesId, @RequestParam Long topicId) {
        Dates dates = datesService.deleteTopicFromDates(datesId, topicId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @DeleteMapping("/deleteTasksFromDates")
    public DatesDTO deleteTasksFromDates(@RequestParam Long datesId, @RequestParam Long tasksId) {
        Dates dates = datesService.deleteTasksFromDates(datesId, tasksId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @DeleteMapping("/deleteDates")
    public List<DatesDTO> deleteDates(@RequestParam Long datesId) {
        List<Dates> datesList = datesService.deleteDates(datesId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }


    //---GetMapping

    @GetMapping("/getAllDates")
    public List<DatesDTO> getAllDates() {
        List<Dates> datesList = datesService.getAllDates();
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesById")
    public DatesDTO getDatesById(@RequestParam Long datesId) {
        Dates dates = datesService.getDatesByDatesId(datesId);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @GetMapping("/getDatesBySubject")
    public DatesDTO getDatesBySubject(@RequestParam String subject) {
        Dates dates = datesService.getDatesBySubject(subject);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @GetMapping("/getDatesListBySubjectContains")
    public List<DatesDTO> getDatesListBySubjectContains(@RequestParam String subjectContain) {
        List<Dates> datesList = datesService.getDatesListBySubjectContains(subjectContain);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesByReference")
    public DatesDTO getDatesByReference(@RequestParam String reference) {
        Dates dates = datesService.getDatesByReference(reference);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @GetMapping("/getDatesListByReferenceContains")
    public List<DatesDTO> getDatesListByReferenceContains(@RequestParam String referenceContain) {
        List<Dates> datesList = datesService.getDatesListByReferenceContains(referenceContain);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public DatesDTO getDatesByCreatedDate(@RequestParam String createdDate) {
        Dates dates = datesService.getDatesByCreatedDate(createdDate);
        return datesDTOMapper.datesToDatesDTO(dates);
    }

    @GetMapping("/getDatesListByCreatedDateBetween")
    public List<DatesDTO> getDatesListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Dates> datesList = datesService.getDatesListByCreatedDateBetween(createdDateMin, createdDateMax);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesListByUserId")
    public List<DatesDTO> getDatesListByUserId(@RequestParam Long userId) {
        List<Dates> datesList = datesService.getDatesListByUserId(userId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesListByTagId")
    public List<DatesDTO> getDatesListByTagId(@RequestParam Long tagId) {
        List<Dates> datesList = datesService.getDatesListByTagId(tagId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesListByReminderId")
    public List<DatesDTO> getDatesListByReminderId(@RequestParam Long reminderId) {
        List<Dates> datesList = datesService.getDatesListByReminderId(reminderId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesListByTopicId")
    public List<DatesDTO> getDatesListByTopicId(@RequestParam Long topicId) {
        List<Dates> datesList = datesService.getDatesListByTopicId(topicId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }

    @GetMapping("/getDatesListByTasksId")
    public List<DatesDTO> getDatesListByTasksId(@RequestParam Long tasksId) {
        List<Dates> datesList = datesService.getDatesListByTasksId(tasksId);
        return datesDTOMapper.datesListToDatesDTOList(datesList);
    }


    //--- Other


}
