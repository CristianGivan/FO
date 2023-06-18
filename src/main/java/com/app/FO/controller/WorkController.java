package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.work.WorkDTO;
import com.app.FO.mapper.mappers.WorkDTOMapper;
import com.app.FO.model.work.Work;
import com.app.FO.service.work.WorkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/work")
public class WorkController {

    private WorkService workService;

    private WorkDTOMapper workDTOMapper;

    @Autowired
    public WorkController(WorkService workService, WorkDTOMapper workDTOMapper) {
        this.workService = workService;
        this.workDTOMapper = workDTOMapper;
    }


    //-- PostMapping

    @PostMapping("/postWork")
    public WorkDTO postWork(@RequestBody TextDTO workText) {
        Work work = workService.postWork(workText.getText());
        return workDTOMapper.workToWorkDTO(work);
    }

    //-- PutMapping
    @PutMapping("/putSubjectToWork")
    public WorkDTO putSubjectToWork(@RequestParam Long workId, @RequestParam String subject) {
        Work work = workService.putSubjectToWork(workId, subject);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putWorkingDateTimeToWork")
    public WorkDTO putWorkingDateTimeToWork(@RequestParam Long workId, @RequestParam String workingDateTime) {
        Work work = workService.putWorkingDateTimeToWork(workId, workingDateTime);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putWorkingTimeToWork")
    public WorkDTO putWorkingTimeToWork(@RequestParam Long workId, @RequestParam Double workingTime) {
        Work work = workService.putWorkingTimeToWork(workId, workingTime);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putEstimatedTimeToWork")
    public WorkDTO putEstimatedTimeToWork(@RequestParam Long workId, @RequestParam Double estimatedTime) {
        Work work = workService.putEstimatedTimeToWork(workId, estimatedTime);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putWorkingProgressToWork")
    public WorkDTO putWorkingProgressToWork(@RequestParam Long workId, @RequestParam Double workingProgress) {
        Work work = workService.putWorkingProgressToWork(workId, workingProgress);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putTaskStatusToWork")
    public WorkDTO putTaskStatusToWork(@RequestParam Long workId, @RequestParam String taskStatus) {
        Work work = workService.putTaskStatusToWork(workId, taskStatus);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putUserToWork")
    public WorkDTO putUserToWork(@RequestParam Long workId, @RequestParam Long userId) {
        Work work = workService.putUserToWork(workId, userId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putTagToWork")
    public WorkDTO putTagToWork(@RequestParam Long workId, @RequestParam Long tagId) {
        Work work = workService.putTagToWork(workId, tagId);
        return workDTOMapper.workToWorkDTO(work);
    }


    @PutMapping("/putReminderToWork")
    public WorkDTO putReminderToWork(@RequestParam Long workId, @RequestParam Long reminderId) {
        Work work = workService.putReminderToWork(workId, reminderId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putTopicToWork")
    public WorkDTO putTopicToWork(@RequestParam Long workId, @RequestParam Long topicId) {
        Work work = workService.putTopicToWork(workId, topicId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putTaskToWork")
    public WorkDTO putTaskToWork(@RequestParam Long workId, @RequestParam Long taskId) {
        Work work = workService.putTaskToWork(workId, taskId);
        return workDTOMapper.workToWorkDTO(work);
    }

    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromWork")
    public WorkDTO deleteRoleFromWork(@RequestParam Long workId, @RequestParam Long userId) {
        Work work = workService.deleteUserFromWork(workId, userId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @DeleteMapping("/deleteTagFromWork")
    public WorkDTO deleteTagFromWork(@RequestParam Long workId, @RequestParam Long tagId) {
        Work work = workService.deleteTagFromWork(workId, tagId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @DeleteMapping("/deleteReminderFromWork")
    public WorkDTO deleteReminderFromWork(@RequestParam Long workId, @RequestParam Long reminderId) {
        Work work = workService.deleteReminderFromWork(workId, reminderId);
        return workDTOMapper.workToWorkDTO(work);
    }


    @DeleteMapping("/deleteTopicFromWork")
    public WorkDTO deleteTopicFromWork(@RequestParam Long workId, @RequestParam Long topicId) {
        Work work = workService.deleteTopicFromWork(workId, topicId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @DeleteMapping("/deleteTaskFromWork")
    public WorkDTO deleteTaskFromWork(@RequestParam Long workId, @RequestParam Long taskId) {
        Work work = workService.deleteTaskFromWork(workId, taskId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @DeleteMapping("/deleteWork")
    public List<WorkDTO> deleteWork(@RequestParam Long workId) {
        List<Work> workList = workService.deleteWork(workId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }


    //---GetMapping

    @GetMapping("/getAllWork")
    public List<WorkDTO> getAllWork() {
        List<Work> workList = workService.getAllWork();
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkById")
    public WorkDTO getWorkById(@RequestParam Long workId) {
        Work work = workService.getWorkByWorkId(workId);
        return workDTOMapper.workToWorkDTO(work);
    }

    @GetMapping("/getWorkBySubject")
    public WorkDTO getWorkBySubject(@RequestParam String subject) {
        Work work = workService.getWorkBySubject(subject);
        return workDTOMapper.workToWorkDTO(work);
    }

    @GetMapping("/getWorkListBySubjectContains")
    public List<WorkDTO> getWorkListBySubjectContains(@RequestParam String subjectContain) {
        List<Work> workList = workService.getWorkListBySubjectContains(subjectContain);
        return workDTOMapper.workListToWorkDTOList(workList);
    }


    @GetMapping("/getWorkByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public WorkDTO getWorkByCreatedDate(@RequestParam String createdDate) {
        Work work = workService.getWorkByCreatedDate(createdDate);
        return workDTOMapper.workToWorkDTO(work);
    }

    @GetMapping("/getWorkListByCreatedDateBetween")
    public List<WorkDTO> getWorkListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Work> workList = workService.getWorkListByCreatedDateBetween(createdDateMin, createdDateMax);
        return workDTOMapper.workListToWorkDTOList(workList);
    }


    @GetMapping("/getWorkByWorkingDateTime")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public List<WorkDTO> getWorkByWorkingDateTime(@RequestParam String workingDateTime) {
        List<Work> workList = workService.getWorkListByWorkingDateTime(workingDateTime);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByWorkingDateTimeBetween")
    public List<WorkDTO> getWorkListByWorkingDateTimeBetween(@RequestParam String workingDateTimeMin, @RequestParam String workingDateTimeMax) {
        List<Work> workList = workService.getWorkListByWorkingDateTimeBetween(workingDateTimeMin, workingDateTimeMax);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkByWorkingTime")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<WorkDTO> getWorkByWorkingTime(@RequestParam Double workingTime) {
        List<Work> workList = workService.getWorkByWorkingTime(workingTime);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByWorkingTimeBetween")
    public List<WorkDTO> getWorkListByWorkingTimeBetween(@RequestParam Double workingTimeMin, @RequestParam Double workingTimeMax) {
        List<Work> workList = workService.getWorkListByWorkingTimeBetween(workingTimeMin, workingTimeMax);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkByEstimatedTime")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<WorkDTO> getWorkByEstimatedTime(@RequestParam Double estimatedTime) {
        List<Work> workList = workService.getWorkByEstimatedTime(estimatedTime);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByEstimatedTimeBetween")
    public List<WorkDTO> getWorkListByEstimatedTimeBetween(@RequestParam Double estimatedTimeMin, @RequestParam Double estimatedTimeMax) {
        List<Work> workList = workService.getWorkListByEstimatedTimeBetween(estimatedTimeMin, estimatedTimeMax);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkByWorkingProgress")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<WorkDTO> getWorkByWorkingProgress(@RequestParam Double workingProgress) {
        List<Work> workList = workService.getWorkByWorkingProgress(workingProgress);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkByTaskStatus")
    public List<WorkDTO> getWorkByTaskStatus(@RequestParam String workStatus) {
        List<Work> workList = workService.getWorkByTaskStatus(workStatus);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByUserId")
    public List<WorkDTO> getWorkListByUserId(@RequestParam Long userId) {
        List<Work> workList = workService.getWorkListByUserId(userId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByTagId")
    public List<WorkDTO> getWorkListByTagId(@RequestParam Long tagId) {
        List<Work> workList = workService.getWorkListByTagId(tagId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByReminderId")
    public List<WorkDTO> getWorkListByReminderId(@RequestParam Long reminderId) {
        List<Work> workList = workService.getWorkListByReminderId(reminderId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByTopicId")
    public List<WorkDTO> getWorkListByTopicId(@RequestParam Long topicId) {
        List<Work> workList = workService.getWorkListByTopicId(topicId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkListByTaskId")
    public List<WorkDTO> getWorkListByTaskId(@RequestParam Long taskId) {
        List<Work> workList = workService.getWorkListByTaskId(taskId);
        return workDTOMapper.workListToWorkDTOList(workList);
    }


    //--- Other


}

