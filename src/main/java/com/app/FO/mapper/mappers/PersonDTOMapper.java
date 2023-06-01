package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.person.PersonDTO;
import com.app.FO.model.person.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class PersonDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "personId", source = "id")
    public abstract PersonDTO personToPersonDTO(Person topic);

    public abstract List<PersonDTO> personListToPersonDTOList(List<Person> topic);

}
