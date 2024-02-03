package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.shop.ShopDTO;
import com.app.FO.model.shop.Shop;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class ShopDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "shopId", source = "id")
    public abstract ShopDTO shopToShopDTO(Shop topic);

    public abstract List<ShopDTO> shopListToShopDTOList(List<Shop> topic);

}
