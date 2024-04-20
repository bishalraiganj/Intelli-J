import java.util.Arrays;
import java.util.Random;

public class ArraysChallenge {
      public static void main(String[] args)
      {

   int[]   originalArray  =  randomArray(10);
       Arrays.sort(originalArray);
       int[] copiedArray=Arrays.copyOf(originalArray,10);
       System.out.println("Hight to Low Sorted Original array is :"+Arrays.toString(originalArray));
       System.out.println("The revered Sorted array is :"+ Arrays.toString(sortedLowToHigh(originalArray)));




      }
      public static int[] randomArray(int len)
      {

          Random random=new Random();
          int[] randomArray=new int[len];
          for(int i=0;i<len;i++)
          {
                randomArray[i]=random.nextInt(100);
          }
            System.out.println(Arrays.toString(randomArray));

 return randomArray;
      }

      public static int[]  sortedLowToHigh(int[] originalArray)
      {
           int[] sortedArray=new int[originalArray.length];
          for(int i=(originalArray.length-1),j=0;i>=0&&j<originalArray.length;--i,j++)
          {
              sortedArray[j]=originalArray[i];


          }

           return sortedArray;
      }

}
