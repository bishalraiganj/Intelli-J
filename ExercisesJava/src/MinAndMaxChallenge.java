import java.util.Scanner;

public class MinAndMaxChallenge {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int i=0,min=0,max=0;
        System.out.println("Enter any number or Character to Quit");
        while (true)
        {
            String s = scanner.nextLine();
        try {
            int n1 = Integer.parseInt(s);
             if(i==0||n1<min)
             {
                 min=n1;

             }

            if(i==0||max<n1)
            {

                max=n1;
            }
        } catch (NumberFormatException e) {
            break;
        }
        i++;

    }
        System.out.println("Count :"+i+"\n"+"Min :"+min+"\n"+"Max :"+max);

    }
}
