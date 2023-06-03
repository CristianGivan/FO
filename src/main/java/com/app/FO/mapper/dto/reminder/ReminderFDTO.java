package com.app.FO.mapper.dto.reminder;

import com.app.FO.mapper.dto.note.NoteDTO;
import com.app.FO.mapper.dto.snooze.SnoozeDTO;
import com.app.FO.mapper.dto.task.TaskDTO;
import com.app.FO.mapper.dto.topic.TopicDTO;
import com.app.FO.mapper.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class ReminderFDTO {
    private Long id;
    private String reminder;
    private LocalDateTime createdDateTime;
    private LocalDateTime reminderDateTime;
    private List<SnoozeDTO> snoozeDTOList;
    private List<ReminderDTO> reminderDTOList;
    private NoteDTO note;
    private TaskDTO task;
    private TopicDTO topic;
    private UserDTO user;
    private EventDTO event;

    public ReminderFDTO(Long id, String reminder, LocalDateTime createdDateTime,
                        LocalDateTime reminderDateTime, List<SnoozeDTO> snoozeDTOList,
                        List<ReminderDTO> reminderDTOList, NoteDTO note, TaskDTO task,
                        TopicDTO topic, UserDTO user, EventDTO event) {
        this.id = id;
        this.reminder = reminder;
        this.createdDateTime = createdDateTime;
        this.reminderDateTime = reminderDateTime;
        this.snoozeDTOList = snoozeDTOList;
        this.reminderDTOList = reminderDTOList;
        this.note = note;
        this.task = task;
        this.topic = topic;
        this.user = user;
        this.event = event;
    }

    @Override
    public String toString() {
        return "ReminderFDTO{" +
                "id=" + id +
                ", reminder='" + reminder + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", reminderDateTime=" + reminderDateTime +
                ", snoozes=" + snoozeDTOList +
                ", repeatedReminders=" + reminderDTOList +
                ", note=" + note +
                ", task=" + task +
                ", topics=" + topic +
                ", user=" + user +
                ", event=" + event +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReminder() {
        return reminder;
    }

    public void setReminder(String reminder) {
        this.reminder = reminder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getReminderDateTime() {
        return reminderDateTime;
    }

    public void setReminderDateTime(LocalDateTime reminderDateTime) {
        this.reminderDateTime = reminderDateTime;
    }

    public List<SnoozeDTO> getSnoozeDTOList() {
        return snoozeDTOList;
    }

    public void setSnoozeDTOList(List<SnoozeDTO> snoozeDTOList) {
        this.snoozeDTOList = snoozeDTOList;
    }

    public List<ReminderDTO> getReminderDTOList() {
        return reminderDTOList;
    }

    public void setReminderDTOList(List<ReminderDTO> reminderDTOList) {
        this.reminderDTOList = reminderDTOList;
    }

    public NoteDTO getNote() {
        return note;
    }

    public void setNote(NoteDTO note) {
        this.note = note;
    }

    public TaskDTO getTask() {
        return task;
    }

    public void setTask(TaskDTO task) {
        this.task = task;
    }

    public TopicDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicDTO topic) {
        this.topic = topic;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }
}
