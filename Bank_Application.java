/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.bank_application;

import java.util.Scanner;

/**
 *
 * @author Ahmed Shalaby
 */
public class Bank_Application {
    
    static int startofAccountsNummbers=100000;
    static int startofSavingAccountsNummbers=200000;

    public static void main(String[] args) {
        
        Bank bank=new Bank(200);
        Scanner scanner= new Scanner(System.in);
        
        while(true)
        {
        System.out.println("Welcome to the Bank");
        System.out.println("Please chose one of the options");
        System.out.println("0: Exit");
        System.out.println("1: Open New Account");
        System.out.println("2: Deposit");
        System.out.println("3: Withdraw");
        System.out.println("4: Check Balance");
        System.out.println("5: Open Saving Account");
        System.out.println("6: Check Interest Balance");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch(choice){
            case 0:
                System.out.println("Exiting the Application");
                System.exit(choice);
                
            case 1:
                int accountNumber = generateAccountNumber();
                System.out.println("Plese enter the account holder Name.");
                String accountHolderName = scanner.nextLine();
                while (!OnlyLetters(accountHolderName)) {
                    System.out.println("Invalid account holder name. Please enter only letters.");
                    System.out.print("Enter account holder name: ");
                    accountHolderName = scanner.nextLine();
                }
                bank.addNewAccount(new Account(accountHolderName,accountNumber));
                break;
                
            case 2:
                accountNumber = read_val(scanner,"Plese enter the account Number");
                double addedBalnace = read_val(scanner,"Please enter the amount to deposit.");
                bank.deposit(accountNumber, addedBalnace);
                break;
                
            case 3:
                accountNumber = read_val(scanner,"Plese enter the account Number");
                double withdrawalBalance = read_val(scanner,"Please enter the amount to withdraw.");
                bank.withdraw(accountNumber, withdrawalBalance);
                break;
                
            case 4:
                accountNumber = read_val(scanner,"Plese enter the account Number");
                bank.displayBalance(accountNumber);
                break;
            
            case 5:
                int savingaAcountNumber = read_val(scanner,"Plese enter the account Number");
                accountHolderName = bank.searchAccountName(savingaAcountNumber);
                while (!OnlyLetters(accountHolderName)) {
                    System.out.println("Invalid account holder name. Please enter only letters.");
                    System.out.print("Enter account holder name: ");
                    accountHolderName = scanner.nextLine();
                }
                double initialbalance = read_val(scanner,"Plese enter the opening balance.");
                float interest_rate = read_rate(scanner,"Plese enter the interest rate.");
                bank.addsavingAccount(new Saving_Account(accountHolderName,savingaAcountNumber,initialbalance,interest_rate));
                break;
            
            case 6:
                accountNumber = read_val(scanner,"Plese enter the account Number");
                int period = read_val(scanner,"Plese enter the time period");
                bank.displayInterast(accountNumber,period);
                break;
                          
            default:
                System.out.println("Error in entering the choice, please try again"); 
                
                
        }       
    }
    }
    
    public static int read_val(Scanner stdin, String prompt){
        int i=-1;
        
        while(i<0)
        {
            System.out.println(prompt);
            String input=stdin.nextLine();
            
            try
            {
                i=Integer.valueOf(input);
            }
            
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a valid input.");
                i=-1;
            }
        }
        return i;
    }
    public static float read_rate(Scanner stdin, String prompt){
        float i=-1;
        
        while(i<0)
        {
            System.out.println(prompt);
            String input=stdin.nextLine();
            
            try
            {
                i=Float.valueOf(input);
            }
            
            catch(NumberFormatException e)
            {
                System.out.println("Please enter a valid input.");
                i=-1;
            }
        }
        return i;
    }
    
    public static boolean OnlyLetters(String input) 
    {
        return input.matches("[a-zA-Z ]+");
    }
            
    static int generateAccountNumber() {
        return startofAccountsNummbers++;
    }
    
}
