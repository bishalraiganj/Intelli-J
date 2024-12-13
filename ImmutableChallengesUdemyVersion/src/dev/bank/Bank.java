package dev.bank;

import dev.dto.Transaction;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    private final int routingNumber;
    private static long lastTransactionId=0;
    private final Map<String,BankCustomer> customers;

    public Bank(int routingNumber,Map<String,BankCustomer> customers)
    {
        this.routingNumber = routingNumber;
        this.customers = new LinkedHashMap<> (customers);
    }

    public Bank(int routingNumber)
    {
        this.routingNumber = routingNumber;
        this.customers = new LinkedHashMap<> ();
    }

//    public BankCustomer getCustomer(String id) // immutable version of getCustomer with defensive coding , BUT this new returned BankCustomer instance  doesnt copy or have all the nested fields
//    {
//        BankCustomer customer = customers.get(id);
//        List<BankAccount> accounts  = customer.getAccounts();
//        final double checkingAmount ;
//        final double savingsAmount ;
//        double tempCheckingAmount =0.0;
//        double tempSavingsAmount = 0.0;
//        for(BankAccount account : accounts)
//        {
//            if(account.getAccountType()==BankAccount.AccountType.CHECKING)
//            {
//                tempCheckingAmount=account.getBalance();
//            }
//            if(account.getAccountType() == BankAccount.AccountType.SAVINGS)
//            {
//                tempSavingsAmount = account.getBalance();
//            }
//        }
//        checkingAmount = tempCheckingAmount;
//        savingsAmount = tempSavingsAmount;
//        return new BankCustomer(customer.getName(),checkingAmount,savingsAmount);
//    }

    public BankCustomer getCustomer(String id)
    {
        return customers.get(id);
    }



    public void addCustomer(String name,double checkingInitialDeposit,double savingsInitialDeposit)
    {
        BankCustomer customer = new BankCustomer(name,checkingInitialDeposit,savingsInitialDeposit);
        customers.put(customer.getCustomerId(),customer);
    }

    public void doTransaction(String id,BankAccount.AccountType type,double amount)
    {
        BankCustomer customer = customers.get(id);
        List<BankAccount> accounts = customer.getAccounts();
        for(BankAccount account : accounts)
        {
            if(account.getAccountType()==type)
            {
                if(Math.abs(account.getBalance())<Math.abs(amount)&&amount<0)
                {
                    System.out.println("Not Enough Balance ! Transaction Failed");
                }
                else
                {
                    account.setBalance(account.getBalance() + amount);
                    System.out.println("Transaction Successful" + " Balance : "+ account.getBalance());
                    account.commitTransaction(routingNumber,++lastTransactionId,customer.getCustomerId(),amount);

                }

            }
        }
    }

    @Override
    public String toString()
    {

        return " Routing Number :"+routingNumber+" \n Last Transaction Id :"+lastTransactionId+"  \n Customers : "+customers.toString();
    }
}
