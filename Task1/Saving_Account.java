/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_application;

/**
 *
 * @author Ahmed Shalaby
 */
public class Saving_Account extends Account{
    float interestRate;
    double initialbalance;
    double balance;
  
    public Saving_Account(String account_hlod, int account_num,double initialbalance,float interestRate) {
        super(account_hlod, account_num);
        this.interestRate = interestRate;
        this.initialbalance=initialbalance;
    }
    
    double interest(int time_period)
    {
       return initialbalance * interestRate * time_period ;
    }

}
