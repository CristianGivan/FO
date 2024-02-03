package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.model.reminder.Reminder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReminderDTOMapper {
    public abstract ReminderDTO reminderTOReminderDTO(Reminder reminder);

    public abstract List<ReminderDTO> reminderListTOReminderDTOList(List<Reminder> reminder);
}
