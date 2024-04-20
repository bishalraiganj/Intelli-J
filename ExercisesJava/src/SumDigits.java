public class SumDigits {
    public static void main(String[] args)
    {

        System.out.println("Sum of the Digits of the Number :"+sumDigits(109900));
    }
    public static int sumDigits(int number)
    {   int sum=0;
        if(number<0)// Checking whether the number is negative.
        {
            return -1;// Returning -1 incase the number is Negative .
        }
        else if(number/1<=9)//Checking whether the number is Single Digit or Not .
        {
            return sum=number;// When the number is a single Digit of its digits is the number itself.
        }
        else {
            int i,j;
            for (i = number; i /10 != 0; i /= 10) {// When the number is multi Digit This Algo used in this for loop will sum its digits.
                j=i%10;
                sum += j;


            }
           return   sum += i;


        }

    }
}
