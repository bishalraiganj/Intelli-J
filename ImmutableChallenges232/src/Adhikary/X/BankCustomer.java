package Adhikary.X;

import java.util.ArrayList;
import java.util.List;

public class BankCustomer {

    private static int lastCustomerId = 10_000_000;
    private final String name;
    private final int id;
    protected final List<BankAccount> accounts;

    BankCustomer(String name, int id, List<BankAccount> accounts) {
        this.name = name;
        this.id = lastCustomerId++;
        this.accounts = new ArrayList<>(accounts);
    }

    BankCustomer(String name, double checkingInitialDeposit, double savingsInitialDeposit)
    {
        accounts = new ArrayList<>();
        this.name = name;
        id= lastCustomerId++;
        accounts.add(new BankAccount(AccountType.CHECKING,checkingInitialDeposit));
        accounts.add(new BankAccount(AccountType.SAVINGS,savingsInitialDeposit));




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

    public String getCustomerId()
    {
        return "%015d".formatted(id);
    }

    public int getId() {
        return id;
    }

    public List<BankAccount> getAccounts()
    {
        return List.copyOf(accounts);
    }

    public BankAccount getAccount(AccountType type )
    {
        for(var account : accounts)
        {
            if(account.getAccountType()== type)
                return account;
        }
        return null;
    }
    @Override
    public String toString()
    {
        return "\n\nCustomer Name = "+name+" \n Customer Id = "+ id + " \n Accounts = \n\n\n" + accounts;
    }







}
