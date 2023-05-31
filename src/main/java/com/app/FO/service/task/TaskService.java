package com.app.FO.service.task;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.*;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.model.work.Work;
import com.app.FO.repository.task.TaskRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskService {
    private TaskRepository taskRepository;

    private ServiceAll serviceAll;

    @Autowired
    public TaskService(TaskRepository taskRepository, ServiceAll serviceAll) {
        this.taskRepository = taskRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Task postTask(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdBySubject(logInUser.getId(), subject);
        if (task != null) {
            throw new TaskAlreadyExistException("Task with this subject already exist");
        }

        task = taskRepository.save(new Task(subject, logInUser));

        TaskUser taskUser = new TaskUser(task, logInUser);
        task.getTaskUserList().add(taskUser);

        return taskRepository.save(task);
    }

    //-- Put
    public Task putSubjectToTask(Long taskId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        if (task.getSubject().equals(subject)) {
            throw new TaskAlreadyExistException("Task has already the same subject");
        }

        task.setSubject(subject);

        return taskRepository.save(task);
    }

    public Task putUserToTask(Long taskId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TaskUser taskUser = serviceAll.getTaskUser(taskId, userId);
        if (taskUser != null) {
            throw new TaskUserAlreadyExistException("The task already has the user");
        }

        taskUser = new TaskUser(task, user);
        task.getTaskUserList().add(taskUser);

        return taskRepository.save(task);
    }

    public Task putTagToTask(Long taskId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TaskTag taskTag = serviceAll.getTaskTag(taskId, tagId);
        if (taskTag != null) {
            throw new TaskTagAlreadyExistException("The task already has the tag");
        }

        taskTag = new TaskTag(task, tag);
        task.getTaskTagList().add(taskTag);

        return taskRepository.save(task);
    }


    public Task putReminderToTask(Long taskId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TaskReminder taskReminder = serviceAll.getTaskReminder(taskId, reminderId);
        if (taskReminder != null) {
            throw new TaskReminderAlreadyExistException("The task already has the reminder");
        }

        taskReminder = new TaskReminder(task, reminder);
        task.getTaskReminderList().add(taskReminder);

        return taskRepository.save(task);
    }

    public Task putTopicToTask(Long taskId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TaskTopic taskTopic = serviceAll.getTaskTopic(taskId, topicId);
        if (taskTopic != null) {
            throw new TaskTopicAlreadyExistException("The task already has the topic");
        }

        taskTopic = new TaskTopic(task, topic);
        task.getTaskTopicList().add(taskTopic);
        return taskRepository.save(task);
    }

    public Task putWorkToTask(Long taskId, Long workId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Work work = serviceAll.getWorkByUserIdAndWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found");
        }

        TaskWork taskWork = serviceAll.getTaskWork(taskId, workId);
        if (taskWork != null) {
            throw new TaskTopicAlreadyExistException("The task already has the work");
        }

        taskWork = new TaskWork(task, work);
        task.getTaskWorkList().add(taskWork);
        return taskRepository.save(task);
    }

    public Task putStartDateToTask(Long taskId, String startDateText) {
/*      Formatter "yyyy.MM.dd HH:mm:ss"
2023.06.01 13:14:15
*/
        LocalDateTime startDate = DateTime.textToLocalDateTime(startDateText);
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        task.setStartDate(startDate);
        return taskRepository.save(task);
    }

    public Task putEndDateToTask(Long taskId, String endDateText) {
/*      Formatter "yyyy.MM.dd HH:mm:ss"
2023.06.01 13:14:15
*/
        LocalDateTime endDate = DateTime.textToLocalDateTime(endDateText);
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        task.setEndDate(endDate);
        return taskRepository.save(task);
    }

    public Task putTaskStatusToTask(Long taskId, String taskStatusText) {

        TaskStatus taskStatus = serviceAll.convertTaskStatusTextToTaskStatus(taskStatusText);

        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        task.setTaskStatus(taskStatus);
        return taskRepository.save(task);
    }

    //--Delete


    public Task deleteUserFromTask(Long taskId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        TaskUser taskUser = serviceAll.getTaskUser(taskId, userId);
        if (taskUser == null) {
            throw new TaskUserNotFoundException("The task don't has the user");
        }
        task.getTaskUserList().remove(taskUser);

        return taskRepository.save(task);
    }

    public Task deleteTagFromTask(Long taskId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        TaskTag taskTag = serviceAll.getTaskTag(taskId, tagId);
        if (taskTag == null) {
            throw new TaskTagNotFoundException("The task don't has the tag");
        }

        task.getTaskTagList().remove(taskTag);

        return taskRepository.save(task);
    }

    public Task deleteReminderFromTask(Long taskId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        TaskReminder taskReminder = serviceAll.getTaskReminder(taskId, reminderId);
        if (taskReminder == null) {
            throw new TaskReminderNotFoundException("The task don't has the reminder");
        }

        task.getTaskReminderList().remove(taskReminder);

        return taskRepository.save(task);
    }

    public Task deleteTopicFromTask(Long taskId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        TaskTopic taskTopic = serviceAll.getTaskTopic(taskId, topicId);
        if (taskTopic == null) {
            throw new TaskTopicNotFoundException("The task don't has the topic");
        }

        task.getTaskTopicList().remove(taskTopic);

        return taskRepository.save(task);
    }

    public Task deleteWorkFromTask(Long taskId, Long workId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Work work = serviceAll.getWorkByUserIdAndWorkId(workId, logInUser.getId());
        if (work == null) {
            throw new WorkNotFoundException("Work not found");
        }

        TaskWork taskWork = serviceAll.getTaskWork(taskId, workId);
        if (taskWork == null) {
            throw new TaskWorkNotFoundException("The task don't has the work");
        }

        task.getTaskWorkList().remove(taskWork);

        return taskRepository.save(task);
    }

    public List<Task> deleteTask(Long taskId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }
        taskRepository.delete(task);
        return getAllTask();
    }
    //-- GET


    public List<Task> getAllTask() {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserId(logInUser.getId());
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public Task getTaskBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Task task = taskRepository.getTaskFromUserIdBySubject(logInUser.getId(), subject);
        if (task == null) {
            throw new TaskNotFoundException("No task found");
        }
        return task;
    }

    public List<Task> getTaskListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListBySubjectContains(logInUser.getId(), subjectContains);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public Task getTaskByTaskId(Long taskId) {
        User logInUser = serviceAll.getLogInUser();
        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("No task found");
        }
        return task;
    }


    public List<Task> getTaskListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByUserId(logInUser.getId(), userId);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByTagId(logInUser.getId(), tagId);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskListByWorkId(Long workId) {
        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByWorkId(logInUser.getId(), workId);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskByStartDate(String startDateText) {
/*      Formatter "yyyy.MM.dd HH:mm:ss"
2023.06.01 13:14:15
*/
        LocalDateTime startDate = DateTime.textToLocalDateTime(startDateText);
        User logInUser = serviceAll.getLogInUser();

        List<Task> taskList = taskRepository.getTaskListFromUserIdByStartDate(logInUser.getId(), startDate);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskByEndDate(String endDateText) {
/*      Formatter "yyyy.MM.dd HH:mm:ss"
2023.06.01 13:14:15
*/
        LocalDateTime endDate = DateTime.textToLocalDateTime(endDateText);
        User logInUser = serviceAll.getLogInUser();

        List<Task> taskList = taskRepository.getTaskListFromUserIdByEndDate(logInUser.getId(), endDate);
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }

    public List<Task> getTaskByTaskStatus(String taskStatusText) {

        TaskStatus taskStatus = serviceAll.convertTaskStatusTextToTaskStatus(taskStatusText);

        User logInUser = serviceAll.getLogInUser();
        List<Task> taskList = taskRepository.getTaskListFromUserIdByTaskStatus(logInUser.getId(), taskStatus.getValue());
        if (taskList.isEmpty()) {
            throw new TaskNotFoundException("No task found");
        }
        return taskList;
    }


    //-- Other


}
