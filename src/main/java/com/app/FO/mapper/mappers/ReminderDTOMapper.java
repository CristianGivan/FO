package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.model.reminder.Reminder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReminderDTOMapper {
    public abstract ReminderDTO ReminderTOReminderDTO(Reminder reminder);

    public abstract List<ReminderDTO> ReminderListTOReminderDTOList(List<Reminder> reminder);
}
