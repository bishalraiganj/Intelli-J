import java.util.Scanner;

public class ZeroCount {
    public static void main(String[] args)
    {

        Scanner s = new Scanner(System.in);
        System.out.println("Specify the length of the Binary String");
        int length = s.nextInt();
        s.nextLine();
        System.out.println("Specify the number of 1's in the Binary String");
        int number = s.nextInt();
        s.nextLine();

        if(number<=length&&number>=0&&length<=Math.pow(10,6)&&length>=1)
        {

            if(length==number)
            {
                System.out.println(0);
            }
            if(number==0)
            {
                System.out.println(length);
            }
           if(number<length)
           {

            if(length-number<number)
            {
                System.out.println(number);
            }

            else {


                findMaxZeroBlockLength(length,number);

            }


           }
        }
        else {

            System.out.println("Invalid Value");
        }
    }

    public static void findMaxZeroBlockLength(int length,int number)
    {
        int zeroCount = length-number;
        int segmentCount = number+1;

        System.out.println("The number of zero is : "+(int)  Math.ceil((double ) zeroCount/segmentCount));



    }

}
