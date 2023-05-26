package com.app.FO.service.topic;

import com.app.FO.exceptions.TopicAlreadyExistException;
import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.exceptions.TopicUserAlreadyExistException;
import com.app.FO.model.note.Note;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.topic.*;
import com.app.FO.model.user.User;
import com.app.FO.repository.topic.TopicRepository;
import com.app.FO.service.user.UserService;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private TopicRepository topicRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ServiceAll serviceAll;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    //-- Post

    public Topic postTopic(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdBySubject(logInUser.getId(), subject);
        if (topic != null) {
            throw new TopicAlreadyExistException("Topic with this subject already exist");
        }

        topic = topicRepository.save(new Topic(subject, logInUser));

        TopicUser topicUser = new TopicUser(topic, logInUser);
        topic.getTopicUserList().add(topicUser);

        return topicRepository.save(topic);
    }

    //-- Put
    public Topic putSubjectToTopic(Long topicId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found in your list");
        }

        if (topic.getSubject().equals(subject)) {
            throw new TopicAlreadyExistException("Topic has already the same subject");
        }

        topic.setSubject(subject);

        return topicRepository.save(topic);
    }

    public Topic putUserToTopic(Long topicId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found in your list");
        }

        User user = userService.getUserByUserId(userId);
        if (user == null) {
            throw new TopicNotFoundException("User not found");
        }

        TopicUser topicUser = serviceAll.getTopicUser(topicId, userId);
        if (topicUser != null) {
            throw new TopicUserAlreadyExistException("The topic already has the user");
        }

        topicUser = new TopicUser(topic, user);
        topic.getTopicUserList().add(topicUser);

        return topicRepository.save(topic);
    }

    public Topic putTagToTopic(Long topicId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found in your list");
        }

        Tag tag = serviceAll.getTagByUserIdAndTagId(tagId, logInUser.getId());
        if (tag == null) {
            throw new TopicNotFoundException("Tag not found");
        }

        TopicTag topicTag = serviceAll.getTopicTag(topicId, tagId);
        if (topicTag != null) {
            throw new TopicUserAlreadyExistException("The topic already has the tag");
        }

        topicTag = new TopicTag(topic, tag);
        topic.getTopicTagList().add(topicTag);

        return topicRepository.save(topic);
    }

    public Topic putNoteToTopic(Long topicId, Long noteId) {
        User logInUser = serviceAll.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found in your list");
        }

        Note note = serviceAll.getNoteByIdAndUserId(noteId, logInUser.getId());
        if (note == null) {
            throw new TopicNotFoundException("Note not found");
        }

        TopicNote topicNote = serviceAll.getTopicNote(topicId, noteId);
        if (topicNote != null) {
            throw new TopicUserAlreadyExistException("The topic already has the note");
        }

        topicNote = new TopicNote(topic, note);
        topic.getTopicNoteList().add(topicNote);

        return topicRepository.save(topic);
    }

    public Topic putReminderToTopic(Long topicId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found in your list");
        }

        Reminder reminder = serviceAll.getReminderByIdAndUserId(reminderId, logInUser.getId());
        if (reminder == null) {
            throw new TopicNotFoundException("Reminder not found");
        }

        TopicReminder topicReminder = serviceAll.getTopicReminder(topicId, reminderId);
        if (topicReminder != null) {
            throw new TopicUserAlreadyExistException("The topic already has the reminder");
        }

        topicReminder = new TopicReminder(topic, reminder);
        topic.getTopicReminderList().add(topicReminder);

        return topicRepository.save(topic);
    }


    //-- GET


    public List<Topic> getAllTopic() {
        User logInUser = serviceAll.getLogInUser();
        List<Topic> topicList = topicRepository.getTopicListFromUserId(logInUser.getId());
        if (topicList.isEmpty()) {
            throw new TopicNotFoundException("No topic found");
        }
        return topicList;
    }

    public Topic getTopicBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Topic topic = topicRepository.getTopicFromUserIdBySubject(logInUser.getId(), subject);
        if (topic == null) {
            throw new TopicNotFoundException("No topic found");
        }
        return topic;
    }

    public List<Topic> getTopicListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Topic> topicList = topicRepository.getTopicListBySubjectContains(logInUser.getId(), subjectContains);
        if (topicList.isEmpty()) {
            throw new TopicNotFoundException("No topic found");
        }
        return topicList;
    }

    public Topic getTopicByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        Topic topic = topicRepository.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("No topic found");
        }
        return topic;
    }

    public List<Topic> getTopicListByNoteId(Long noteId) {
        User logInUser = serviceAll.getLogInUser();
        List<Topic> topicList = topicRepository.getTopicListFromUserIdByNoteId(logInUser.getId(), noteId);
        if (topicList.isEmpty()) {
            throw new TopicNotFoundException("No topic found");
        }
        return topicList;
    }

    public List<Topic> getTopicListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Topic> topicList = topicRepository.getTopicListFromUserIdByTagId(logInUser.getId(), tagId);
        if (topicList.isEmpty()) {
            throw new TopicNotFoundException("No topic found");
        }
        return topicList;
    }

    public List<Topic> getTopicListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Topic> topicList = topicRepository.getTopicListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (topicList.isEmpty()) {
            throw new TopicNotFoundException("No topic found");
        }
        return topicList;
    }


    //--Delete


    //-- Other


    //-- ChecksNote


    //-- Redefine

    //todo tbdel
    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }


}
