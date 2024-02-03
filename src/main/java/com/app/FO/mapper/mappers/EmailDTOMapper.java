package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.email.EmailDTO;
import com.app.FO.model.email.Email;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class EmailDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "emailId", source = "id")
    public abstract EmailDTO emailToEmailDTO(Email topic);

    public abstract List<EmailDTO> emailListToEmailDTOList(List<Email> topic);

}
