package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.dates.DatesDTO;
import com.app.FO.model.dates.Dates;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class DatesDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "datesId", source = "id")
    public abstract DatesDTO datesToDatesDTO(Dates topic);

    public abstract List<DatesDTO> datesListToDatesDTOList(List<Dates> topic);

}
