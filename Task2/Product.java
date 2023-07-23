/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.online_shop;

/**
 *
 * @author Ahmed Shalaby
 */
public class Product
{
    String productName;
    double productPrice;
    
    public Product(String productN,double productP )
    {
        this.productName=productN;
        this.productPrice = productP;
    }
    
    public String getProductN()
    {
        return productName;
    }
    
    public double getproductP()
    {
        return productPrice;
    }         
}
