package com.productapp.productapptask2.repository;

import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.repo.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
@ActiveProfiles("testdb")
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    void setup(){
        product = new Product();
        product.setName("IPhone 15 ");
        product.setPrice(90000);
        productRepository.save(product);
    }

    @Test
    public void productRepository_SaveAll_ReturnSavedProduct(){

        Product savedProduct = productRepository.save(product);

        Assertions.assertThat(savedProduct).isNotNull();
        Assertions.assertThat(savedProduct.getId()).isGreaterThan(0);
    }

    @Test
    public void productRepository_GetAll_ReturnMoreThanOneProduct(){

        Product product2 = new Product();
        product2.setName("IPhone 16 ");
        product2.setPrice(60000);
        productRepository.save(product2);

        List<Product> products = productRepository.findAll();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);
    }

    @Test
    public void productRepository_DeleteById_ReturnNothing(){

        Product product2 = new Product();
        product2.setName("IPhone 16 ");
        product2.setPrice(60000);
        productRepository.save(product2);

        productRepository.deleteById(product.getId());

        List<Product> products = productRepository.findAll();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(1);
    }

    @Test
    public void productRepository_UpdateProduct_ReturnNothing(){

        product.setName("IPhone 16");
        product.setPrice(70000);

        productRepository.save(product);

        Assertions.assertThat(product).isNotNull();
        Assertions.assertThat(product.getName()).isEqualTo("IPhone 16");
        Assertions.assertThat(product.getPrice()).isEqualTo(70000);
    }

    @Test
    public void productRepository_GetProductByIdOrName_ReturnListOfProducts(){

        Product product2 = new Product();
        product2.setName("IPhone 16 ");
        product2.setPrice(60000);
        productRepository.save(product2);
        List<Product> products = productRepository
                .findAll()
                .stream()
                .filter(productFind -> productFind.getName().contains("1") || String.valueOf(productFind.getId()).contains("1"))
                .toList();

        Assertions.assertThat(products).isNotNull();
        Assertions.assertThat(products.size()).isEqualTo(2);
    }
}
