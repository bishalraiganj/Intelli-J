import java.util.Arrays;

public class ReverseArray {



public static int[] reverse(int... array)
{
System.out.println("The original Array is :" +Arrays.toString(array));

//int [] array2= Arrays.copyOf(array,array.length);
    int[] array3=new int[array.length];
for(int i=0,j=array.length-1;i<array.length&&j>=0;i++,j--)
{ array3[i]=array[j];

}
return array3;
}



}
