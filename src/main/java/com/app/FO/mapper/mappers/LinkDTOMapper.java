package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.link.LinkDTO;
import com.app.FO.model.link.Link;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class LinkDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "linkId", source = "id")
    public abstract LinkDTO linkToLinkDTO(Link topic);

    public abstract List<LinkDTO> linkListToLinkDTOList(List<Link> topic);

}
