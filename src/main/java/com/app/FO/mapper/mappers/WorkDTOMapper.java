package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.work.WorkDTO;
import com.app.FO.model.work.Work;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class WorkDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "workId", source = "id")
    public abstract WorkDTO workToWorkDTO(Work work);

    public abstract List<WorkDTO> workListToWorkDTOList(List<Work> works);

}
