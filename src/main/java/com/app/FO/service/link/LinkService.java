package com.app.FO.service.link;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.link.*;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.link.LinkRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class LinkService {
    private LinkRepository linkRepository;

    private ServiceAll serviceAll;

    @Autowired
    public LinkService(LinkRepository linkRepository, ServiceAll serviceAll) {
        this.linkRepository = linkRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Link postLink(String subject, String reference) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdBySubject(logInUser.getId(), subject);
        if (link != null) {
            throw new LinkAlreadyExistException("Link with this subject already exist");
        }

        link = linkRepository.save(new Link(subject, reference, logInUser));

        LinkUser linkUser = new LinkUser(link, logInUser);
        link.getLinkUserList().add(linkUser);

        return linkRepository.save(link);
    }

    //-- Put
    public Link putSubjectToLink(Long linkId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        if (link.getSubject().equals(subject)) {
            throw new LinkAlreadyExistException("Link has already the same subject");
        }

        link.setSubject(subject);

        return linkRepository.save(link);
    }

    public Link putReferenceToLink(Long linkId, String reference) {
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        if (link.getReference().equals(reference)) {
            throw new LinkAlreadyExistException("Link has already the same reference");
        }

        link.setReference(reference);

        return linkRepository.save(link);
    }

    public Link putUserToLink(Long linkId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        LinkUser linkUser = serviceAll.getLinkUser(linkId, userId);
        if (linkUser != null) {
            throw new LinkUserAlreadyExistException("The link already has the user");
        }

        linkUser = new LinkUser(link, user);
        link.getLinkUserList().add(linkUser);

        return linkRepository.save(link);
    }

    public Link putTagToLink(Long linkId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        LinkTag linkTag = serviceAll.getLinkTag(linkId, tagId);
        if (linkTag != null) {
            throw new LinkTagAlreadyExistException("The link already has the tag");
        }

        linkTag = new LinkTag(link, tag);
        link.getLinkTagList().add(linkTag);

        return linkRepository.save(link);
    }


    public Link putReminderToLink(Long linkId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        LinkReminder linkReminder = serviceAll.getLinkReminder(linkId, reminderId);
        if (linkReminder != null) {
            throw new LinkReminderAlreadyExistException("The link already has the reminder");
        }

        linkReminder = new LinkReminder(link, reminder);
        link.getLinkReminderList().add(linkReminder);

        return linkRepository.save(link);
    }

    public Link putTopicToLink(Long linkId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        LinkTopic linkTopic = serviceAll.getLinkTopic(linkId, topicId);
        if (linkTopic != null) {
            throw new LinkTopicAlreadyExistException("The link already has the topic");
        }

        linkTopic = new LinkTopic(link, topic);
        link.getLinkTopicList().add(linkTopic);
        return linkRepository.save(link);
    }

    public Link putTasksToLink(Long linkId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        LinkTasks linkTasks = serviceAll.getLinkTasks(linkId, tasksId);
        if (linkTasks != null) {
            throw new LinkTasksAlreadyExistException("The link already has the tasks");
        }

        linkTasks = new LinkTasks(link, tasks);
        link.getLinkTasksList().add(linkTasks);
        return linkRepository.save(link);
    }


    //--Delete


    public Link deleteUserFromLink(Long linkId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        LinkUser linkUser = serviceAll.getLinkUser(linkId, userId);
        if (linkUser == null) {
            throw new LinkUserNotFoundException("The link don't has the user");
        }
        link.getLinkUserList().remove(linkUser);

        return linkRepository.save(link);
    }

    public Link deleteTagFromLink(Long linkId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdByTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        LinkTag linkTag = serviceAll.getLinkTag(linkId, tagId);
        if (linkTag == null) {
            throw new LinkTagNotFoundException("The link don't has the tag");
        }

        link.getLinkTagList().remove(linkTag);

        return linkRepository.save(link);
    }

    public Link deleteReminderFromLink(Long linkId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        LinkReminder linkReminder = serviceAll.getLinkReminder(linkId, reminderId);
        if (linkReminder == null) {
            throw new LinkReminderNotFoundException("The link don't has the reminder");
        }

        link.getLinkReminderList().remove(linkReminder);

        return linkRepository.save(link);
    }

    public Link deleteTopicFromLink(Long linkId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        LinkTopic linkTopic = serviceAll.getLinkTopic(linkId, topicId);
        if (linkTopic == null) {
            throw new LinkTasksNotFoundException("The link don't has the topic");
        }

        link.getLinkTopicList().remove(linkTopic);

        return linkRepository.save(link);
    }

    public Link deleteTasksFromLink(Long linkId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        LinkTasks linkTasks = serviceAll.getLinkTasks(linkId, tasksId);
        if (linkTasks == null) {
            throw new LinkTasksNotFoundException("The link don't has the tasks");
        }

        link.getLinkTasksList().remove(linkTasks);

        return linkRepository.save(link);
    }

    public List<Link> deleteLink(Long linkId) {
        User logInUser = serviceAll.getLogInUser();

        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("Link not found in your list");
        }
        linkRepository.delete(link);
        return getAllLink();
    }
    //-- GET


    public List<Link> getAllLink() {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserId(logInUser.getId());
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public Link getLinkByLinkId(Long linkId) {
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdByLinkId(logInUser.getId(), linkId);
        if (link == null) {
            throw new LinkNotFoundException("No link found");
        }
        return link;
    }

    public Link getLinkBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdBySubject(logInUser.getId(), subject);
        if (link == null) {
            throw new LinkNotFoundException("No link found");
        }
        return link;
    }

    public List<Link> getLinkListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListBySubjectContains(logInUser.getId(), subjectContains);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public Link getLinkByReference(String reference) {
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdByReference(logInUser.getId(), reference);
        if (link == null) {
            throw new LinkNotFoundException("No link found");
        }
        return link;
    }

    public List<Link> getLinkListByReferenceContains(String referenceContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListByReferenceContains(logInUser.getId(), referenceContains);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public Link getLinkByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Link link = linkRepository.getLinkFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (link == null) {
            throw new LinkNotFoundException("No link found");
        }
        return link;
    }

    public List<Link> getLinkListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public List<Link> getLinkListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByUserId(logInUser.getId(), userId);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public List<Link> getLinkListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByTagId(logInUser.getId(), tagId);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public List<Link> getLinkListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public List<Link> getLinkListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    public List<Link> getLinkListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Link> linkList = linkRepository.getLinkListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (linkList.isEmpty()) {
            throw new LinkNotFoundException("No link found");
        }
        return linkList;
    }

    //-- Other


}
