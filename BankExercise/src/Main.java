public class Main {


    public static void main(String[] args)
    {
        Bank bishalBank=new Bank("Bishal's Vault");
        bishalBank.addBranch("Raiganj");
        bishalBank.addCustomer("Raiganj","Bishal Adhikary",80000);
        bishalBank.addCustomerTransaction("Raiganj","Bishal",-8000);
        bishalBank.addCustomer("Raiganj","Suparna",90000000);

        bishalBank.addBranch("Gangarampur");
        bishalBank.addCustomerTransaction("Raiganj","Suparna",-100);

       bishalBank.listCustomers("Raiganj",true);
       bishalBank.listCustomers("Raiganj",false);

    }
}
