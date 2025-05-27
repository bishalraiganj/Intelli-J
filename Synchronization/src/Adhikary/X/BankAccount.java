package Adhikary.X;

public class BankAccount {

	private  double balance;

	private String name;

	public BankAccount(String name,double balance)
	{
		this.name = name;
		this.balance = balance;
	}

	public String getName()
	{
		return name;
	}
	public synchronized void setName(String name)
	{
		this.name = name;
		System.out.println("Updated name = " + this.name);

	}
	public double getBalance()
	{
		return balance;
	}

	public  synchronized void deposit(double amount)
	{
		try
		{

			System.out.println("Deposit - Talking to the teller at the bank... ");

			Thread.sleep(7000);


		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

//		synchronized(this) {
			double origBalance = balance;

			balance += amount;

			System.out.printf("STARTING BALANCE: %.0f, DEPOSIT (%.0f) " + " : NEW BALANCE = %.0f%n", origBalance, amount, balance);
//		}
	}


	public synchronized void withdraw(double amount)
	{
		try{
			Thread.sleep(100);
		}catch(InterruptedException e)
		{
			throw new RuntimeException(e);
		}

		double origBalance = balance;
		if ( amount  <= balance) {
			balance -= amount;
			System.out.printf("STARTING BALANCE: %.0f, WITHDRAWAL (%.0f) " + " : NEW BALANCE = %.0f%n", origBalance
					, amount, balance);
		}
		else
		{
			System.out.printf("STARTING BALANCE: %.0f , WITHDRAWAL (%.0f) " + " : INSUFFICIENT FUNDS! ", origBalance, amount);
		}




	}



}
