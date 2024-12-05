package Adhikary.X;

import java.math.BigDecimal;

enum AccountType{

    CURRENT("Current Account"),SAVINGS("Savings Account"),SALARY("Salary Account"),FIXEDDEPOSIT("Fixed Deposit Account"),RECURRINGDEPOSIT("Recurring Deposit Account");

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

    private  AccountType accountType ;
    private BigDecimal  balance =new BigDecimal("0.0");

    public BankAccount(AccountType accountType)
    {
        this.accountType = accountType;
    }
    public BankAccount(AccountType accountType,BigDecimal balance)
    {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType()
    {
        return accountType;
    }

    public BigDecimal getBalance()// Not necessary to return a new BigDecimal instance since they are immutable .
    {
        return new BigDecimal(balance.toString());
    }

    protected void addBalance(BigDecimal amount)
    {
       balance=  balance.add(amount);
    }

    // Untested




}
