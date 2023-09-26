package com.productapp.productapptask2.mapper;

import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductModel toModel(final Product product);

    Product toEntity(final ProductModel product);
}
