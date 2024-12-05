package Adhikary.X;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private final String name;
    private final int id;
    private final List<BankAccount> accounts;

    public BankCustomer(String name, int id, List<BankAccount> accounts) {
        this.name = name;
        this.id = id;
        this.accounts = List.copyOf(accounts);
    }

    public BankCustomer(BankCustomer bankCustomer)
    {
        this.name = bankCustomer.name;
        this.id = bankCustomer.id;
        this.accounts = List.copyOf(bankCustomer.accounts);
    }

    public BankCustomer(String name, int id) {
        this(name, id, null);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<BankAccount> getAccounts()
    {
        return List.copyOf(accounts);
    }
    @Override
    public String toString()
    {
        return "Customer Name = "+name+" \n Customer Id = "+ id;
    }

}
