package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.work.WorkDTO;
import com.app.FO.mapper.mappers.WorkDTOMapper;
import com.app.FO.model.work.Work;
import com.app.FO.service.work.WorkService;
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

    @PutMapping("/putWorkingDateTimeToWork")
    public WorkDTO putWorkingDateTimeToWork(@RequestParam Long workId, @RequestParam String workingDateTime) {
        Work work = workService.putWorkingDateTimeToWork(workId, workingDateTime);
        return workDTOMapper.workToWorkDTO(work);
    }

    @PutMapping("/putWorkingEfortToWork")
    public WorkDTO putWorkingEfortToWork(@RequestParam Long workId, @RequestParam String workingEfort) {
        Work work = workService.putWorkingEfortToWork(workId, workingEfort);
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

    @GetMapping("/getWorkById")
    public WorkDTO getWorkById(@RequestParam Long workId) {
        Work work = workService.getWorkByWorkId(workId);
        return workDTOMapper.workToWorkDTO(work);
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


    @GetMapping("/getWorkByWorkingDateTime")
    public List<WorkDTO> getWorkByWorkingDateTime(@RequestParam String workingDateTime) {
        List<Work> workList = workService.getWorkByWorkingDateTime(workingDateTime);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    @GetMapping("/getWorkByWorkingEfort")
    public List<WorkDTO> getWorkByWorkingEfort(@RequestParam String workingEfort) {
        List<Work> workList = workService.getWorkByWorkingEfort(workingEfort);
        return workDTOMapper.workListToWorkDTOList(workList);
    }

    //--- Other


}

