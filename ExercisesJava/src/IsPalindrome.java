public class IsPalindrome {

    public static void main(String[] args)
    {

        System.out.println(isPalindrome(1221)?"True":"false");


    }


    public static boolean isPalindrome(int number)
    {
        if (number<10)
        {
            return false;
        }
        int j=0;
        for(int i=number;i/10!=0;i/=10)
        {
            j+=1;

        }
        int j2=0,j3=j,i2;

        for(i2=number;i2/10!=0;i2/=10)
        {
            j2+=(i2%10)*(Math.pow(10,j3));
            --j3;
            int n3=i2;
        }
       j2+=i2;
        if(number==j2)
        {
            return true;
        }
        else
            return false;
    }



}
