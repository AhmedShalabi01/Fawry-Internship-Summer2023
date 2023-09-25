package com.productapp.productapptask2.service;


import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.mapper.ProductMapper;
import com.productapp.productapptask2.model.ProductModel;
import com.productapp.productapptask2.repo.ProductRepository;
import com.productapp.productapptask2.service.ProductService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

public class ProductServiceTests {

    @Mock
    private ProductRepository productRepository;

    private Product product;
    private ProductModel productModel;

    private ProductService productService;

    private String name;
    private int price;

    private int category;

    @BeforeEach
    void setup(){
        productService = new ProductService();
    }

    @Test
    public void productService_AddProductWithInvalidName_ReturnNothing(){

        name = "";
        price = 90000;
        category = 1;

        assertThatThrownBy(() -> productService.addNewProduct(name,price,category))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("The name is Invalid");
    }

    @Test
    public void productService_AddProductWithInvalidPrice_ReturnNothing(){

        name = "Test";
        price = -90000;
        category = 1;

        assertThatThrownBy(() -> productService.addNewProduct(name,price,category))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("The Price is Invalid only values greater than zero");
    }

    @Test
    public void productService_AddProductWithInvalidCategory_ReturnNothing(){

        name = "Test";
        price = 90000;
        category = 7;

        assertThatThrownBy(() -> productService.addNewProduct(name,price,category))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("The Category is Invalid only from 1 to 6");
    }
}
