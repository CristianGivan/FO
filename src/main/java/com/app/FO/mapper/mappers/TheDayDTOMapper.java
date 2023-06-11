package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.theDay.TheDayDTO;
import com.app.FO.model.theDay.TheDay;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class TheDayDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "theDayId", source = "id")
    public abstract TheDayDTO theDayToTheDayDTO(TheDay topic);

    public abstract List<TheDayDTO> theDayListToTheDayDTOList(List<TheDay> topic);

}
