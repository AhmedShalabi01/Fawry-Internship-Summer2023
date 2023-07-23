/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.online_shop;

/**
 *
 * @author Ahmed Shalaby
 */
public class Online_Shop {

    public static void main(String[] args) {
        Product pro1=new Product("Casio calculator fx-991ex",350.5);
        Product pro2=new Product("Casio watch ltp 1308d analog, metallic",1859.5);
        Product pro3=new Product("Casio ctk-1500 61-key piano look keyboard, black",5548.34);
        
        Shopping_cart cart = new Shopping_cart();
        
        cart.addItem(pro1);
        cart.addItem(pro2);
        cart.addItem(pro3);
        
        Order_processing order =new Order_processing();
        order.placeOrder(cart);
        
        
    }
}
