package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.reminder.ReminderDTO;
import com.app.FO.model.reminder.Reminder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReminderDTOMapper {
    @Mapping(target = "reminderId", source = "id")
    public abstract ReminderDTO reminderToReminderDTO(Reminder reminder);

    public abstract List<ReminderDTO> reminderListToReminderDTOList(List<Reminder> reminder);
}
