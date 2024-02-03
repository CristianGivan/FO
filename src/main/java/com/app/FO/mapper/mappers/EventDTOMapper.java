package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.event.EventDTO;
import com.app.FO.model.event.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class EventDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "eventId", source = "id")
    public abstract EventDTO eventToEventDTO(Event topic);

    public abstract List<EventDTO> eventListToEventDTOList(List<Event> topic);

}
