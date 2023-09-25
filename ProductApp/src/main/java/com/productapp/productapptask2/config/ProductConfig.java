package com.productapp.productapptask2.config;
import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.model.ProductModel;
import com.productapp.productapptask2.repo.ProductRepository;
import com.productapp.productapptask2.mapper.ProductMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository repository){
        return args -> {

        };
    }


}
