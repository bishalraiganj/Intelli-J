public class GetLargestPrimeFactor {

    public static void main(String[] args)
    {
       System.out.println(getLargestPrime(121));
    }
    public static int getLargestPrime(int number)
    {     if(number<=1)
    {

        return -1;
    }
        int i,j,k=0,i2;
        for(i=2;i<=number;i++)
        {
            if(number%i==0)
                {
                    for( i2=2;i2<=i;i2++)
                    {
                        if(i%i2==0)
                        {
                            break;
                        }

                    }
                    if(i2==i)
                    {
                        k=i;
                    }
                }

        }
        return k;
    }

}
