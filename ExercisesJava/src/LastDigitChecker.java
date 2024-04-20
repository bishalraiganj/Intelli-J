public class LastDigitChecker {
public static void main(String[] args)
{
    System.out.println(hasSameLastDigit(899,88,79));
}
    public static boolean hasSameLastDigit(int numberOne,int numberTwo,int numberThree)
    {
        if(numberOne<10||numberTwo<10||numberThree<10||numberOne>1000||numberTwo>1000||numberThree>1000)
        {
            return false;
        }
        int n1,n2,n3;
        n1=numberOne%10;
        n2=numberTwo%10;
        n3=numberThree%10;
        if(n1==n2||n2==n3||n3==n1)
        {
            return true;
        }
        return false;
    }
    public static boolean isValid(int number)
    {
        if(number<10||number>1000)
        {
         return false;
        }
        return true;
    }
}
