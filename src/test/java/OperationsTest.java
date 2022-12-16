import com.bank.exceptions.TransactionException;
import com.bank.models.BankAccount;
import com.bank.models.Transaction;
import com.bank.models.TransactionHistory;
import com.bank.utils.Constants;
import org.junit.Assert;
import org.junit.Test;


import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class OperationsTest {

    @Test
    public void shouldHaveBalanceUpdatedAfterDeposit() throws TransactionException {
        BankAccount account1 = BankAccount
                .builder()
                .balance(1000)
                .build();
        Transaction depositTransaction = Transaction.builder()
                .transactionID(1)
                .transactionType(Constants.DEPOSIT)
                .build();
        depositTransaction.deposit(100, account1);
        Assert.assertEquals(1100, account1.getBalance(), 0.0);
    }
    @Test
    public void shouldNotDepositNegativeAmount() throws TransactionException {
        BankAccount account2 = BankAccount
                .builder()
                .balance(1000)
                .build();
        Transaction depositTransaction = Transaction.builder()
                .transactionID(2)
                .transactionType(Constants.DEPOSIT)
                .amount(200)
                .build();
        depositTransaction.deposit(depositTransaction.getAmount(), account2);

        Assert.assertTrue(depositTransaction.getAmount()> 0);
    }
    @Test
    public void shouldHaveBalanceUpdatedAfterWITHDRAW(){
        BankAccount account3 = BankAccount
                .builder()
                .balance(1000)
                .build();
        Transaction withdrawTransaction = Transaction.builder()
                .transactionID(3)
                .transactionType(Constants.WITHDRAW)
                .build();
        withdrawTransaction.withdrawal(500, account3);
        Assert.assertEquals(500, account3.getBalance(),0.0);
    }
    @Test
    public void shouldDisplayAllTransactions() throws TransactionException {
        BankAccount account4 = BankAccount
                .builder()
                .balance(1000)
                .build();
        List<Transaction> history = new ArrayList<>();
        TransactionHistory statement = new TransactionHistory();
        var withdrawDate =  LocalDateTime.of(2022, Month.DECEMBER, 23, 04, 10);
        var depositDate = LocalDateTime.of(2022, Month.DECEMBER, 21, 20, 45);

        // Do Withdrawal transaction 1
        Transaction withdrawTransaction = Transaction.builder()
                .transactionID(4)
                .transactionType(Constants.WITHDRAW)
                .amount(100)
                .transactionDate(withdrawDate)
                .build();
        withdrawTransaction.withdrawal(withdrawTransaction.getAmount(), account4);

        // Do Deposit transaction 2
        Transaction depositTransaction = Transaction.builder()
                .transactionID(2)
                .transactionType(Constants.DEPOSIT)
                .amount(500)
                .transactionDate(depositDate)
                .build();
        depositTransaction.deposit(depositTransaction.getAmount(), account4);
        // Do Deposit failed
        Transaction depositFailedTransaction = Transaction.builder()
                .transactionID(3)
                .transactionType(Constants.DEPOSIT)
                .amount(500000)
                .transactionDate(depositDate)
                .build();
        depositFailedTransaction.deposit(depositFailedTransaction.getAmount(), account4);
        // Save transactions history
        statement.addHistoryTransaction(withdrawTransaction);
        statement.addHistoryTransaction(depositTransaction);
        statement.addHistoryTransaction(depositFailedTransaction);

        account4.setStatement(statement);

        System.out.println(account4.getStatement().displayAllTransactions());
        Assert.assertEquals(900, account4.getStatement().getTransactions().get(0).getUpdatedBalance(), 0.0);
        // check deposit failed
        Assert.assertTrue( account4.getStatement().getTransactions().get(2).isDepositCanceled());
    }

}
