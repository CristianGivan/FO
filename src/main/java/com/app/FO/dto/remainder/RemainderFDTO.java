package com.app.FO.dto.remainder;

import com.app.FO.dto.event.EventDTO;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.snooze.SnoozeDTO;
import com.app.FO.dto.task.TaskDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class RemainderFDTO {
    private Long id;
    private String remainder;
    private LocalDateTime createdDateTime;
    private LocalDateTime remainderDateTime;
    private List<SnoozeDTO> snoozeDTOList;
    private List<RemainderDTO> remainderDTOList;
    private NoteDTO note;
    private TaskDTO task;
    private TopicDTO topic;
    private UserDTO user;
    private EventDTO event;

    @Override
    public String toString() {
        return "RemainderFDTO{" +
                "id=" + id +
                ", remainder='" + remainder + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", remainderDateTime=" + remainderDateTime +
                ", snoozes=" + snoozeDTOList +
                ", repeatedReminders=" + remainderDTOList +
                ", note=" + note +
                ", task=" + task +
                ", topics=" + topic +
                ", user=" + user +
                ", event=" + event +
                '}';
    }

    public RemainderFDTO(Long id, String remainder, LocalDateTime createdDateTime,
                         LocalDateTime remainderDateTime, List<SnoozeDTO> snoozeDTOList,
                         List<RemainderDTO> remainderDTOList, NoteDTO note, TaskDTO task,
                         TopicDTO topic, UserDTO user, EventDTO event) {
        this.id = id;
        this.remainder = remainder;
        this.createdDateTime = createdDateTime;
        this.remainderDateTime = remainderDateTime;
        this.snoozeDTOList = snoozeDTOList;
        this.remainderDTOList = remainderDTOList;
        this.note = note;
        this.task = task;
        this.topic = topic;
        this.user = user;
        this.event = event;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public LocalDateTime getRemainderDateTime() {
        return remainderDateTime;
    }

    public void setRemainderDateTime(LocalDateTime remainderDateTime) {
        this.remainderDateTime = remainderDateTime;
    }

    public List<SnoozeDTO> getSnoozeDTOList() {
        return snoozeDTOList;
    }

    public void setSnoozeDTOList(List<SnoozeDTO> snoozeDTOList) {
        this.snoozeDTOList = snoozeDTOList;
    }

    public List<RemainderDTO> getRemainderDTOList() {
        return remainderDTOList;
    }

    public void setRemainderDTOList(List<RemainderDTO> remainderDTOList) {
        this.remainderDTOList = remainderDTOList;
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
