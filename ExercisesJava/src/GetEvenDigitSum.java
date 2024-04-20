public class GetEvenDigitSum {

    public static void main(String[] args)
    {
        System.out.println("Sum of the even digits in the Number is : "+getEvenDigitSum(-10));
    }

    public static int getEvenDigitSum(int number)
    {


        if(number<0)
        {
            return -1;
        }
        int i,j=0,k=0;
        for(i=number;i/10!=0;i/=10)
        {
            j=i%10;
            if(j%2==0&&j!=0)
            {
                k+=j;
            }

        }
        j=i;
        if(j%2==0&&j!=0)
        {
            k+=j;
        }
        return k;
    }
}
