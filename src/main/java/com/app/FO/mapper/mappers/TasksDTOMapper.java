package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.tasks.TasksDTO;
import com.app.FO.model.tasks.Tasks;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class TasksDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "tasksId", source = "id")
    public abstract TasksDTO tasksToTasksDTO(Tasks topic);

    public abstract List<TasksDTO> tasksListToTasksDTOList(List<Tasks> topic);

}
