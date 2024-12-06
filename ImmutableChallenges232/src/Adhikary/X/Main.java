package Adhikary.X;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args)
    {


        BankAccount iciciBank = new BankAccount("ICICI",AccountType.CURRENT,new BigDecimal("2000"));
        BankAccount hdfcBank = new BankAccount("HDFC",AccountType.SAVINGS,new BigDecimal("3000"));
        BankAccount bobBank = new BankAccount("BankOFBaroda",AccountType.FIXEDDEPOSIT,new BigDecimal("5000"));

        List<BankAccount> bishalsBankAccounts = new ArrayList<>(List.of(iciciBank,hdfcBank,bobBank));

        BankCustomer bishalAdhikary = new BankCustomer("Bishal Adhikary",16180100,bishalsBankAccounts);

//        bishalsBankAccounts.forEach(System.out::println);

        bishalsBankAccounts.forEach(((s)->System.out.println(s)));

        //The following codes are trying to mutate fields for the above objects :

        //Since the fields in the above objects are String , enum and BigDecimals which are immutable ,which implies neither getter nor passing an argument to the constructor of these objects will have side effects

        System.out.println("-".repeat(50));
       bishalsBankAccounts.add(new BankAccount("SBI",AccountType.RECURRINGDEPOSIT,new BigDecimal("4000")));
//       bishalAdhikary.getAccounts().forEach(((s)->System.out.println(s)));
       System.out.println(bishalAdhikary);
       System.out.println("-".repeat(50));
       bishalsBankAccounts.forEach(System.out::println);

       System.out.println("-".repeat(50));
       List<BankAccount> accountsList = bishalAdhikary.getAccounts();
       accountsList.add(new BankAccount("SBI",AccountType.SALARY,new BigDecimal("2244.99")));
       accountsList.forEach(((s)->System.out.println(s)));
       System.out.println("-".repeat(50));
//       bishalAdhikary.getAccounts().forEach(((s)->System.out.println(s)));
        System.out.println(bishalAdhikary);
       System.out.println("-".repeat(50));






    }

}
