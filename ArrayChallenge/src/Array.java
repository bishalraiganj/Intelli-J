
import java.util.Scanner;

public class Array {
    private static int[] array;
  static int len1;
  static int temp;
  static boolean b=false;
  public static int[] getArray()
  {

      return array;
  }
    public static int[] getIntegers(int len) {
        Scanner s = new Scanner(System.in);
         array = new int[len];
        for (int i = 0,j=0; i < len; i++) {
            System.out.printf("Index no :%d Enter Value :",i);
            j=s.nextInt();
            array[i]=j;
        }
      len1=len;
   return array;

    }
   public static  int[]  sortIntegers(int[] array1)

   {
       array1=array;

       boolean c=true;
   int i;
       while(c)
       {
           for( i=0;i<len1-1;i++)
           {
               if(i<len1-1)
               {
               if(array1[i]<array1[i+1])
           {
               b=true;
               temp = array1[i+1];
               array1[i+1] = array1[i ];
               array1[i ] = temp;
               continue;
           }
               }
               if(i==len1-2&&b==false)
           {

            c=false;
           }
           }
b=false;

       }
return array1;

   }
   public static void printArray(int[] array1)
   {
       array1=array;
  for(int i=0;i<len1-1;i++) {
      System.out.printf("Element %d contents ",i+array1[i]);
  }
   }

}