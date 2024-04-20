public class CalculateInterest {




    public static void main(String[] args)

    {int pnc = 1;
        for(int num=3;num<=79;num++) {

            if (pnc <= 10) {
                System.out.println(isPrime(num) ?pnc+" "+ num + "    is a prime number" :  " ");
                if (isPrime(num)) {
                    pnc += 1;

                }
            }
        }
System.out.println("   "+pnc);


    }


public static boolean isPrime(int num)
{
for (int i=2;i<=num/2;i++)
{
    if (num%i==0)
    {
        return false;
    }

}
return true;
}
}