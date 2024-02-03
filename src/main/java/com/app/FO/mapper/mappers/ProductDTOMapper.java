package com.app.FO.mapper.mappers;

import com.app.FO.mapper.dto.product.ProductDTO;
import com.app.FO.model.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", uses = {UserDTOMapper.class})
public abstract class ProductDTOMapper {
    @Autowired
    protected UserDTOMapper userDTOMapper;

    @Mapping(target = "productId", source = "id")
    public abstract ProductDTO productToProductDTO(Product topic);

    public abstract List<ProductDTO> productListToProductDTOList(List<Product> topic);

}
