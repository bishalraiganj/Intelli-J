package dev.bank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int lastCustomerId = 10_000_000;

    private final String name;
    private final int customerId;

    private final List<BankAccount> accounts  =  new ArrayList<> ();

     BankCustomer(String name, double checkingAmount,double savingsAmount)
    {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING,checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS,savingsAmount));
    }

    public String getName()
    {
        return name;
    }
    public String getCustomerId()
    {
        return String.valueOf(customerId);
    }
    public List<BankAccount> getAccounts() //returns a Shallow copy , which implies that
            // the account objects are the same as in the list object and only returns a
    // copy of the ArrayList
    {
//        return new ArrayList<>(accounts);
        return List.copyOf(accounts);
    }

//    public BankAccount getAccount(BankAccount.AccountType accountType) // doesnt have  the transactions map that are in the original accounts since it returns a new BankAccount with empty transactions map
//    {
//       for(BankAccount a : accounts)
//        {
//            if(a.getAccountType()== accountType)
//            {
//                return new BankAccount(accountType,a.getBalance());
//            }
//        }
//       return null;
//
//    }

    public BankAccount getAccount(BankAccount.AccountType accountType)
    {
        for(BankAccount account : accounts)
        {
            if(account.getAccountType() == accountType)
            {
                return account;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        String[]  accountStrings = new String[accounts.size()];
        Arrays.setAll(accountStrings,(i)->accountStrings[i]=accounts.get(i).toString());
        return "Customer: %s (id: %015d)%n\t%s%n".formatted(name,customerId,String.join("\n\t",accountStrings));
    }
}
