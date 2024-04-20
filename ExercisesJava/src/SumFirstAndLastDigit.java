public class SumFirstAndLastDigit {
    public static void main(String[]args)
    {
        System.out.println("Sum of the first and last digit is : "+sumFirstAndLastDigit(466679));
        System.out.println("Using Do While Loop: "+doWhile(466679));

    }
        public static int sumFirstAndLastDigit(int number)  //Finding The Sum Of First and Last Digits using a for Loop
        {
            if(number<0)
            {
                return -1;
            }
            int i,j;
            j=number%10;
            for(i=number;i/10!=0;i/=10)
            {

            }
            j+=i;
            return j;
        }
    public static int doWhile(int number)  //Sum of the first and last digits using Do While Loop
    {
        int i=number,j=0;
        do {
            j=number%10;
           i/=10;
        }
        while(i/10!=0);

      return    j+=i;

    }
}
