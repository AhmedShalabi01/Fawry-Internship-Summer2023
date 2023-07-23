/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.online_shop;

/**
 *
 * @author Ahmed Shalaby
 */
public class Order_processing {
    public void placeOrder(Shopping_cart cart)
    {
        System.out.println("------------------------------- Order Details -------------------------------");
        for (Product item: cart.getItems())
        {
            System.out.println(item.getProductN()+" --> "+item.getproductP()+" $" );
        }
        System.out.println("The total cost is : " + cart.getTotalCost());
    }
}
