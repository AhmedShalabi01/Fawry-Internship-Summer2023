package com.productapp.productapptask2.model;

import com.productapp.productapptask2.entity.Category;
import lombok.Data;

@Data
public class ProductModel {

    private int id;
    private String name;
    private double price;
    private Category category;
}
