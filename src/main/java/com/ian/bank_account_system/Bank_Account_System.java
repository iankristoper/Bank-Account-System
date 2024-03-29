package com.ian.bank_account_system;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





/**
 *
 * @author Ian Tagano
 */


class BankAccount
{
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
        this.accountNumber = AccountManager.generateAccountNumber();
        this.accountHolderName = holderName;
        this.accountType = holderType;
        this.balance = holderBalance;
        this.transactionHistory = new ArrayList<>();
        logTransaction("Account created with the balance: $" + holderBalance);
    }
    
    
    //Methods for deposit and withdrawal
    //It is in public, so that outside class can access to this methods
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
    //It is in public, so that outside class can access to this methods
    public double checkBalance()
    {
        return balance;
    }
    
    
    //Transcation log, this method is responsible for logging a transaction in the transaction history list
    //making it private so that only methods inside the BankAccount class can directly and transaction to the 
    //transaction history
    private void logTransaction(String transaction)
    {
        transactionHistory.add(transaction);
    }
    
    public List<String> printTransactionHistory() 
    {
        return transactionHistory;
    }
    
    public int getAccountNumber()
    {
        return accountNumber;
    }
    
    public String getAccountHolderName()
    {
        return accountHolderName;
    }
    
    public String getAccountType()
    {
        return accountType;
    }
}


class AccountManager
{
    //this line is a static variables, which means it is shared to all instances of the class
    private static int accountNumberCounter = 1000;
    
    //private static  -> it is only accessible within this class, and not available for instantiation 
    //new ArrayList<> -> initialized and empty arraylist
    private static List<BankAccount> accounts = new ArrayList<>();  //static variable named accounts of type List<BankAccount>
    private static Scanner scanner = new Scanner(System.in);   //static variable named scanned of type Scanner
    
    
    //methods for creating account
    public static void createAccount()
    {
        System.out.println("Enter your name: ");
        String holderName = scanner.next();
        System.out.println("Enter account type: ");
        String accountType = scanner.next();
        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();
        
        BankAccount create_account = new BankAccount(holderName, accountType, initialBalance);
        accounts.add(create_account);
        
        System.out.println("Account created successfully!");
        System.out.println("Account number: " + create_account.getAccountNumber());
        
    }
    
    
    //methods for performing transaction
    public static void performTransaction(String transactionType)
    {
        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();
        
        BankAccount account = findAccount(accountNumber);
        
        if(account != null)
        {
            System.out.println("Enter amount to " + transactionType + ": ");
            double amount = scanner.nextDouble();
            
            if(transactionType.equals("deposit"))
            {
                account.deposit(amount);
            }
            else if(transactionType.equals("withdraw"))
            {
                account.withdraw(amount);
            }
            else
            {
                System.out.println("Account not found!");
            }
            
        }
        
        
    }
    
    public static void checkBalance()
    {
        System.out.println("Enter bank account number: ");
        int accountNumber = scanner.nextInt();
        
        BankAccount account = findAccount(accountNumber);
        if(account != null)
        {
            System.out.println("Account holder: " + account.getAccountHolderName());
            System.out.println("Account balance: " + account.checkBalance());
        }
        else 
        {
            System.out.println("Account not found!");
        }
    }
    
    public static void printTransactionHistory()
    {
        System.out.println("Enter bank account number: ");
        int accountNumber = scanner.nextInt();
        
        BankAccount account = findAccount(accountNumber);
        if(account != null)
        {
            List<String> transactions = account.printTransactionHistory();
            System.out.println("Transaction history for account numebr " + account.getAccountNumber());
            for(String transaction : transactions)
            {
                System.out.println(transaction);
            }
        }
        else 
        {
            System.out.println("Account not found!");
        }
    }
    
    
    
    
    //
    private static BankAccount findAccount(int accountNumber)
    {
        for(BankAccount account : accounts)
        {
            if(account.getAccountNumber() == accountNumber)
            {
                return account;
            }
        }
        
        return null;
    }
    
    
    public static int generateAccountNumber()
    {
        return accountNumberCounter++;
    }
}




public class Bank_Account_System 
{
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) 
    {
        int choice;
        
        do
        {
            System.out.println("\nBank Account System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            
            switch(choice)
            {
                case 1: AccountManager.createAccount();
                break;
                
                case 2: AccountManager.performTransaction("deposit");
                break;
                
                case 3: AccountManager.performTransaction("withdraw");
                break;
                
                case 4: AccountManager.checkBalance();
                break;
                
                case 5: AccountManager.printTransactionHistory();
                break;
                
                case 6: System.out.println("Exiting the Bank Account System. Goodbye!"); 
                break;
                
                default: System.out.println("Invalid choice, please try again!");
                break;    
            }        
        } while(choice != 6);
    }
}
