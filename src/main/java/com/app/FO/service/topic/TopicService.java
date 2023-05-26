package com.app.FO.service.topic;

import com.app.FO.exceptions.TopicAlreadyExistException;
import com.app.FO.exceptions.TopicNotFoundException;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.topic.TopicUser;
import com.app.FO.model.user.User;
import com.app.FO.repository.topic.TopicRepository;
import com.app.FO.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    private TopicRepository topicRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private TopicUserService topicUserService;

    @Autowired
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    //-- Post

    public Topic postTopic(String subject) {
        User user = userService.getLogInUser();

        Topic topic = topicRepository.getTopicFromUserIdBySubject(user.getId(), subject);
        if (topic != null) {
            throw new TopicAlreadyExistException("Topic with this subject already exist");
        }

        topic = topicRepository.save(new Topic(subject, user));

        TopicUser topicUser = new TopicUser(userService.getLogInUser(), topic);
        topic.getTopicUserList().add(topicUser);

        return topicRepository.save(topic);
    }

    //-- Put
    public Topic putSubjectToTopic(Long topicId, String subject) {
        User user = userService.getLogInUser();
        Topic topic = topicRepository.getTopicFromUserIdByTopicId(user.getId(), topicId);
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
        Topic topic = null;

        return topicRepository.save(topic);
    }

    public Topic putTagToTopic(Long topicId, Long tagId) {
        Topic topic = null;

        return topicRepository.save(topic);
    }

    public Topic putNoteToTopic(Long topicId, Long noteId) {
        Topic topic = null;

        return topicRepository.save(topic);
    }

    public Topic putReminderToTopic(Long topicId, Long reminderId) {
        Topic topic = null;

        return topicRepository.save(topic);
    }


    //-- GET
    public List<Topic> getAllTopics() {
        //todo tbc with from user
        return topicRepository.findAll();
    }

    public List<Topic> getTopicsByTagId(Long tagId) {
        return topicRepository.getTopicListByTagId(tagId);
    }

    public Topic getTopicByTopicId(Long topicId) {
        return topicRepository.getTopicFromUserIdByTopicId(userService.getLogInUser().getId(), topicId);
    }

    public List<Topic> getTopicsByNote(Long noteId) {
        return topicRepository.getTopicsByNoteId(noteId);
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
