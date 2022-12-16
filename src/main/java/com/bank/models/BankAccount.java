package com.bank.models;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
public class BankAccount {


    @Getter
    @Setter
    private double balance;
    /*
     *  authorized minimum balance
     */
    @Getter
    @Setter
    private double minBalanceAuthorized;
    @Getter
    @Setter
    private TransactionHistory statement;

    public BankAccount(double balance, double minBalanceAuthorized, TransactionHistory statement) {
        this.balance = balance;
        this.minBalanceAuthorized = -100;
        this.statement = statement;
    }


}
