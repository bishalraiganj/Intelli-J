public class BankAccount {

    int accountNumber;
    double accountBalance;
    String customerName;
    String email;
    int phoneNumber;

 public int getAccountNumber()
 {
     return accountNumber;
 }
  public double getAccountBalance()
  {
      return accountBalance;

  }
   public String getCustomerName()
   {
       return customerName;
   }
   public String  getEmail()
   {
       return email;
   }

public int getPhoneNumber()
{
    return phoneNumber;
}
public void setAccountNumber( int accountNumber)
{
    this.accountNumber=accountNumber;
}
public void setAccountBalance(double accountBalance)
{
    this.accountBalance=accountBalance;
}
public void setCustomerName(String customerName)
{
    this.customerName=customerName;

}
public void  setEmail(String  email)
{
    this.email=email;
}
public void setPhoneNumber(int phoneNumber)
{
    this.phoneNumber=phoneNumber;
}
public void depositFund(double amount)
{
    setAccountBalance(amount);
    System.out.println("  Deposited Amount :"+this.accountBalance+"\nCurrent Available Balance :"+this.accountBalance+"\n");
}
public  void withdrawFund(double amount)
{
   if(this.accountBalance-amount<0)
   {
     System.out.println("Insufficient Balance");
     return;
   }
  this.accountBalance-=amount;
   System.out.println(" Withdrawn Amount :"+amount+"\n Current Available Balance :"+this.accountBalance);
}
}
