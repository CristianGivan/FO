package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.address.AddressDTO;
import com.app.FO.model.address.Address;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class AddressDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "addressId", source = "id")
    public abstract AddressDTO addressToAddressDTO(Address topic);

    public abstract List<AddressDTO> addressListToAddressDTOList(List<Address> topic);

}
