package com.driver;

public class BankAccount {

    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name, double balance, double minBalance) {
        this.name=name;
        this.balance=balance;
        this.minBalance=minBalance;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception{
        //Each digit of an account number can lie between 0 and 9 (both inclusive)
        //Generate account number having given number of 'digits' such that the sum of digits is equal to 'sum'
        //If it is not possible, throw "Account Number can not be generated" exception
        //digits=4 sum=23 acc number=9950
        if((digits*9)<sum)
            throw new Exception("Account Number can not be generated");
        String ans="";
        int digit=9;
        for(int i=0;i<digits;i++){
            if(sum>=digit)
            {
                ans+=digit;
                sum-=digit;
            }
            else
            {
                digit=sum;
                ans+=digit;
                sum-=digit;
            }
        }
        return ans;
    }

    public void deposit(double amount) {
        //add amount to balance
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception {
        // Remember to throw "Insufficient Balance" exception, if the remaining amount would be less than minimum balance
        if(balance-amount<minBalance)
            throw new Exception("Insufficient Balance");
        else
            balance-=amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }
}