package com.app.FO.dto.remainder;

import com.app.FO.dto.event.EventSDTO;
import com.app.FO.dto.note.NoteSDTO;
import com.app.FO.dto.snooze.SnoozeSDTO;
import com.app.FO.dto.tag.TagSDTO;
import com.app.FO.dto.task.TaskSDTO;
import com.app.FO.dto.topic.TopicSDTO;
import com.app.FO.dto.user.UserSDTO;
import com.app.FO.model.remainder.Snooze;

import java.time.LocalDateTime;
import java.util.List;

public class RemainderDTO {
    private Long id;
    private String remainder;
    private LocalDateTime createdDateTime;
    private LocalDateTime remainderDateTime;
    private List<SnoozeSDTO> snoozes;
    private List<RemainderSDTO> repeatedReminders;
    private NoteSDTO note;
    private TaskSDTO task;
    private TopicSDTO topics;
    private UserSDTO user;
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
                        List<RemainderSDTO> repeatedReminders, NoteSDTO note, TaskSDTO task,
                        TopicSDTO topics, UserSDTO user, EventSDTO event) {
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

    public NoteSDTO getNote() {
        return note;
    }

    public void setNote(NoteSDTO note) {
        this.note = note;
    }

    public TaskSDTO getTask() {
        return task;
    }

    public void setTask(TaskSDTO task) {
        this.task = task;
    }

    public TopicSDTO getTopics() {
        return topics;
    }

    public void setTopics(TopicSDTO topics) {
        this.topics = topics;
    }

    public UserSDTO getUser() {
        return user;
    }

    public void setUser(UserSDTO user) {
        this.user = user;
    }

    public EventSDTO getEvent() {
        return event;
    }

    public void setEvent(EventSDTO event) {
        this.event = event;
    }
}
