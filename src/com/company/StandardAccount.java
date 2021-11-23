package com.company;

public class StandardAccount implements IAccount {

    private int accountNumber;
    private double creditLimit;
    private double balance;

    public StandardAccount(int accountNumber, double creditLimit) {

        this.accountNumber = accountNumber;
        if (creditLimit > 0) {
            this.creditLimit = 0;
        } else {
            this.creditLimit = creditLimit;
        }

        this.balance = 0;
    }

    @Override
    public void Deposit(double amount) {
        this.balance += amount;

    }

    @Override
    public double Withdraw(double amount) {
        double moneyAvailable = this.balance - this.creditLimit;
        if (amount < moneyAvailable) {
            this.balance -= amount;
            return amount;
        }
        this.balance = 0;
        return moneyAvailable;
    }


    @Override
    public double GetCurrentBalance() {
        return this.balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}
