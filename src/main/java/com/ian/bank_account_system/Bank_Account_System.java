package com.ian.bank_account_system;

import java.util.ArrayList;
import java.util.List;





/**
 *
 * @author Ian Tagano
 */


class BankAccount
{
    //this line is a static variables, which means it is shared to all instances of the class
    private static int accountNumberCounter = 1000;
    
    //this is the instance variables, which means when this attributes is used in the object it is not shared to other
    //it has unique value depending to the user
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private List<String> transactionHistory;    
  
    
    //Constructor 
    public BankAccount(String holderName, String holderType, double holderBalance)
    {
        this.accountNumber = accountNumberCounter++;
        this.accountHolderName = holderName;
        this.accountType = holderType;
        this.balance = holderBalance;
        this.transactionHistory = new ArrayList<>();
        logTransaction("Account created with the balance: $" + holderBalance);
    }
    
    
    //Methods for deposit and withdrawal
    public void deposit(double amount)
    {
        balance = balance + amount;
        logTransaction("Deposited: $" + amount);
    }
    
    public void withdraw(double amount)
    {
        if(balance >= amount)
        {
            balance = balance - amount;
            logTransaction("Withdrawn: $" + amount);
        }
        else 
        {
            System.out.println("Insufficient Funds, withdrawal not allowed");
        }
    }
    
    //Methods for balance inquiry
    public double checkBalance()
    {
        return balance;
    }
    
    //Methods for transaction history
    public void printTransactionHistory()
    {
        System.out.println("Transaction history for account number: " + accountNumber);
        for(String transaction : transactionHistory)
        {
            System.out.println(transaction);
        }
        
    }
    
    private void logTransaction(String transaction)
    {
        transactionHistory.add(transaction);
    }
}






public class Bank_Account_System 
{

    public static void main(String[] args) 
    {
        do
        {
            
        }
    }
}
