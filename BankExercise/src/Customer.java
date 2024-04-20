import com.sun.jdi.DoubleValue;

import java.util.ArrayList;

public class Customer {

    private String name;
   private  ArrayList<Double> transactions=new ArrayList<>();
    public Customer(String customerName,double initialTransaction)
    {
        transactions.add(initialTransaction);
        this.name=customerName;
    }
    public String getName()
    {
        return name;
    }
    public ArrayList<Double> getTransactions()
    {
        return transactions;
    }
public void addTransaction(double transaction)
{
    transactions.add(transaction);

}

}
