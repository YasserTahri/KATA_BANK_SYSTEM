package com.bank.models;

import com.bank.exceptions.TransactionException;

public interface IBankTransaction {

    void deposit(double amount, BankAccount account) throws TransactionException;
    void withdrawal(double amount, BankAccount account);
}
