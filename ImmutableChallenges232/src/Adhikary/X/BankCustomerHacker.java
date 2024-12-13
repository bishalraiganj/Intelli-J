package Adhikary.X;

import java.util.List;

public class BankCustomerHacker extends BankCustomer{

    public BankCustomerHacker(String name, int id , List<BankAccount> accounts)
    {
        super(name,id,accounts);
    }

    public BankCustomerHacker(BankCustomer bankCustomer)
    {
        super(bankCustomer);
    }

    @Override
    public List<BankAccount> getAccounts()
    {
        return accounts;
    }




}