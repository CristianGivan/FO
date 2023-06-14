package com.app.FO.controller;

import com.app.FO.mapper.dto.event.EventDTO;
import com.app.FO.mapper.dto.general.TextDTO;
import com.app.FO.mapper.mappers.EventDTOMapper;
import com.app.FO.model.event.Event;
import com.app.FO.service.event.EventService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("event")
public class EventController {
    private EventService eventService;

    private EventDTOMapper eventDTOMapper;

    @Autowired
    public EventController(EventService eventService, EventDTOMapper eventDTOMapper) {
        this.eventService = eventService;
        this.eventDTOMapper = eventDTOMapper;
    }

    //-- PostMapping

    @PostMapping("/postNewEvent")
    public EventDTO postNewEvent(@RequestBody TextDTO eventText) {
        Event event = eventService.postEvent(eventText.getText());
        return eventDTOMapper.eventToEventDTO(event);
    }


    //-- PutMapping
    @PutMapping("/putSubjectToEvent")
    public EventDTO putSubjectToEvent(@RequestParam Long eventId, @RequestParam String subject) {
        Event event = eventService.putSubjectToEvent(eventId, subject);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putUserToEvent")
    public EventDTO putUserToEvent(@RequestParam Long eventId, @RequestParam Long userId) {
        Event event = eventService.putUserToEvent(eventId, userId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putTagToEvent")
    public EventDTO putTagToEvent(@RequestParam Long eventId, @RequestParam Long tagId) {
        Event event = eventService.putTagToEvent(eventId, tagId);
        return eventDTOMapper.eventToEventDTO(event);
    }


    @PutMapping("/putReminderToEvent")
    public EventDTO putReminderToEvent(@RequestParam Long eventId, @RequestParam Long reminderId) {
        Event event = eventService.putReminderToEvent(eventId, reminderId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putTopicToEvent")
    public EventDTO putTopicToEvent(@RequestParam Long eventId, @RequestParam Long topicId) {
        Event event = eventService.putTopicToEvent(eventId, topicId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putTasksToEvent")
    public EventDTO putTasksToEvent(@RequestParam Long eventId, @RequestParam Long tasksId) {
        Event event = eventService.putTasksToEvent(eventId, tasksId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putExpensesToEvent")
    public EventDTO putExpensesToEvent(@RequestParam Long eventId, @RequestParam Long expensesId) {
        Event event = eventService.putExpensesToEvent(eventId, expensesId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @PutMapping("/putPersonToEvent")
    public EventDTO putPersonToEvent(@RequestParam Long eventId, @RequestParam Long personId) {
        Event event = eventService.putPersonToEvent(eventId, personId);
        return eventDTOMapper.eventToEventDTO(event);
    }


    //-- DeleteMapping


    @DeleteMapping("/deleteUserFromEvent")
    public EventDTO deleteRoleFromEvent(@RequestParam Long eventId, @RequestParam Long userId) {
        Event event = eventService.deleteUserFromEvent(eventId, userId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @DeleteMapping("/deleteTagFromEvent")
    public EventDTO deleteTagFromEvent(@RequestParam Long eventId, @RequestParam Long tagId) {
        Event event = eventService.deleteTagFromEvent(eventId, tagId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @DeleteMapping("/deleteReminderFromEvent")
    public EventDTO deleteReminderFromEvent(@RequestParam Long eventId, @RequestParam Long reminderId) {
        Event event = eventService.deleteReminderFromEvent(eventId, reminderId);
        return eventDTOMapper.eventToEventDTO(event);
    }


    @DeleteMapping("/deleteTopicFromEvent")
    public EventDTO deleteTopicFromEvent(@RequestParam Long eventId, @RequestParam Long topicId) {
        Event event = eventService.deleteTopicFromEvent(eventId, topicId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @DeleteMapping("/deleteTasksFromEvent")
    public EventDTO deleteTasksFromEvent(@RequestParam Long eventId, @RequestParam Long tasksId) {
        Event event = eventService.deleteTasksFromEvent(eventId, tasksId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @DeleteMapping("/deleteEvent")
    public List<EventDTO> deleteEvent(@RequestParam Long eventId) {
        List<Event> eventList = eventService.deleteEvent(eventId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }


    //---GetMapping

    @GetMapping("/getAllEvent")
    public List<EventDTO> getAllEvent() {
        List<Event> eventList = eventService.getAllEvent();
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventById")
    public EventDTO getEventById(@RequestParam Long eventId) {
        Event event = eventService.getEventByEventId(eventId);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @GetMapping("/getEventBySubject")
    public EventDTO getEventBySubject(@RequestParam String subject) {
        Event event = eventService.getEventBySubject(subject);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @GetMapping("/getEventListBySubjectContains")
    public List<EventDTO> getEventListBySubjectContains(@RequestParam String subjectContain) {
        List<Event> eventList = eventService.getEventListBySubjectContains(subjectContain);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventByCreatedDate")
    @ApiOperation(value = "Formatter    yyyy-MM-dd HH:mm:ss 2023.06.01 13:14:15")
    public EventDTO getEventByCreatedDate(@RequestParam String createdDate) {
        Event event = eventService.getEventByCreatedDate(createdDate);
        return eventDTOMapper.eventToEventDTO(event);
    }

    @GetMapping("/getEventListByCreatedDateBetween")
    public List<EventDTO> getEventListByCreatedDateBetween(@RequestParam String createdDateMin, @RequestParam String createdDateMax) {
        List<Event> eventList = eventService.getEventListByCreatedDateBetween(createdDateMin, createdDateMax);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByUserId")
    public List<EventDTO> getEventListByUserId(@RequestParam Long userId) {
        List<Event> eventList = eventService.getEventListByUserId(userId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByTagId")
    public List<EventDTO> getEventListByTagId(@RequestParam Long tagId) {
        List<Event> eventList = eventService.getEventListByTagId(tagId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByReminderId")
    public List<EventDTO> getEventListByReminderId(@RequestParam Long reminderId) {
        List<Event> eventList = eventService.getEventListByReminderId(reminderId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByTopicId")
    public List<EventDTO> getEventListByTopicId(@RequestParam Long topicId) {
        List<Event> eventList = eventService.getEventListByTopicId(topicId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByTasksId")
    public List<EventDTO> getEventListByTasksId(@RequestParam Long tasksId) {
        List<Event> eventList = eventService.getEventListByTasksId(tasksId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByExpensesId")
    public List<EventDTO> getEventListByExpensesId(@RequestParam Long expensesId) {
        List<Event> eventList = eventService.getEventListByExpensesId(expensesId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    @GetMapping("/getEventListByPersonId")
    public List<EventDTO> getEventListByPersonId(@RequestParam Long personId) {
        List<Event> eventList = eventService.getEventListByPersonId(personId);
        return eventDTOMapper.eventListToEventDTOList(eventList);
    }

    //--- Other


}
