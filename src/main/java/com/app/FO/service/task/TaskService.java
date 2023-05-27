package com.app.FO.service.task;

import com.app.FO.exceptions.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.task.Task;
import com.app.FO.model.task.TaskReminder;
import com.app.FO.model.task.TaskTag;
import com.app.FO.model.task.TaskUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.task.TaskRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Tag tag = serviceAll.getTagByUserIdAndTagId(tagId, logInUser.getId());
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

//    public Task putNoteToTask(Long taskId, Long noteId) {
//        User logInUser = serviceAll.getLogInUser();
//
//        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
//        if (task == null) {
//            throw new TaskNotFoundException("Task not found in your list");
//        }
//
//        Note note = serviceAll.getNoteByIdAndUserId(noteId, logInUser.getId());
//        if (note == null) {
//            throw new NoteNotFoundException("Note not found");
//        }
//
//        TaskNote taskNote = serviceAll.getTaskNote(taskId, noteId);
//        if (taskNote != null) {
//            throw new TaskNoteAlreadyExistException("The task already has the note");
//        }
//
//        taskNote = new TaskNote(task, note);
//        task.getTaskNoteList().add(taskNote);
//
//        return taskRepository.save(task);
//    }

    public Task putReminderToTask(Long taskId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Reminder reminder = serviceAll.getReminderByIdAndUserId(reminderId, logInUser.getId());
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


//    public Task deleteNoteFromTask(Long taskId, Long noteId) {
//        User logInUser = serviceAll.getLogInUser();
//
//        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
//        if (task == null) {
//            throw new TaskNotFoundException("Task not found in your list");
//        }
//
//        Note note = serviceAll.getNoteByIdAndUserId(noteId, logInUser.getId());
//        if (note == null) {
//            throw new NoteNotFoundException("Note not found");
//        }
//
//        TaskNote taskNote = serviceAll.getTaskNote(taskId, noteId);
//        if (taskNote == null) {
//            throw new TaskNoteNotFoundException("The task don't has the note");
//        }
//
//        task.getTaskNoteList().remove(taskNote);
//
//        return taskRepository.save(task);
//    }

    public Task deleteTagFromTask(Long taskId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Task task = taskRepository.getTaskFromUserIdByTaskId(logInUser.getId(), taskId);
        if (task == null) {
            throw new TaskNotFoundException("Task not found in your list");
        }

        Tag tag = serviceAll.getTagByUserIdAndTagId(tagId, logInUser.getId());
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

        Reminder reminder = serviceAll.getReminderByIdAndUserId(reminderId, logInUser.getId());
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

//    public List<Task> getTaskListByNoteId(Long noteId) {
//        User logInUser = serviceAll.getLogInUser();
//        List<Task> taskList = taskRepository.getTaskListFromUserIdByNoteId(logInUser.getId(), noteId);
//        if (taskList.isEmpty()) {
//            throw new TaskNotFoundException("No task found");
//        }
//        return taskList;
//    }

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


    //-- Other

}
