package Adhikary.X;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {
    private final String name;
    private final int id;
    protected final List<BankAccount> accounts;

    public BankCustomer(String name, int id, List<BankAccount> accounts) {
        this.name = name;
        this.id = id;
        this.accounts = new ArrayList<>(accounts);
    }

    public BankCustomer(BankCustomer bankCustomer)
    {
        this.name = bankCustomer.name;
        this.id = bankCustomer.id;
        this.accounts = new ArrayList<>(bankCustomer.accounts);
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
        return new ArrayList<>(accounts);
    }
    @Override
    public String toString()
    {
        return "Customer Name = "+name+" \n Customer Id = "+ id + " \n Accounts = " + accounts;
    }







}
