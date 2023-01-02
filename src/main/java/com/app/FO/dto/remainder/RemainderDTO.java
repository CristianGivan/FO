package com.app.FO.dto.remainder;

import com.app.FO.dto.event.EventSDTO;
import com.app.FO.dto.note.NoteDTO;
import com.app.FO.dto.snooze.SnoozeSDTO;
import com.app.FO.dto.task.TaskSDTO;
import com.app.FO.dto.topic.TopicDTO;
import com.app.FO.dto.user.UserDTO;

import java.time.LocalDateTime;
import java.util.List;

public class RemainderDTO {
    private Long id;
    private String remainder;
    private LocalDateTime createdDateTime;
    private LocalDateTime remainderDateTime;
    private List<SnoozeSDTO> snoozes;
    private List<RemainderSDTO> repeatedReminders;
    private NoteDTO note;
    private TaskSDTO task;
    private TopicDTO topics;
    private UserDTO user;
    private EventSDTO event;

    @Override
    public String toString() {
        return "RemainderDTO{" +
                "id=" + id +
                ", remainder='" + remainder + '\'' +
                ", createdDateTime=" + createdDateTime +
                ", remainderDateTime=" + remainderDateTime +
                ", snoozes=" + snoozes +
                ", repeatedReminders=" + repeatedReminders +
                ", note=" + note +
                ", task=" + task +
                ", topics=" + topics +
                ", user=" + user +
                ", event=" + event +
                '}';
    }

    public RemainderDTO(Long id, String remainder, LocalDateTime createdDateTime,
                        LocalDateTime remainderDateTime, List<SnoozeSDTO> snoozes,
                        List<RemainderSDTO> repeatedReminders, NoteDTO note, TaskSDTO task,
                        TopicDTO topics, UserDTO user, EventSDTO event) {
        this.id = id;
        this.remainder = remainder;
        this.createdDateTime = createdDateTime;
        this.remainderDateTime = remainderDateTime;
        this.snoozes = snoozes;
        this.repeatedReminders = repeatedReminders;
        this.note = note;
        this.task = task;
        this.topics = topics;
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

    public List<SnoozeSDTO> getSnoozes() {
        return snoozes;
    }

    public void setSnoozes(List<SnoozeSDTO> snoozes) {
        this.snoozes = snoozes;
    }

    public List<RemainderSDTO> getRepeatedReminders() {
        return repeatedReminders;
    }

    public void setRepeatedReminders(List<RemainderSDTO> repeatedReminders) {
        this.repeatedReminders = repeatedReminders;
    }

    public NoteDTO getNote() {
        return note;
    }

    public void setNote(NoteDTO note) {
        this.note = note;
    }

    public TaskSDTO getTask() {
        return task;
    }

    public void setTask(TaskSDTO task) {
        this.task = task;
    }

    public TopicDTO getTopics() {
        return topics;
    }

    public void setTopics(TopicDTO topics) {
        this.topics = topics;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public EventSDTO getEvent() {
        return event;
    }

    public void setEvent(EventSDTO event) {
        this.event = event;
    }
}
