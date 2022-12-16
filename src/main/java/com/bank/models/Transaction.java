package com.bank.models;

import com.bank.exceptions.TransactionException;
import com.bank.utils.Constants;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@ToString
public class Transaction implements IBankTransaction{

    @Getter
    @Setter
    private Integer transactionID;

    @Getter
    @Setter
    private String transactionType;

    @Getter
    @Setter
    private double amount;

    @Getter
    @Setter
    private double updatedBalance;

    @Getter
    @Setter
    private LocalDateTime transactionDate;

    @Getter
    @Setter
    private String comment;
    @Getter
    @Setter
    private boolean isDepositCanceled;
    @Getter
    @Setter
    private boolean isWithdrawalCanceled;

    @Override
    public void deposit(double amount, BankAccount account) throws TransactionException {
        if(amount > 0 && amount <= 2000){
            account.setBalance(account.getBalance() + amount);
            setUpdatedBalance(account.getBalance());
        }else{
            setComment(Constants.FAILED_TRANSACTION_DEPOSIT);
            isDepositCanceled = true;
        }
    }
    @Override
    public void withdrawal(double amount,BankAccount account) {

        if((account.getBalance()-amount) >= account.getMinBalanceAuthorized()){
            account.setBalance(account.getBalance() - amount);
            setUpdatedBalance(account.getBalance());
        }else{
            setComment(Constants.FAILED_TRANSACTION_WITHDRAWAL);
            isWithdrawalCanceled = true;
        }

    }
}
