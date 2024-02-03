package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.phoneNumber.PhoneNumberDTO;
import com.app.FO.model.phoneNumber.PhoneNumber;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class PhoneNumberDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "phoneNumberId", source = "id")
    public abstract PhoneNumberDTO phoneNumberToPhoneNumberDTO(PhoneNumber topic);

    public abstract List<PhoneNumberDTO> phoneNumberListToPhoneNumberDTOList(List<PhoneNumber> topic);

}
