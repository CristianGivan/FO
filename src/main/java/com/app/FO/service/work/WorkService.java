package com.app.FO.service.work;

import com.app.FO.config.DateTime;
import com.app.FO.config.ServiceAll;
import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskStatus;
import com.app.FO.model.task.TaskWork;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.model.work.*;
import com.app.FO.repository.work.WorkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WorkService {
    private WorkRepository workRepository;

    private ServiceAll serviceAll;

    @Autowired
    public WorkService(WorkRepository workRepository, ServiceAll serviceAll) {
        this.workRepository = workRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Work postWork(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdBySubject(logInUser.getId(), subject);
        if (work != null) {
            throw new WorkAlreadyExistException("Work with this subject already exist");
        }

        work = workRepository.save(new Work(subject, logInUser));

        WorkUser workUser = new WorkUser(work, logInUser);
        work.getWorkUserList().add(workUser);

        return workRepository.save(work);
    }

    //-- Put
    public Work putSubjectToWork(Long workId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        if (work.getSubject().equals(subject)) {
            throw new WorkAlreadyExistException("Work has already the same subject");
        }

        work.setSubject(subject);

        return workRepository.save(work);
    }


    public Work putWorkingDateTimeToWork(Long workId, String workingDateTimeText) {
        /*      Formatter "yyyy-MM-dd HH:mm:ss"  2023.06.01 13:14:15
         */
        LocalDateTime workingDateTime = DateTime.textToLocalDateTime(workingDateTimeText);
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        work.setWorkingDateTime(workingDateTime);
        return workRepository.save(work);
    }

    public Work putWorkingTimeToWork(Long workId, Double workingTime) {

        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        work.setWorkingTime(workingTime);
        return workRepository.save(work);
    }

    public Work putEstimatedTimeToWork(Long workId, Double estimatedTime) {

        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        work.setEstimatedTime(estimatedTime);
        return workRepository.save(work);
    }

    public Work putWorkingProgressToWork(Long workId, Double workingProgress) {

        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        work.setWorkingProgress(workingProgress);
        return workRepository.save(work);
    }

    public Work putTaskStatusToWork(Long workId, String taskStatusText) {

        TaskStatus taskStatus = serviceAll.convertTaskStatusTextToTaskStatus(taskStatusText);
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        work.setTaskStatus(taskStatus);
        return workRepository.save(work);
    }


    public Work putUserToWork(Long workId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        WorkUser workUser = serviceAll.getWorkUser(workId, userId);
        if (workUser != null) {
            throw new WorkUserAlreadyExistException("The work already has the user");
        }

        workUser = new WorkUser(work, user);
        work.getWorkUserList().add(workUser);

        return workRepository.save(work);
    }

    public Work putTagToWork(Long workId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        WorkTag workTag = serviceAll.getWorkTag(workId, tagId);
        if (workTag != null) {
            throw new WorkTagAlreadyExistException("The work already has the tag");
        }

        workTag = new WorkTag(work, tag);
        work.getWorkTagList().add(workTag);

        return workRepository.save(work);
    }


    public Work putReminderToWork(Long workId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        WorkReminder workReminder = serviceAll.getWorkReminder(workId, reminderId);
        if (workReminder != null) {
            throw new WorkReminderAlreadyExistException("The work already has the reminder");
        }

        workReminder = new WorkReminder(work, reminder);
        work.getWorkReminderList().add(workReminder);

        return workRepository.save(work);
    }

    public Work putTopicToWork(Long workId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        WorkTopic workTopic = serviceAll.getWorkTopic(workId, topicId);
        if (workTopic != null) {
            throw new WorkTopicAlreadyExistException("The work already has the topic");
        }

        workTopic = new WorkTopic(work, topic);
        work.getWorkTopicList().add(workTopic);
        return workRepository.save(work);
    }

    public Work putTaskToWork(Long workId, Long taskId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Task task = serviceAll.getTaskFromUserIdAndTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }

        TaskWork taskWork = serviceAll.getTaskWork(taskId, workId);
        if (taskWork != null) {
            throw new TaskWorkAlreadyExistException("The work already has the task");
        }

        taskWork = new TaskWork(task, work);
        work.getTaskWorkList().add(taskWork);
        return workRepository.save(work);
    }


    //--Delete


    public Work deleteUserFromWork(Long workId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        WorkUser workUser = serviceAll.getWorkUser(workId, userId);
        if (workUser == null) {
            throw new WorkUserNotFoundException("The work don't has the user");
        }
        work.getWorkUserList().remove(workUser);

        return workRepository.save(work);
    }

    public Work deleteTagFromWork(Long workId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        WorkTag workTag = serviceAll.getWorkTag(workId, tagId);
        if (workTag == null) {
            throw new WorkTagNotFoundException("The work don't has the tag");
        }

        work.getWorkTagList().remove(workTag);

        return workRepository.save(work);
    }

    public Work deleteReminderFromWork(Long workId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        WorkReminder workReminder = serviceAll.getWorkReminder(workId, reminderId);
        if (workReminder == null) {
            throw new WorkReminderNotFoundException("The work don't has the reminder");
        }

        work.getWorkReminderList().remove(workReminder);

        return workRepository.save(work);
    }

    public Work deleteTopicFromWork(Long workId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        WorkTopic workTopic = serviceAll.getWorkTopic(workId, topicId);
        if (workTopic == null) {
            throw new WorkTopicNotFoundException("The work don't has the topic");
        }

        work.getWorkTopicList().remove(workTopic);

        return workRepository.save(work);
    }

    public Work deleteTaskFromWork(Long workId, Long taskId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }

        Task task = serviceAll.getTaskFromUserIdAndTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found");
        }

        TaskWork taskWork = serviceAll.getTaskWork(taskId, workId);
        if (taskWork == null) {
            throw new TaskWorkNotFoundException("The work don't has the task");
        }

        work.getTaskWorkList().remove(taskWork);

        return workRepository.save(work);
    }

    public List<Work> deleteWork(Long workId) {
        User logInUser = serviceAll.getLogInUser();

        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("Work not found in your list");
        }
        workRepository.delete(work);
        return getAllWork();
    }
    //-- GET


    public List<Work> getAllWork() {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserId(logInUser.getId());
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }


    public Work getWorkByWorkId(Long workId) {
        User logInUser = serviceAll.getLogInUser();
        Work work = workRepository.getWorkFromUserIdByWorkId(logInUser.getId(), workId);
        if (work == null) {
            throw new WorkNotFoundException("No work found");
        }
        return work;
    }


    public Work getWorkBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Work work = workRepository.getWorkFromUserIdBySubject(logInUser.getId(), subject);
        if (work == null) {
            throw new WorkNotFoundException("No work found");
        }
        return work;
    }

    public List<Work> getWorkListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListBySubjectContains(logInUser.getId(), subjectContains);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }


    public Work getWorkByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Work work = workRepository.getWorkFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (work == null) {
            throw new WorkNotFoundException("No work found");
        }
        return work;
    }

    public List<Work> getWorkListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }


    public List<Work> getWorkListByWorkingDateTime(String workingDateTime) {
        LocalDateTime workingDateTimeTime = DateTime.textToLocalDateTime(workingDateTime);
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByWorkingDateTime(logInUser.getId(), workingDateTimeTime);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByWorkingDateTimeBetween(String workingDateTimeMin, String workingDateTimeMax) {
        LocalDateTime workingDateTimeTimeMin = DateTime.textToLocalDateTime(workingDateTimeMin);
        LocalDateTime workingDateTimeTimeMax = DateTime.textToLocalDateTime(workingDateTimeMax);
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByWorkingDateTimeBetween(logInUser.getId(), workingDateTimeTimeMin, workingDateTimeTimeMax);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkByWorkingTime(Double workingTime) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByWorkingTime(logInUser.getId(), workingTime);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByWorkingTimeBetween(Double workingTimeMin, Double workingTimeMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByWorkingTimeBetween(logInUser.getId(), workingTimeMin, workingTimeMax);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkByEstimatedTime(Double estimatedTime) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkFromUserIdByEstimatedTime(logInUser.getId(), estimatedTime);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByEstimatedTimeBetween(Double estimatedTimeMin, Double estimatedTimeMax) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByEstimatedTimeBetween(logInUser.getId(), estimatedTimeMin, estimatedTimeMax);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkByWorkingProgress(Double workingProgress) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkFromUserIdByWorkingProgress(logInUser.getId(), workingProgress);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkByTaskStatus(String taskStatusText) {

        TaskStatus taskStatus = serviceAll.convertTaskStatusTextToTaskStatus(taskStatusText);

        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByTaskStatus(logInUser.getId(), taskStatus.getValue());
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }


    public List<Work> getWorkListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByUserId(logInUser.getId(), userId);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByTagId(logInUser.getId(), tagId);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }

    public List<Work> getWorkListByTaskId(Long taskId) {
        User logInUser = serviceAll.getLogInUser();
        List<Work> workList = workRepository.getWorkListFromUserIdByTaskId(logInUser.getId(), taskId);
        if (workList.isEmpty()) {
            throw new WorkNotFoundException("No work found");
        }
        return workList;
    }


    //-- Other


}
