package com.productapp.productapptask2.mapper;

import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.model.ProductModel;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-25T22:17:17+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductModel toModel(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductModel productModel = new ProductModel();

        productModel.setId( product.getId() );
        productModel.setName( product.getName() );
        productModel.setPrice( product.getPrice() );
        productModel.setCategory( product.getCategory() );

        return productModel;
    }

    @Override
    public Product toEntity(ProductModel product) {
        if ( product == null ) {
            return null;
        }

        Product product1 = new Product();

        product1.setId( product.getId() );
        product1.setName( product.getName() );
        product1.setPrice( product.getPrice() );
        product1.setCategory( product.getCategory() );

        return product1;
    }
}
