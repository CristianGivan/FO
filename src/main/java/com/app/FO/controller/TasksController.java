package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.tasks.TasksDTO;
import com.app.FO.mapper.mappers.TasksDTOMapper;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.service.tasks.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
public class TasksController {
    private TasksService tasksService;

    private TasksDTOMapper tasksDTOMapper;

    @Autowired
    public TasksController(TasksService tasksService, TasksDTOMapper tasksDTOMapper) {
        this.tasksService = tasksService;
        this.tasksDTOMapper = tasksDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewTasks")
    public TasksDTO postNewTasks(@RequestBody TextDTO noteText) {
        Tasks tasks = tasksService.postTasks(noteText.getText());
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToTasks")
    public TasksDTO putSubjectToTasks(@RequestParam Long tasksId, @RequestParam String subject) {
        Tasks tasks = tasksService.putSubjectToTasks(tasksId, subject);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putUserToTasks")
    public TasksDTO putUserToTasks(@RequestParam Long tasksId, @RequestParam Long userId) {
        Tasks tasks = tasksService.putUserToTasks(tasksId, userId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putTagToTasks")
    public TasksDTO putTagToTasks(@RequestParam Long tasksId, @RequestParam Long tagId) {
        Tasks tasks = tasksService.putTagToTasks(tasksId, tagId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putTopicToTasks")
    public TasksDTO putTopicToTasks(@RequestParam Long tasksId, @RequestParam Long topicId) {
        Tasks tasks = tasksService.putTopicToTasks(tasksId, topicId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putReminderToTasks")
    public TasksDTO putReminderToTasks(@RequestParam Long tasksId, @RequestParam Long reminderId) {
        Tasks tasks = tasksService.putReminderToTasks(tasksId, reminderId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putTaskToTasks")
    public TasksDTO putTaskToTasks(@RequestParam Long tasksId, @RequestParam Long taskId) {
        Tasks tasks = tasksService.putTaskToTasks(tasksId, taskId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putStartDateToTasks")
    public TasksDTO putStartDateToTasks(@RequestParam Long tasksId, @RequestParam String startDate) {
        Tasks tasks = tasksService.putStartDateToTasks(tasksId, startDate);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putEndDateToTasks")
    public TasksDTO putEndDateToTasks(@RequestParam Long tasksId, @RequestParam String endDate) {
        Tasks tasks = tasksService.putEndDateToTasks(tasksId, endDate);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @PutMapping("/putTasksStatusToTasks")
    public TasksDTO putTasksStatusToTasks(@RequestParam Long tasksId, @RequestParam String tasksStatus) {
        Tasks tasks = tasksService.putTasksStatusToTasks(tasksId, tasksStatus);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromTasks")
    public TasksDTO deleteRoleFromTasks(@RequestParam Long tasksId, @RequestParam Long userId) {
        Tasks tasks = tasksService.deleteUserFromTasks(tasksId, userId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @DeleteMapping("/deleteTagFromTasks")
    public TasksDTO deleteTagFromTasks(@RequestParam Long tasksId, @RequestParam Long tagId) {
        Tasks tasks = tasksService.deleteTagFromTasks(tasksId, tagId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @DeleteMapping("/deleteReminderFromTasks")
    public TasksDTO deleteReminderFromTasks(@RequestParam Long tasksId, @RequestParam Long reminderId) {
        Tasks tasks = tasksService.deleteReminderFromTasks(tasksId, reminderId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }


    @DeleteMapping("/deleteTopicFromTasks")
    public TasksDTO deleteTopicFromTasks(@RequestParam Long tasksId, @RequestParam Long topicId) {
        Tasks tasks = tasksService.deleteTopicFromTasks(tasksId, topicId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @DeleteMapping("/deleteTaskFromTasks")
    public TasksDTO deleteTaskFromTasks(@RequestParam Long tasksId, @RequestParam Long taskId) {
        Tasks tasks = tasksService.deleteTaskFromTasks(tasksId, taskId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @DeleteMapping("/deleteTasks")
    public List<TasksDTO> deleteTasks(@RequestParam Long tasksId) {
        List<Tasks> tasksList = tasksService.deleteTasks(tasksId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }


    //---GetMapping

    @GetMapping("/getAllTasks")
    public List<TasksDTO> getAllTasks() {
        List<Tasks> tasksList = tasksService.getAllTasks();
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }


    @GetMapping("/getTasksBySubject")
    public TasksDTO getTasksBySubject(@RequestParam String subject) {
        Tasks tasks = tasksService.getTasksBySubject(subject);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }

    @GetMapping("/getTasksListBySubjectContains")
    public List<TasksDTO> getTasksListBySubjectContains(@RequestParam String subjectContain) {
        List<Tasks> tasksList = tasksService.getTasksListBySubjectContains(subjectContain);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksById")
    public TasksDTO getTasksById(@RequestParam Long tasksId) {
        Tasks tasks = tasksService.getTasksByTasksId(tasksId);
        return tasksDTOMapper.tasksToTasksDTO(tasks);
    }


    @GetMapping("/getTasksListByTopicId")
    public List<TasksDTO> getTasksListByTopicId(@RequestParam Long topicId) {
        List<Tasks> tasksList = tasksService.getTasksListByTopicId(topicId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksListByUserId")
    public List<TasksDTO> getTasksListByUserId(@RequestParam Long userId) {
        List<Tasks> tasksList = tasksService.getTasksListByUserId(userId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksListByTagId")
    public List<TasksDTO> getTasksListByTagId(@RequestParam Long tagId) {
        List<Tasks> tasksList = tasksService.getTasksListByTagId(tagId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksListByReminderId")
    public List<TasksDTO> getTasksListByReminderId(@RequestParam Long reminderId) {
        List<Tasks> tasksList = tasksService.getTasksListByReminderId(reminderId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksListByTaskId")
    public List<TasksDTO> getTasksListByTaskId(@RequestParam Long taskId) {
        List<Tasks> tasksList = tasksService.getTasksListByTaskId(taskId);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }


    @GetMapping("/getTasksByStartDate")
    public List<TasksDTO> getTasksByStartDate(@RequestParam String startDate) {
        List<Tasks> tasksList = tasksService.getTasksByStartDate(startDate);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksByEndDate")
    public List<TasksDTO> getTasksByEndDate(@RequestParam String endDate) {
        List<Tasks> tasksList = tasksService.getTasksByEndDate(endDate);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }

    @GetMapping("/getTasksByTasksStatus")
    public List<TasksDTO> getTasksByTasksStatus(@RequestParam String tasksStatus) {
        List<Tasks> tasksList = tasksService.getTasksByTasksStatus(tasksStatus);
        return tasksDTOMapper.tasksListToTasksDTOList(tasksList);
    }


    //--- Other


}

