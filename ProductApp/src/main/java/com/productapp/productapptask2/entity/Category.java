package com.productapp.productapptask2.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "category_id")
    private int categoryId;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "category",cascade = CascadeType.ALL)
    private List<Product> products;

}