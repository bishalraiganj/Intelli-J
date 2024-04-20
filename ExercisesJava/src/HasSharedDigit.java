public class HasSharedDigit {

public static void main(String[] args)
{
System.out.println(hasSharedDigit(1234,81)?"True":"False");
}
public static boolean hasSharedDigit(int numberOne,int numberTwo)
{
    if((numberOne<10||numberOne>99999)||(numberTwo<10||numberTwo>99999))// Checking if There are Same digits amongst the two numbers between this range.
    {
        return false;
    }
    int i,j,i2,j2;
    for(i=numberOne;i/10!=0;i/=10)//Apart from the first digit in numberOne it checks all digits in number one with all digit of numberTwo
    {
        j=i%10;
        for(i2=numberTwo;i2/10!=0;i2/=10) {
            j2 = i2 % 10;
            if (j == j2) {
                return true;
            }

        }
        if(j==i2)
        {

            return true;
        }

    }
    j=i;
    for(i2=numberTwo;i2/10!=0;i2/=10) //The Following code block from here checks the first digit in numberOne with all digits in numberTwo
    {
        j2=i2%10;
        if(j==j2)
        {
            return true;
        }

    }
    if(j==i2)
    {

        return true;
    }

 return false;
}

}
