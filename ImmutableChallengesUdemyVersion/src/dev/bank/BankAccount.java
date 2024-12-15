package dev.bank;

import dev.dto.Transaction;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {



    public enum AccountType{CHECKING,SAVINGS}

    private final AccountType accountType;
    private  double balance;

    private final Map<Long, Transaction> transactions ;

    BankAccount(AccountType accountType,double balance)
    {
        this.accountType = accountType;
        this.balance = balance;
        transactions = new LinkedHashMap<>();
    }

    BankAccount(AccountType accountType,double balance, Map<Long,Transaction> transactions)
    {
        this.accountType = accountType;
        this.balance = balance;
        this.transactions = new LinkedHashMap<>(transactions);
    }

    public AccountType getAccountType()
    {
        return accountType;
    }

    public Map<Long,Transaction> getTransactions()
    {
        return Collections.unmodifiableMap(transactions);
    }

    protected void commitTransaction(int routingNumber,long transactionId,String customerId, double transactionAmount)
    {
        Transaction transaction = new Transaction(routingNumber, Integer.parseInt(customerId),transactionId,transactionAmount);
        transactions.put(transactionId,transaction);

    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    @Override
    public String toString()
    {
        return "%s $%.2f".formatted(accountType,balance);
    }



}
