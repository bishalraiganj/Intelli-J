import java.util.ArrayList;

public class Bank {


    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        branches = new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName)
    {
        if(findBranch(branchName)==null)
        {
            branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    private Branch findBranch(String branchName)
    {
        for(Branch i:branches)
        {
            if(i.getName().equalsIgnoreCase(branchName))
            {
                return i;

            }
        }
        return null;
    }
    public boolean addCustomer(String branchName,String customerName,double initialTransaction)
    {
        if(!(findBranch(branchName)==null))
        {

           return findBranch(branchName).newCustomer(customerName,initialTransaction);

        }

        return false;
    }
    public boolean addCustomerTransaction(String branchName,String customerName,double cdTransaction)
    {
        if(!(findBranch(branchName)==null))
        {
         return   findBranch(branchName).addCustomerTransaction(customerName,cdTransaction);

        }
        return false;
    }
    public boolean listCustomers(String branchName,boolean printTransactionList)
    {
        if(!(findBranch(branchName)==null)&&printTransactionList==true)
        {    System.out.printf("""
                Customer details for branch %s             
                """,findBranch(branchName).getName());
            for(Customer i:findBranch(branchName).getCustomers())
            {
                System.out.printf(
                        """
                        Customer: %s[%d]
                        Transactions
                        """,i.getName(),findBranch(branchName).getCustomers().indexOf(i)+1);
                if(i.getTransactions().size()>0)
                {
                    for(Double t:i.getTransactions()) {
                        System.out.printf("""
                                      [%d] Amount %.2f
                                      """,i.getTransactions().indexOf(t)+1,t);
                    }
                }
            }

            return true;
        }
        if(!(findBranch(branchName)==null)&&printTransactionList==false)
        {

            System.out.printf("""
                Customer details for branch %s             
                """,findBranch(branchName).getName());
            for(Customer i:findBranch(branchName).getCustomers())
            {
                System.out.printf(
                        """
                        Customer: %s[%d]
                        """,i.getName(),findBranch(branchName).getCustomers().indexOf(i)+1);

            }

            return true;
        }

        return false;
    }
}
