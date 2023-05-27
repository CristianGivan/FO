package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.task.TaskDTO;
import com.app.FO.model.task.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class TaskDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "taskId", source = "id")
    public abstract TaskDTO taskToTaskDTO(Task topic);

    public abstract List<TaskDTO> taskListToTaskDTOList(List<Task> topic);

}
