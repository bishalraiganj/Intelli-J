import java.util.Arrays;

public class Temp {
    private static void reverse(int... array)
    {
        int[]  reversedArray=new int[array.length];
        for(int i=0,j=array.length-1;i<array.length;i++,--j)
        {
            reversedArray[i]=array[j];
        }
         System.out.println("Array = "+ Arrays.toString(array));
        System.out.println("Reversed array = "+Arrays.toString(reversedArray));
    }
public static void callReverse(int... array)
{

    reverse(array);

}


}
