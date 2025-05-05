package Adhikary.X;

public class Main {

	public static void main(String... args)
	{


		System.out.println(greatestNum(100002,6,5));

		System.out.println(":".repeat(50));
		System.out.println("Prime Status : " + checkPrime(11));

	}



	private static int greatestNum(int x, int y , int z)
	{
		int greatest=0;
		if(x>y)
		{
			greatest=x;
		}
		else {
			greatest = y;
			if(greatest<z)
			{
				return z;
			}
			else
				return greatest;
		}

		return greatest;

	}

	private static boolean checkPrime(int x)
	{
		if(x<=1)
		{
			return false;
		}
		else if(x % 2==0 && x!=2)
		{
			return false;
		}
		else if(x == 2)
		{
			return true;
		}
		else
		{
			for(int i= 3; i<= Math.sqrt(x) ; i+=2) {
				if (x % i == 0)
				{
					return false;
				}
			}
			return true;
		}
	}

}
