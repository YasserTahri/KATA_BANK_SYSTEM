package com.bank.models;

import com.bank.utils.Constants;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    @Getter
    @Setter
    private List<Transaction> transactions;

    public TransactionHistory() {
       this.transactions = new ArrayList<>();
    }
    public void addHistoryTransaction(Transaction transaction){
        transactions.add(transaction);

    }
    public String displayAllTransactions(){

         StringBuilder sb = new StringBuilder();
         sb.append(" ============================== My Transactions ============================== \n");
         for(Transaction transaction : transactions){
             show(transaction, sb);
         }
        return sb.toString();
    }

    private void show(Transaction transaction, StringBuilder sb){
        if(transaction.isDepositCanceled()){
            sb.append("Transaction type: "+transaction.getTransactionType() +" - " +  transaction.getTransactionDate().toString().replace("T", " ")+ "\n" +"Comment: " +Constants.FAILED_TRANSACTION_DEPOSIT +"\n")
                    .append("====================================================================== \n");
        }else if(transaction.isWithdrawalCanceled()){
            sb.append("Transaction type: "+transaction.getTransactionType() +" - " +  transaction.getTransactionDate().toString().replace("T", " ") + "\n" +"Comment: " +Constants.FAILED_TRANSACTION_WITHDRAWAL +"\n")
                    .append("====================================================================== \n");;
        }else{
            sb.append(
                    "Transaction type: "+transaction.getTransactionType() + " -  Date: "+transaction.getTransactionDate().toString().replace("T", " ")+"\n"+
                    "amount: " +transaction.getAmount() +"\n"+
                    "Balance: " +transaction.getUpdatedBalance()+"\n")
                    .append("====================================================================== \n");
        }
    }
}
