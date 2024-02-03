package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.snooze.SnoozeDTO;
import com.app.FO.model.snooze.Snooze;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class SnoozeDTOMapper {
    @Mapping(target = "snoozeId", source = "id")
    public abstract SnoozeDTO snoozeToSnoozeDTO(Snooze snooze);

    public abstract List<SnoozeDTO> snoozeListToSnoozeDTOList(List<Snooze> snooze);
}
