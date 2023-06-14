package com.app.FO.service.event;

import com.app.FO.config.DateTime;
import com.app.FO.exceptions.*;
import com.app.FO.model.event.*;
import com.app.FO.model.expenses.Expenses;
import com.app.FO.model.person.Person;
import com.app.FO.model.reminder.Reminder;
import com.app.FO.model.tag.Tag;
import com.app.FO.model.tasks.Tasks;
import com.app.FO.model.topic.Topic;
import com.app.FO.model.user.User;
import com.app.FO.repository.event.EventRepository;
import com.app.FO.util.ServiceAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventService {
    private EventRepository eventRepository;

    private ServiceAll serviceAll;

    @Autowired
    public EventService(EventRepository eventRepository, ServiceAll serviceAll) {
        this.eventRepository = eventRepository;
        this.serviceAll = serviceAll;
    }

//-- Post

    public Event postEvent(String subject) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdBySubject(logInUser.getId(), subject);
        if (event != null) {
            throw new EventAlreadyExistException("Event with this subject already exist");
        }

        event = eventRepository.save(new Event(subject, logInUser));

        EventUser eventUser = new EventUser(event, logInUser);
        event.getEventUserList().add(eventUser);

        return eventRepository.save(event);
    }

    //-- Put
    public Event putSubjectToEvent(Long eventId, String subject) {
        User logInUser = serviceAll.getLogInUser();
        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        if (event.getSubject().equals(subject)) {
            throw new EventAlreadyExistException("Event has already the same subject");
        }

        event.setSubject(subject);

        return eventRepository.save(event);
    }

    public Event getEventByCreatedDate(String createdDate) {
        LocalDateTime createdDateTime = DateTime.textToLocalDateTime(createdDate);
        User logInUser = serviceAll.getLogInUser();
        Event event = eventRepository.getEventFromUserIdByCreatedDate(logInUser.getId(), createdDateTime);
        if (event == null) {
            throw new EventNotFoundException("No event found");
        }
        return event;
    }

    public List<Event> getEventListByCreatedDateBetween(String createdDateMin, String createdDateMax) {
        LocalDateTime createdDateTimeMin = DateTime.textToLocalDateTime(createdDateMin);
        LocalDateTime createdDateTimeMax = DateTime.textToLocalDateTime(createdDateMax);
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByCreatedDateBetween(logInUser.getId(), createdDateTimeMin, createdDateTimeMax);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public Event putUserToEvent(Long eventId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        EventUser eventUser = serviceAll.getEventUser(eventId, userId);
        if (eventUser != null) {
            throw new EventUserAlreadyExistException("The event already has the user");
        }

        eventUser = new EventUser(event, user);
        event.getEventUserList().add(eventUser);

        return eventRepository.save(event);
    }

    public Event putTagToEvent(Long eventId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        EventTag eventTag = serviceAll.getEventTag(eventId, tagId);
        if (eventTag != null) {
            throw new EventTagAlreadyExistException("The event already has the tag");
        }

        eventTag = new EventTag(event, tag);
        event.getEventTagList().add(eventTag);

        return eventRepository.save(event);
    }


    public Event putReminderToEvent(Long eventId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        EventReminder eventReminder = serviceAll.getEventReminder(eventId, reminderId);
        if (eventReminder != null) {
            throw new EventReminderAlreadyExistException("The event already has the reminder");
        }

        eventReminder = new EventReminder(event, reminder);
        event.getEventReminderList().add(eventReminder);

        return eventRepository.save(event);
    }

    public Event putTopicToEvent(Long eventId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        EventTopic eventTopic = serviceAll.getEventTopic(eventId, topicId);
        if (eventTopic != null) {
            throw new EventTopicAlreadyExistException("The event already has the topic");
        }

        eventTopic = new EventTopic(event, topic);
        event.getEventTopicList().add(eventTopic);
        return eventRepository.save(event);
    }

    public Event putTasksToEvent(Long eventId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        EventTasks eventTasks = serviceAll.getEventTasks(eventId, tasksId);
        if (eventTasks != null) {
            throw new EventTasksAlreadyExistException("The event already has the tasks");
        }

        eventTasks = new EventTasks(event, tasks);
        event.getEventTasksList().add(eventTasks);
        return eventRepository.save(event);
    }

    public Event putExpensesToEvent(Long eventId, Long expensesId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Expenses expenses = serviceAll.getExpensesFromUserIdAndExpensesId(logInUser.getId(), expensesId);
        if (expenses == null) {
            throw new ExpensesNotFoundException("Expenses not found");
        }

        EventExpenses eventExpenses = serviceAll.getEventExpenses(eventId, expensesId);
        if (eventExpenses != null) {
            throw new EventExpensesAlreadyExistException("The event already has the expenses");
        }

        eventExpenses = new EventExpenses(event, expenses);
        event.getEventExpensesList().add(eventExpenses);
        return eventRepository.save(event);
    }

    public Event putPersonToEvent(Long eventId, Long personId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Person person = serviceAll.getPersonFromUserIdAndPersonId(logInUser.getId(), personId);
        if (person == null) {
            throw new PersonNotFoundException("Person not found");
        }

        EventPerson eventPerson = serviceAll.getEventPerson(eventId, personId);
        if (eventPerson != null) {
            throw new EventPersonAlreadyExistException("The event already has the person");
        }

        eventPerson = new EventPerson(event, person);
        event.getEventPersonList().add(eventPerson);
        return eventRepository.save(event);
    }


    //--Delete


    public Event deleteUserFromEvent(Long eventId, Long userId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        User user = serviceAll.getUserByUserId(userId);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        EventUser eventUser = serviceAll.getEventUser(eventId, userId);
        if (eventUser == null) {
            throw new EventUserNotFoundException("The event don't has the user");
        }
        event.getEventUserList().remove(eventUser);

        return eventRepository.save(event);
    }

    public Event deleteTagFromEvent(Long eventId, Long tagId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Tag tag = serviceAll.getTagFromUserIdAndTagId(logInUser.getId(), tagId);
        if (tag == null) {
            throw new TagNotFoundException("Tag not found");
        }

        EventTag eventTag = serviceAll.getEventTag(eventId, tagId);
        if (eventTag == null) {
            throw new EventTagNotFoundException("The event don't has the tag");
        }

        event.getEventTagList().remove(eventTag);

        return eventRepository.save(event);
    }

    public Event deleteReminderFromEvent(Long eventId, Long reminderId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Reminder reminder = serviceAll.getReminderFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (reminder == null) {
            throw new ReminderNotFoundException("Reminder not found");
        }

        EventReminder eventReminder = serviceAll.getEventReminder(eventId, reminderId);
        if (eventReminder == null) {
            throw new EventReminderNotFoundException("The event don't has the reminder");
        }

        event.getEventReminderList().remove(eventReminder);

        return eventRepository.save(event);
    }

    public Event deleteTopicFromEvent(Long eventId, Long topicId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Topic topic = serviceAll.getTopicFromUserIdByTopicId(logInUser.getId(), topicId);
        if (topic == null) {
            throw new TopicNotFoundException("Topic not found");
        }

        EventTopic eventTopic = serviceAll.getEventTopic(eventId, topicId);
        if (eventTopic == null) {
            throw new EventTasksNotFoundException("The event don't has the topic");
        }

        event.getEventTopicList().remove(eventTopic);

        return eventRepository.save(event);
    }

    public Event deleteTasksFromEvent(Long eventId, Long tasksId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }

        Tasks tasks = serviceAll.getTasksFromUserIdAndTasksId(logInUser.getId(), tasksId);
        if (tasks == null) {
            throw new TasksNotFoundException("Tasks not found");
        }

        EventTasks eventTasks = serviceAll.getEventTasks(eventId, tasksId);
        if (eventTasks == null) {
            throw new EventTasksNotFoundException("The event don't has the tasks");
        }

        event.getEventTasksList().remove(eventTasks);

        return eventRepository.save(event);
    }

    public List<Event> deleteEvent(Long eventId) {
        User logInUser = serviceAll.getLogInUser();

        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("Event not found in your list");
        }
        eventRepository.delete(event);
        return getAllEvent();
    }
    //-- GET


    public List<Event> getAllEvent() {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserId(logInUser.getId());
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public Event getEventBySubject(String subject) {
        User logInUser = serviceAll.getLogInUser();
        Event event = eventRepository.getEventFromUserIdBySubject(logInUser.getId(), subject);
        if (event == null) {
            throw new EventNotFoundException("No event found");
        }
        return event;
    }

    public List<Event> getEventListBySubjectContains(String subjectContains) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListBySubjectContains(logInUser.getId(), subjectContains);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public Event getEventByEventId(Long eventId) {
        User logInUser = serviceAll.getLogInUser();
        Event event = eventRepository.getEventFromUserIdByEventId(logInUser.getId(), eventId);
        if (event == null) {
            throw new EventNotFoundException("No event found");
        }
        return event;
    }

    public List<Event> getEventListByUserId(Long userId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByUserId(logInUser.getId(), userId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByTagId(Long tagId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByTagId(logInUser.getId(), tagId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByReminderId(Long reminderId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByReminderId(logInUser.getId(), reminderId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByTopicId(Long topicId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByTopicId(logInUser.getId(), topicId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByTasksId(Long tasksId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByTasksId(logInUser.getId(), tasksId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByExpensesId(Long expensesId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByExpensesId(logInUser.getId(), expensesId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    public List<Event> getEventListByPersonId(Long personId) {
        User logInUser = serviceAll.getLogInUser();
        List<Event> eventList = eventRepository.getEventListFromUserIdByPersonId(logInUser.getId(), personId);
        if (eventList.isEmpty()) {
            throw new EventNotFoundException("No event found");
        }
        return eventList;
    }

    //-- Other


}
