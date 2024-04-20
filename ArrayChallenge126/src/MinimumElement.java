import java.util.Arrays;
import java.util.Scanner;

public class MinimumElement {


  private static int readInteger()
    {

        Scanner s=new Scanner(System.in);
        String s1=s.nextLine();
        return Integer.parseInt(s1);


    }

    private static int[] readElements(int i)
    {
        int[] array=new int[i];
        Scanner s1=new Scanner(System.in);

        for(int i1=0;i1<array.length;i1++)
        {
            System.out.print("Enter a number :");
            int s2=s1.nextInt();
            array[i1]=s2;


        }
        return array;

    }

    
    public static int findMin(int[] array)
    {
        Arrays.sort(array);
        return array[0];


    }

}
