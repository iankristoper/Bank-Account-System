

package com.ian.bank_account_system;

/**
 *
 * @author Ian Tagano
 */


public class bankAccount
{
    
    private static int accountNumberCounter = 1000;
    
    private int accountNumber;
    private String accountHolderName;
    private String accountType;
    private double balance;
    private List<String> transactionHistory;    
    
    public bankAccount(String holderName, String holderType, double holderBalance)
    {
        this.accountNumber = accountNumberCounter++;
    }
}



public class Bank_Account_System 
{

    public static void main(String[] args) 
    {
        
    }
}
