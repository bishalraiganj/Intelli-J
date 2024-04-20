import java.util.Arrays;
import java.util.Scanner;

public class MinimumElementChallenge {

    public static int[] readIntegers()
    {
        Scanner s1=new Scanner(System.in);
        System.out.println("Enter the list of Integers delimitted by commas : \n");
        String s3=s1.nextLine();
        System.out.println(s3);
        String[] sArray=s3.split(",");

        int[] iArray=new int[sArray.length];
         for(int i=0;i<sArray.length;i++)
         {
             iArray[i]=Integer.parseInt(sArray[i]);


         }
  return iArray;
    }
   public static int findMin(int... array)
   {
       Arrays.sort(array);
       System.out.println("Minimum value found in the array is :"+array[0]);
       return array[0];

   }

}
