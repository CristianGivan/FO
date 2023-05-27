package com.app.FO.controller;

import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.dto.task.TaskDTO;
import com.app.FO.mapper.mappers.TaskDTOMapper;
import com.app.FO.model.task.Task;
import com.app.FO.service.task.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tasks")
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
    public TaskDTO deleteTopicFromTask(@RequestParam Long taskId, @RequestParam Long topicrId) {
        Task task = taskService.deleteTopicFromTask(taskId, topicrId);
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

    @GetMapping("/getTaskById")
    public TaskDTO getTaskById(@RequestParam Long taskId) {
        Task task = taskService.getTaskByTaskId(taskId);
        return taskDTOMapper.taskToTaskDTO(task);
    }


    @GetMapping("/getTaskListByTopicId")
    public List<TaskDTO> getTaskListByTopicId(@RequestParam Long topicId) {
        List<Task> taskList = taskService.getTaskListByTopicId(topicId);
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


    //--- Other


}

