import java.util.Scanner;

public class InputThenPrintSumAndAverage {
public static void main(String[] args)
{

    inputThenPrintSumAndAverage();
}

    public static void inputThenPrintSumAndAverage()
    {
        int n1 = 0, i;
        Scanner scanner = new Scanner(System.in);
        for (i = 0; true; i++)
        {
            String s = scanner.nextLine();
            try
            {
                int number = Integer.parseInt(s);
                n1 += number;
            } catch (NumberFormatException e)
            {
                break;
            }
        }
        System.out.println("SUM = " + n1 + " AVG = " + n1 / i);
    }
}