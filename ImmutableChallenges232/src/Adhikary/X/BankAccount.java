package Adhikary.X;

import Adhikary.dto.Transaction;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

enum AccountType{

    CHECKING("CHECKING"), CURRENT("Current Account"),SAVINGS("Savings Account"),SALARY("Salary Account"),FIXEDDEPOSIT("Fixed Deposit Account"),RECURRINGDEPOSIT("Recurring Deposit Account");

    private final String name;

    AccountType(String name)
    {
        this.name= name;
    }

    @Override
    public String toString()
    {
        return  name;
    }

        }

public class BankAccount {

    private final String bankName;
    private final AccountType accountType ;
    private  BigDecimal  balance ;
    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    public BankAccount(String bankName,AccountType accountType)
    {

        this.bankName = bankName;
        this.accountType = accountType;
        this.balance = BigDecimal.ZERO;
    }
    public BankAccount(String bankName,AccountType accountType,BigDecimal balance)
    {
        this.bankName = bankName;
        this.accountType = accountType;
        this.balance = balance;
    }

    public BankAccount(AccountType accountType,double amount)
    {
        this.bankName ="";
        this.accountType = accountType;
        this.balance = BigDecimal.valueOf(amount);
    }

    public String getBankName()
    {
        return bankName;
    }
    public AccountType getAccountType()
    {
        return accountType;
    }

    public BigDecimal getBalance()// Not necessary to return a new BigDecimal instance since they are immutable .
    {
        return new BigDecimal(balance.toString());
    }

//    public Map<Long,Transaction> getTransactions()
//    {
//        return Collections.unmodifiableMap(transactions);
//    }

    public Map<Long,String> getTransactions()
    {
        Map<Long,String> txMap = new LinkedHashMap<>();
        for(Map.Entry<Long,Transaction> entry : transactions.entrySet())
        {
            txMap.put(entry.getKey(),entry.getValue().toString());
        }
        return txMap;
    }


    @Override
    public String toString()
    {
        return "Bank Name : "+bankName+ "\nAccount Type :" + accountType + " \nBalance : $" + balance +"\n";
    }

    void commitTransaction(int routingNumber, long transactionId, String customerId, double amount)
    {
        balance = balance.add( BigDecimal.valueOf(amount));
        transactions.put(transactionId,new Transaction(routingNumber,transactionId,Integer.parseInt(customerId),amount));
    }

//    protected void addBalance(BigDecimal amount)
//    {
//       balance=  balance.add(amount);
//    }

    // The class and its fields are immutable




}
