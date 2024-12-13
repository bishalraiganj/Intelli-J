package Adhikary.X;

import dev.bank.Bank;
import dev.bank.BankAccount;
import dev.bank.BankCustomer;

import java.util.List;

public class Main {
    public static void main(String... args)
    {
//        BankAccount account = new BankAccount(BankAccount.AccountType.CHECKING,500);
//        System.out.println(account);

//        BankCustomer joe  = new BankCustomer("Joe",500.00,10000.00);
//        System.out.println(joe);
//
//        List<BankAccount> accounts = joe.getAccounts();
//        accounts.clear();
//        System.out.println(joe);  The preceeding code snippet is meant for the previous challenge exercise234 and 235


        Bank bishalBank = new Bank(161800);
        bishalBank.addCustomer("Bishal Adhikary",5000.00,5000.00);

        System.out.println(bishalBank);

        BankCustomer bishalCustomer = bishalBank.getCustomer(String.valueOf(10000000));
        System.out.println(bishalCustomer);

        bishalBank.doTransaction(String.valueOf(10000000),BankAccount.AccountType.SAVINGS,100.00);

//        bishalBank.doTransaction()







    }

}
