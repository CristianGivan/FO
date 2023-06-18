package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.task.TaskDTO;
import com.app.FO.mapper.mappers.TaskDTOMapper;
import com.app.FO.model.task.Task;
import com.app.FO.service.task.TaskService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    private TaskDTOMapper taskDTOMapper;

    @Autowired
    public TaskController(TaskService taskService, TaskDTOMapper taskDTOMapper) {
        this.taskService = taskService;
        this.taskDTOMapper = taskDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewTask")
    public TaskDTO postNewTask(@RequestBody TextDTO noteText) {
        Task task = taskService.postTask(noteText.getText());
        return taskDTOMapper.taskToTaskDTO(task);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToTask")
    public TaskDTO putSubjectToTask(@RequestParam Long taskId, @RequestParam String subject) {
        Task task = taskService.putSubjectToTask(taskId, subject);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putStartDateToTask")
    public TaskDTO putStartDateToTask(@RequestParam Long taskId, @RequestParam String startDate) {
        Task task = taskService.putStartDateToTask(taskId, startDate);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putEndDateToTask")
    public TaskDTO putEndDateToTask(@RequestParam Long taskId, @RequestParam String endDate) {
        Task task = taskService.putEndDateToTask(taskId, endDate);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putUserToTask")
    public TaskDTO putUserToTask(@RequestParam Long taskId, @RequestParam Long userId) {
        Task task = taskService.putUserToTask(taskId, userId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putTagToTask")
    public TaskDTO putTagToTask(@RequestParam Long taskId, @RequestParam Long tagId) {
        Task task = taskService.putTagToTask(taskId, tagId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putTopicToTask")
    public TaskDTO putTopicToTask(@RequestParam Long taskId, @RequestParam Long topicId) {
        Task task = taskService.putTopicToTask(taskId, topicId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putReminderToTask")
    public TaskDTO putReminderToTask(@RequestParam Long taskId, @RequestParam Long reminderId) {
        Task task = taskService.putReminderToTask(taskId, reminderId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @PutMapping("/putWorkToTask")
    public TaskDTO putWorkToTask(@RequestParam Long taskId, @RequestParam Long workId) {
        Task task = taskService.putWorkToTask(taskId, workId);
        return taskDTOMapper.taskToTaskDTO(task);
    }


    @PutMapping("/putTaskStatusToTask")
    public TaskDTO putTaskStatusToTask(@RequestParam Long taskId, @RequestParam String taskStatus) {
        Task task = taskService.putTaskStatusToTask(taskId, taskStatus);
        return taskDTOMapper.taskToTaskDTO(task);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromTask")
    public TaskDTO deleteRoleFromTask(@RequestParam Long taskId, @RequestParam Long userId) {
        Task task = taskService.deleteUserFromTask(taskId, userId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @DeleteMapping("/deleteTagFromTask")
    public TaskDTO deleteTagFromTask(@RequestParam Long taskId, @RequestParam Long tagId) {
        Task task = taskService.deleteTagFromTask(taskId, tagId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @DeleteMapping("/deleteReminderFromTask")
    public TaskDTO deleteReminderFromTask(@RequestParam Long taskId, @RequestParam Long reminderId) {
        Task task = taskService.deleteReminderFromTask(taskId, reminderId);
        return taskDTOMapper.taskToTaskDTO(task);
    }


    @DeleteMapping("/deleteTopicFromTask")
    public TaskDTO deleteTopicFromTask(@RequestParam Long taskId, @RequestParam Long topicId) {
        Task task = taskService.deleteTopicFromTask(taskId, topicId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @DeleteMapping("/deleteWorkFromTask")
    public TaskDTO deleteWorkFromTask(@RequestParam Long taskId, @RequestParam Long workId) {
        Task task = taskService.deleteWorkFromTask(taskId, workId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @DeleteMapping("/deleteTask")
    public List<TaskDTO> deleteTask(@RequestParam Long taskId) {
        List<Task> taskList = taskService.deleteTask(taskId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    //---GetMapping

    @GetMapping("/getAllTask")
    public List<TaskDTO> getAllTask() {
        List<Task> taskList = taskService.getAllTask();
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskById")
    public TaskDTO getTaskById(@RequestParam Long taskId) {
        Task task = taskService.getTaskByTaskId(taskId);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @GetMapping("/getTaskBySubject")
    public TaskDTO getTaskBySubject(@RequestParam String subject) {
        Task task = taskService.getTaskBySubject(subject);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @GetMapping("/getTaskListBySubjectContains")
    public List<TaskDTO> getTaskListBySubjectContains(@RequestParam String subjectContain) {
        List<Task> taskList = taskService.getTaskListBySubjectContains(subjectContain);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public TaskDTO getTaskByCreatedDate(@RequestParam String createdDate) {
        Task task = taskService.getTaskByCreatedDate(createdDate);
        return taskDTOMapper.taskToTaskDTO(task);
    }

    @GetMapping("/getTaskListByCreatedDateBetween")
    public List<TaskDTO> getTaskListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Task> taskList = taskService.getTaskListByCreatedDateBetween(createdDateMin, createdDateMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskByStartDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public List<TaskDTO> getTaskByStartDate(@RequestParam String startDate) {
        List<Task> taskList = taskService.getTaskByStartDate(startDate);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByStartDateBetween")
    public List<TaskDTO> getTaskListByStartDateBetween(@RequestParam String startDateMin, @RequestParam String startDateMax) {
        List<Task> taskList = taskService.getTaskListByStartDateBetween(startDateMin, startDateMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskByEndDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public List<TaskDTO> getTaskByEndDate(@RequestParam String endDate) {
        List<Task> taskList = taskService.getTaskByEndDate(endDate);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByEndDateBetween")
    public List<TaskDTO> getTaskListByEndDateBetween(@RequestParam String endDateMin, @RequestParam String endDateMax) {
        List<Task> taskList = taskService.getTaskListByEndDateBetween(endDateMin, endDateMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskByWorkingTime")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<TaskDTO> getTaskByWorkingTime(@RequestParam Double workingTime) {
        List<Task> taskList = taskService.getTaskByWorkingTime(workingTime);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByWorkingTimeBetween")
    public List<TaskDTO> getTaskListByWorkingTimeBetween(@RequestParam Double workingTimeMin, @RequestParam Double workingTimeMax) {
        List<Task> taskList = taskService.getTaskListByWorkingTimeBetween(workingTimeMin, workingTimeMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskByEstimatedTime")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<TaskDTO> getTaskByEstimatedTime(@RequestParam Double estimatedTime) {
        List<Task> taskList = taskService.getTaskByEstimatedTime(estimatedTime);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByEstimatedTimeBetween")
    public List<TaskDTO> getTaskListByEstimatedTimeBetween(@RequestParam Double estimatedTimeMin, @RequestParam Double estimatedTimeMax) {
        List<Task> taskList = taskService.getTaskListByEstimatedTimeBetween(estimatedTimeMin, estimatedTimeMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskByEstimatedLeftTime")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<TaskDTO> getTaskByEstimatedLeftTime(@RequestParam Double estimatedLeftTime) {
        List<Task> taskList = taskService.getTaskByEstimatedLeftTime(estimatedLeftTime);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByEstimatedLeftTimeBetween")
    public List<TaskDTO> getTaskListByEstimatedLeftTimeBetween(@RequestParam Double estimatedLeftTimeMin, @RequestParam Double estimatedLeftTimeMax) {
        List<Task> taskList = taskService.getTaskListByEstimatedLeftTimeBetween(estimatedLeftTimeMin, estimatedLeftTimeMax);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskByWorkingProgress")
    @ApiOperation(value = "Hours 1:30h = 1.5")
    public List<TaskDTO> getTaskByWorkingProgress(@RequestParam Double workingProgress) {
        List<Task> taskList = taskService.getTaskByWorkingProgress(workingProgress);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskByTaskStatus")
    public List<TaskDTO> getTaskByTaskStatus(@RequestParam String taskStatus) {
        List<Task> taskList = taskService.getTaskByTaskStatus(taskStatus);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskListByUserId")
    public List<TaskDTO> getTaskListByUserId(@RequestParam Long userId) {
        List<Task> taskList = taskService.getTaskListByUserId(userId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByTagId")
    public List<TaskDTO> getTaskListByTagId(@RequestParam Long tagId) {
        List<Task> taskList = taskService.getTaskListByTagId(tagId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskListByReminderId")
    public List<TaskDTO> getTaskListByReminderId(@RequestParam Long reminderId) {
        List<Task> taskList = taskService.getTaskListByReminderId(reminderId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    @GetMapping("/getTaskListByTopicId")
    public List<TaskDTO> getTaskListByTopicId(@RequestParam Long topicId) {
        List<Task> taskList = taskService.getTaskListByTopicId(topicId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }

    @GetMapping("/getTaskListByWorkId")
    public List<TaskDTO> getTaskListByWorkId(@RequestParam Long workId) {
        List<Task> taskList = taskService.getTaskListByWorkId(workId);
        return taskDTOMapper.taskListToTaskDTOList(taskList);
    }


    //--- Other


}

