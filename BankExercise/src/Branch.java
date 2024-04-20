import java.util.ArrayList;

public class Branch {

    private String name;
    private ArrayList<Customer> customers;
    public Branch(String name)
    {
        this.name=name;
        customers=new ArrayList<Customer>();
    }
    public String getName()
    {
        return name;
    }
    public ArrayList<Customer> getCustomers()
    {

        return customers;
    }
    private Customer findCustomer(String customerName)
    {
        for(Customer i:customers)
        {
            if(i.getName().equalsIgnoreCase(customerName))
            {
                return i;
            }

        }
        return null;

    }
    public boolean newCustomer(String customerName,double initialTransaction)
    {
        if(findCustomer(customerName)==null)
        {
            customers.add(new Customer(customerName,initialTransaction));
            return true;
        }
return false;
    }
    public boolean addCustomerTransaction(String customerName,double transaction)
    {
        if(findCustomer(customerName)==null)
        {
            return false;

        }

        findCustomer(customerName).getTransactions().add(transaction);
        return true;
    }


}
