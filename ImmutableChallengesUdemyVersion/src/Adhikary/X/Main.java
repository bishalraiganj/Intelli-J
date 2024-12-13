package Adhikary.X;

import dev.bank.Bank;
import dev.bank.BankAccount;
import dev.bank.BankCustomer;
import dev.dto.Transaction;

import java.util.List;
import java.util.Map;

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
        System.out.println("Added 1");
        System.out.println("Added 2");
        bishalBank.doTransaction(String.valueOf(10000000),BankAccount.AccountType.SAVINGS,500.00);

        System.out.println("-".repeat(50)+"\n"+bishalCustomer);

        BankAccount bishalAccount = bishalCustomer.getAccount(BankAccount.AccountType.SAVINGS);
        Map<Long, Transaction> transactions = bishalAccount.getTransactions();
        System.out.println(transactions);
        System.out.println("-".repeat(50));

        Transaction transaction = transactions.get(Long.valueOf(1));

        System.out.println(transaction);




//        bishalBank.doTransaction()







    }

}
