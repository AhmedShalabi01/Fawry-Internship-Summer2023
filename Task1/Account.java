/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_application;

/**
 *
 * @author Ahmed Shalaby
 */
public class Account
{
    String accountHolderName;
    int accountNumber;
    double balance;
    public Account(String accountHolderName, int accountNumber)
    {
        this.accountNumber=accountNumber;
        this.accountHolderName=accountHolderName;
        balance=2500;
        System.out.println("Account opened successfully! Account number: " + accountNumber);
    }
    
    double getBalance()
    {
        return balance;
    }
            
    void deposit(double added_balance)
    {
        if (added_balance<=0)
        {
            System.out.println("Sorry, the amount needs to be larger than zero.");
        }
        else
        {   balance += added_balance;
            System.out.println("The amount has been deposited successfully.");  
            System.out.println("The new balance : " + balance);
        }    
    }
    
    void withdraw(double withdrawn_balance)
    {
        if (balance<=0)
        {
            System.out.println("The account has a zero balance, so no withdrawal can be applied.");
        }
        
        else if (withdrawn_balance<=0)
        {
            System.out.println("Sorry, the amount needs to be larger than zero.");
        }
        
        else if (withdrawn_balance> balance)
        {
            System.out.println("Sorry, your account does not have enough money to withdraw this amount.");
        }

        else
        {
            balance -= withdrawn_balance;
            System.out.println("The amount has been withdrawn successfully.");
            System.out.println("The new balance : "+ balance);
        }
    }
    int getAccountNumber()
    {
        return accountNumber;
    }
    String getAccountName()
    {
        return accountHolderName;
    }
    
}
