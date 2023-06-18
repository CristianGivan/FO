package com.app.FO.service.tasks;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.tasks.*;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.tasks.TasksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TasksService {
    private TasksRepository tasksRepository;

    private ServiceAll serviceAll;

    @Autowired
    public TasksService(TasksRepository tasksRepository, ServiceAll serviceAll) {
        this.tasksRepository = tasksRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Tasks postTasks(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdBySubject(logInUser.getId(), subject);
        if (tasks != null) {
            throw new TasksAlreadyExistException("Tasks with this subject already exist");
        }

        tasks = tasksRepository.save(new Tasks(subject, logInUser));

        TasksUser tasksUser = new TasksUser(tasks, logInUser);
        tasks.getTasksUserList().add(tasksUser);

        return tasksRepository.save(tasks);
    }

    //-- Put
    public Tasks putSubjectToTasks(Long tasksId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        if (tasks.getSubject().equals(subject)) {
            throw new TasksAlreadyExistException("Tasks has already the same subject");
        }

        tasks.setSubject(subject);

        return tasksRepository.save(tasks);
    }

    public Tasks putUserToTasks(Long tasksId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TasksUser tasksUser = serviceAll.getTasksUser(tasksId, userId);
        if (tasksUser != null) {
            throw new TasksUserAlreadyExistException("The tasks already has the user");
        }

        tasksUser = new TasksUser(tasks, user);
        tasks.getTasksUserList().add(tasksUser);

        return tasksRepository.save(tasks);
    }

    public Tasks putTagToTasks(Long tasksId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TasksTag tasksTag = serviceAll.getTasksTag(tasksId, tagId);
        if (tasksTag != null) {
            throw new TasksTagAlreadyExistException("The tasks already has the tag");
        }

        tasksTag = new TasksTag(tasks, tag);
        tasks.getTasksTagList().add(tasksTag);

        return tasksRepository.save(tasks);
    }


    public Tasks putReminderToTasks(Long tasksId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TasksReminder tasksReminder = serviceAll.getTasksReminder(tasksId, reminderId);
        if (tasksReminder != null) {
            throw new TasksReminderAlreadyExistException("The tasks already has the reminder");
        }

        tasksReminder = new TasksReminder(tasks, reminder);
        tasks.getTasksReminderList().add(tasksReminder);

        return tasksRepository.save(tasks);
    }

    public Tasks putTopicToTasks(Long tasksId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TasksTopic tasksTopic = serviceAll.getTasksTopic(tasksId, topicId);
        if (tasksTopic != null) {
            throw new TasksTopicAlreadyExistException("The tasks already has the topic");
        }

        tasksTopic = new TasksTopic(tasks, topic);
        tasks.getTasksTopicList().add(tasksTopic);
        return tasksRepository.save(tasks);
    }

    public Tasks putTaskToTasks(Long tasksId, Long taskId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Task task = serviceAll.getTaskFromUserIdAndTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }

        TasksTask tasksTask = serviceAll.getTasksTask(tasksId, taskId);
        if (tasksTask != null) {
            throw new TasksTaskAlreadyExistException("The tasks already has the task");
        }

        tasksTask = new TasksTask(tasks, task);
        tasks.getTasksTaskList().add(tasksTask);
        return tasksRepository.save(tasks);
    }

    public Tasks putStartDateToTasks(Long tasksId, String startDateText) {
        /*      Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
         */
        LocalDateTime startDate = DateTime.textToLocalDateTime(startDateText);
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        tasks.setStartDate(startDate);
        return tasksRepository.save(tasks);
    }

    public Tasks putEndDateToTasks(Long tasksId, String endDateText) {
        /*      Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
         */
        LocalDateTime endDate = DateTime.textToLocalDateTime(endDateText);
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        tasks.setEndDate(endDate);
        return tasksRepository.save(tasks);
    }

    public Tasks putTasksStatusToTasks(Long tasksId, String tasksStatusText) {

        TaskStatus taskStatus = serviceAll.convertTaskStatusTextToTaskStatus(tasksStatusText);

        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        tasks.setTaskStatus(taskStatus);
        return tasksRepository.save(tasks);
    }

    //--Delete


    public Tasks deleteUserFromTasks(Long tasksId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TasksUser tasksUser = serviceAll.getTasksUser(tasksId, userId);
        if (tasksUser == null) {
            throw new TasksUserNotFoundException("The tasks don't has the user");
        }
        tasks.getTasksUserList().remove(tasksUser);

        return tasksRepository.save(tasks);
    }

    public Tasks deleteTagFromTasks(Long tasksId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TasksTag tasksTag = serviceAll.getTasksTag(tasksId, tagId);
        if (tasksTag == null) {
            throw new TasksTagNotFoundException("The tasks don't has the tag");
        }

        tasks.getTasksTagList().remove(tasksTag);

        return tasksRepository.save(tasks);
    }

    public Tasks deleteReminderFromTasks(Long tasksId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TasksReminder tasksReminder = serviceAll.getTasksReminder(tasksId, reminderId);
        if (tasksReminder == null) {
            throw new TasksReminderNotFoundException("The tasks don't has the reminder");
        }

        tasks.getTasksReminderList().remove(tasksReminder);

        return tasksRepository.save(tasks);
    }

    public Tasks deleteTopicFromTasks(Long tasksId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TasksTopic tasksTopic = serviceAll.getTasksTopic(tasksId, topicId);
        if (tasksTopic == null) {
            throw new TasksTopicNotFoundException("The tasks don't has the topic");
        }

        tasks.getTasksTopicList().remove(tasksTopic);

        return tasksRepository.save(tasks);
    }

    public Tasks deleteTaskFromTasks(Long tasksId, Long taskId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }

        Task task = serviceAll.getTaskFromUserIdAndTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }

        TasksTask tasksTask = serviceAll.getTasksTask(tasksId, taskId);
        if (tasksTask == null) {
            throw new TasksTaskNotFoundException("The tasks don't has the task");
        }

        tasks.getTasksTaskList().remove(tasksTask);

        return tasksRepository.save(tasks);
    }

    public List<Tasks> deleteTasks(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found in your list");
        }
        tasksRepository.delete(tasks);
        return getAllTasks();
    }
    //-- GET


    public List<Tasks> getAllTasks() {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserId(logInUser.getId());
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public Tasks getTasksBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Tasks tasks = tasksRepository.getTasksFromUserIdBySubject(logInUser.getId(), subject);
        if (tasks == null) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasks;
    }

    public List<Tasks> getTasksListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListBySubjectContains(logInUser.getId(), subjectContains);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public Tasks getTasksByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        Tasks tasks = tasksRepository.getTasksFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasks;
    }

    public List<Tasks> getTasksListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByUserId(logInUser.getId(), userId);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByTagId(logInUser.getId(), tagId);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksListByTaskId(Long taskId) {
        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByTaskId(logInUser.getId(), taskId);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksByStartDate(String startDateText) {
        /*      Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
         */
        LocalDateTime startDate = DateTime.textToLocalDateTime(startDateText);
        User logInUser = serviceAll.getLogInUser();

        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByStartDate(logInUser.getId(), startDate);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksByEndDate(String endDateText) {
        /*      Formatter "yyyy-MM-dd HH:mm:ss" 2023.06.01 13:14:15
         */
        LocalDateTime endDate = DateTime.textToLocalDateTime(endDateText);
        User logInUser = serviceAll.getLogInUser();

        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByEndDate(logInUser.getId(), endDate);
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }

    public List<Tasks> getTasksByTasksStatus(String tasksStatusText) {

        TaskStatus tasksStatus = serviceAll.convertTaskStatusTextToTaskStatus(tasksStatusText);

        User logInUser = serviceAll.getLogInUser();
        List<Tasks> tasksList = tasksRepository.getTasksListFromUserIdByTasksStatus(logInUser.getId(), tasksStatus.getValue());
        if (tasksList.isEmpty()) {
            throw new TasksNotFoundException("No tasks found");
        }
        return tasksList;
    }


    //-- Other


}
