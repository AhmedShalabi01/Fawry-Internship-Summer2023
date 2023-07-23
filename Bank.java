/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bank_application;

/**
 *
 * @author Ahmed Shalaby
 */
public class Bank {
    Account[] accounts;
    Saving_Account[] savingAccounts;
    int accountNum,savingaccountNum;
    
    Bank(int numAccounts)
    {
        accountNum=0;
        savingaccountNum=0;
        accounts = new Account[numAccounts];
        savingAccounts = new Saving_Account[numAccounts];
    }
    
    void addNewAccount(Account account)
    {
        if (accountNum<accounts.length)
        {
            accounts[accountNum]=account;
            accountNum++;
        }
        else
            System.out.println("Sorry,the number of accounts has reached the maximum");
    }
    void addsavingAccount(Saving_Account savingaccount)
    {
        if (savingaccountNum<savingAccounts.length)
        {
            savingAccounts[savingaccountNum]=savingaccount;
            savingaccountNum++;
        }
        else
            System.out.println("Sorry,the number of accounts has reached the maximum");
    }
    
    void deposit(int accountNum,double balance)
    {
        Account account=searchAccount(accountNum);
        
        if (account!=null)
        {
            account.deposit(balance);
        }
        else
            System.out.println("Sorry, the Account Number is not found!");
        
    }
    
    void withdraw(int accountNum,double balance)
    {
        Account account=searchAccount(accountNum);
        
        if (account!=null)
        {
            account.withdraw(balance);
        }
        else 
            System.out.println("Sorry, the Account Number is not found!");
    }
    
    void displayBalance(int accountNum)
    {
        Account account=searchAccount(accountNum);
        
        if (account!=null)
        {
            System.out.println("The account number :" + accountNum +" has a balance of : "+account.getBalance());
        }
        else
            System.out.println("Sorry, the Account Number is not found!");
    }
    void displayInterast(int accountNum,int time_period)
    {
        Saving_Account savingaccount=searchSavingAccount(accountNum);
        
        if (savingaccount!=null)
        {
            System.out.println("The account number :" + accountNum +" after this period "+time_period+"would have balance of "+savingaccount.interest(time_period));
        }
        else
            System.out.println("Sorry, the Account Number is not found!");
    }
    
    Account searchAccount(int accountNums)
    {
         for(int i=0; i<accountNum;i++)
        {
            if (accounts[i].getAccountNumber() == accountNums)
            {
                return accounts[i];
            }
        }
         return null;
    }
    
    String searchAccountName(int accountNums)
    {
         for(int i=0; i<accountNum;i++)
        {
            if (accounts[i].getAccountNumber() == accountNums)
            {
                return accounts[i].getAccountName();
            }
        }
         return null;
    }
    
    Saving_Account searchSavingAccount(int accountNums)
    {
         for(int i=0; i<accountNum;i++)
        {
            if (savingAccounts[i].getAccountNumber() == accountNums)
            {
                return savingAccounts[i];
            }
        }
         return null;
    }
    
}
