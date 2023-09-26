package com.productapp.productapptask2.service;

import com.fasterxml.jackson.annotation.OptBoolean;
import com.productapp.productapptask2.entity.Category;
import com.productapp.productapptask2.entity.Product;
import com.productapp.productapptask2.mapper.ProductMapper;
import com.productapp.productapptask2.model.ProductModel;
import com.productapp.productapptask2.repo.CategoryRepository;
import com.productapp.productapptask2.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductMapper productMapper;

    private ProductModel productModel;

    public List<ProductModel> getProducts(){
        return productRepository.findAll()
                .stream()
                .map(product-> productMapper
                .toModel(product))
                .collect(Collectors.toList());
    }

    public List<ProductModel> getProductsByIdOrName(String item){
        return productRepository
                .findAll()
                .stream()
                .map(product-> productMapper.toModel(product))
                .filter(product -> product.getName()
                .contains(item) ||
                String.valueOf(product.getId())
                .contains(item)).collect(Collectors.toList());
    }

    public void addNewProduct(String name,double price, int categoryType,int quantity){

        if ( name == null || name.isEmpty() ){
            throw new IllegalStateException("The name is Invalid");
        }
        if ( price <= 0 || quantity < 0 ){
            throw new IllegalStateException("The Price is Invalid only values greater than zero");
        }
        if( categoryType < 1 || categoryType > 6 ){
            throw new IllegalStateException("The Category is Invalid only from 1 to 6");
        }

        Category category = categoryRepository.findById(categoryType).get();

        productModel = new ProductModel();
        productModel.setName(name);
        productModel.setPrice(price);
        productModel.setCategory(category);
        productModel.setQuantity(quantity);

        Product product = productMapper.toEntity(productModel);
        productRepository.save(product);
    }
    @Transactional
    public void deleteProduct(int productId){

        productRepository.findById(productId)
                .orElseThrow(()->  new IllegalStateException("The Product with ID : "+ productId +" does not exist"));

        productRepository.deleteById(productId);
    }

    @Transactional
    public void updateProduct(int productId, String name, double price,int quantity) {

        if (name==null || name.isEmpty()){
            throw new IllegalStateException("The name is Invalid");
        }
        if (price<=0 || quantity < 0){
            throw new IllegalStateException("The Price is Invalid only values greater than zero");
        }

        Product product = productRepository.findById(productId)
                    .orElseThrow(()->  new IllegalStateException("The Product with ID : "+ productId +" does not exist"));

        productModel = productMapper.toModel(product);

        productModel.setName(name);
        productModel.setPrice(price);
        productModel.setQuantity(quantity);

        product = productMapper.toEntity(productModel);
        productRepository.save(product);

    }
}
