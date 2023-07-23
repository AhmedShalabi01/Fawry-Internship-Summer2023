/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.online_shop;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Ahmed Shalaby
 */
public class Shopping_cart 
{
    private List <Product> items;
    
    public Shopping_cart()
    {
        this.items=new ArrayList<>();
    }
    
    void addItem(Product product)
    {
        items.add(product);
    }
    void removeItem(Product product)
    {
        items.remove(product);
    }
    
    public double getTotalCost()
    {
        double totalCost = 0;
        for (Product item:items)
        {
            totalCost+=item.getproductP();
        }
        return totalCost;
    }
    
    public List <Product> getItems()
    {
        return items;
    }
    
    
}
