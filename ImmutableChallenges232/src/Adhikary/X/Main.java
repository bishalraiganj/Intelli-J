package Adhikary.X;

import Adhikary.dto.Transaction;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String... args)
    {


//        BankAccount iciciBank = new BankAccount("ICICI",AccountType.CURRENT,new BigDecimal("2000"));
//        BankAccount hdfcBank = new BankAccount("HDFC",AccountType.SAVINGS,new BigDecimal("3000"));
//        BankAccount bobBank = new BankAccount("BankOFBaroda",AccountType.FIXEDDEPOSIT,new BigDecimal("5000"));
//
//        List<BankAccount> bishalsBankAccounts = new ArrayList<>(List.of(iciciBank,hdfcBank,bobBank));
//
//        BankCustomer bishalAdhikary = new BankCustomer("Bishal Adhikary",16180100,bishalsBankAccounts);
//
////        bishalsBankAccounts.forEach(System.out::println);
//
//        bishalsBankAccounts.forEach(((s)->System.out.println(s)));
//
//        //The following codes are trying to mutate fields for the above objects :
//
//        //Since the fields in the above objects are String , enum and BigDecimals which are immutable ,which implies neither getter nor passing an argument to the constructor of these objects will have side effects
//
//        System.out.println("-".repeat(50));
//       bishalsBankAccounts.add(new BankAccount("SBI",AccountType.RECURRINGDEPOSIT,new BigDecimal("4000")));
////       bishalAdhikary.getAccounts().forEach(((s)->System.out.println(s)));
//       System.out.println(bishalAdhikary);
//       System.out.println("-".repeat(50));
//       bishalsBankAccounts.forEach(System.out::println);
//
//       System.out.println("-".repeat(50));
//       List<BankAccount> accountsList = bishalAdhikary.getAccounts();
//       accountsList.add(new BankAccount("SBI",AccountType.SALARY,new BigDecimal("2244.99")));
//       accountsList.forEach(((s)->System.out.println(s)));
//       System.out.println("-".repeat(50));
////       bishalAdhikary.getAccounts().forEach(((s)->System.out.println(s)));
//        System.out.println(bishalAdhikary);
//       System.out.println("-".repeat(50));
//
//        // The Following checks the copy constructors vulnerability
//
//        BankCustomerHacker bishalHacker = new BankCustomerHacker(bishalAdhikary);
//        List<BankAccount> hackerAccountsList =  bishalHacker.getAccounts();
//        hackerAccountsList.add(new BankAccount("IDFC",AccountType.FIXEDDEPOSIT,new BigDecimal("5000")));
//        hackerAccountsList.forEach(((s)->System.out.println(s)));
//        System.out.println("-".repeat(50));
//        System.out.println(bishalAdhikary);


        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe",500.00,10000.00);



        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);
//        List<BankAccount> accounts = joe.getAccounts();
//        accounts.clear();
//        System.out.println(joe);

        if(bank.doTransaction(joe.getCustomerId(),AccountType.CHECKING,35))
        {
            System.out.println(joe);
        }

        if(bank.doTransaction(joe.getCustomerId(),AccountType.CHECKING,-535))
        {
            System.out.println(joe);
        }

        BankAccount checking = joe.getAccount(AccountType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k,v)->System.out.println(k+": "+v));

//        transactions.put(3L,new Transaction(1,1,Integer.parseInt(joe.getCustomerId()),500));
        System.out.println("-".repeat(50));

//        for(Map.Entry<Long,Transaction> e : transactions.entrySet())
//        {
//            e.getValue().setCustomerId(2);
//            e.getValue().setAmount(10000.00);
//        }

//        for(var tx: transactions.values())
//        {
//            tx.setCustomerId(2);
//            tx.setAmount(10000.00);
//
//        }
//        transactions.forEach((k,v)->System.out.println(k+": "+v));
        joe.getAccount(AccountType.CHECKING).getTransactions().clear();
        System.out.println("-".repeat(50));

        joe.getAccount(AccountType.CHECKING).getTransactions().forEach((k,v)->System.out.println(k+": "+v));







    }

}
