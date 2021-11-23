package com.company;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {

    private List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<IAccount>();
    }


    @Override
    public void OpenAccount(IAccount account) {
        boolean found = false;
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetAccountNumber() == account.GetAccountNumber()) {
                found = true;
            }
        }

        if (!found) {
            this.accounts.add(account);
        }
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetAccountNumber() == accountNumber) {
                if (this.accounts.get(i).GetCurrentBalance() >= 0) {
                    this.accounts.remove(i);
                } else {
                    System.out.println("You cant close this account due to a debt");
                }
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }

    @Override
    public List<IAccount> GetAllAccountInDebt() {
        List<IAccount> accountInDebt = new ArrayList<IAccount>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() < 0) {
                accountInDebt.add(this.accounts.get(i));
            }
        }
        return accountInDebt;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsNotInDebt = new ArrayList<IAccount>();
        for (int i = 0; i < this.accounts.size(); i++) {
            if (this.accounts.get(i).GetCurrentBalance() > balanceAbove) {
                accountsNotInDebt.add(this.accounts.get(i));
            }
        }
        return accountsNotInDebt;
    }
}