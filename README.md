Bank account kata
=================

Think of your personal bank account experience. When in doubt, go for the simplest solution Requirements.

Goal
=================
1. Deposit and Withdrawal
2. Account statement (date, amount, balance)
3. Statement printing

User Stories
=================

US 1:

    In order to save money
    As a bank client
    I want to make a deposit in my account

US 2:

    In order to retrieve some or all of my savings
    As a bank client
    I want to make a withdrawal from my account

US 3:

    In order to check my operations
    As a bank client
    I want to see the history (operation, date, amount, balance) of my operations

Tests
=================

Statement printing: 

My Transactions

Transaction type: Withdrawal -  Date: 2022-12-23 04:10

amount: 100.0

Balance: 900.0

********************************************************************** 
Transaction type: Deposit -  Date: 2022-12-21 20:45

amount: 500.0

Balance: 1400.0

********************************************************************** 
Transaction type: Deposit - 2022-12-21 20:45

Comment: DEPOSIT FAILED !

********************************************************************** 

[Unit tests](https://github.com/YasserTahri/KATA_BANK_SYSTEM/blob/master/src/test/java/OperationsTest.java)
