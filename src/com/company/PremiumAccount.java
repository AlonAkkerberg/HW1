package com.company;

public class PremiumAccount implements IAccount {

    private double balance;
    private int accountNumber;

    public PremiumAccount(int accountNumber) {

        this.accountNumber = accountNumber;
        this.balance = 0;

    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;


    }


    @Override
    public double Withdraw(double amount) {
        this.balance -= amount;
        return amount;

    }

    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return this.accountNumber;
    }
}
