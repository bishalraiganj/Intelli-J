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

    private final String bankName;
    private final AccountType accountType ;
    private final BigDecimal  balance ;

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

    @Override
    public String toString()
    {
        return "Bank Name : "+bankName+ "\nAccount Type :" + accountType + " \nBalance : " + balance +"\n";
    }

//    protected void addBalance(BigDecimal amount)
//    {
//       balance=  balance.add(amount);
//    }

    // The class and its fields are immutable




}
