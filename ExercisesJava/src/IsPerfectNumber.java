public class IsPerfectNumber {
    public static void main(String[] args)
    {
        System.out.println(isPerfectNumber(5)?"True":"False");
    }

    public static boolean isPerfectNumber(int number)
    {
        if(number<1)
        {
            return false;
        }
        int i,j=0;
        for(i=1;i<=number/2;i++)
        {
            if(number%i==0)
            {
                j+=i;
            }
        }
        if(j==number)
        {
            return true;
        }
        return false;
    }
}
