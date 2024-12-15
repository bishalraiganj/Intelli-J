package Adhikary.X;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private  final int routingNumber;
    private long lastTransactionId =1;
    private final Map<String, BankCustomer> customers;

    public Bank(int routingNumber)
    {
        this.routingNumber = routingNumber;
        customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String id)
    {
        BankCustomer customer = customers.get(id);
        return customer;
    }

    public int getRoutingNumber()
    {
        return routingNumber;
    }

    public void addCustomer(String name,double checkingInitialDeposit,double savingsInitialDeposit)
    {
        BankCustomer customer = new BankCustomer(name,checkingInitialDeposit,savingsInitialDeposit);
        customers.put(customer.getCustomerId(),customer);
    }

    public boolean doTransaction(String id,AccountType accountType,double amount)
    {
        BankCustomer customer = customers.get(id);

        if(customer !=null)
        {
            BankAccount account = customer.getAccount(accountType);
            if(account !=null)
            {
                if(Double.parseDouble(account.getBalance().toString())+amount<0)
                {
                    System.out.println("Not enough Balance In Account of Customer ID : "+customer.getId()+"\n\n"+account);
                    return false;
                }
                else
                    account.commitTransaction(routingNumber,lastTransactionId++,id,amount);
                return true;
            }

        }
        else
        {
            System.out.println("Invalid Customer Id");
        }
        return false;
    }




}
