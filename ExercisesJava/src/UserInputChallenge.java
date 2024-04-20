import java.util.Scanner;



public class UserInputChallenge {

    public static void main(String[] args) {
        int i =1, sum=0;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Enter number #" + i);
            String number = scanner.nextLine();
            int num1 = 0;
            try {
                num1 = Integer.parseInt(number);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Value");
                 continue;
            }
            sum += num1;
            i++;
        }
        while(i<=5);
        System.out.println("Total is :"+sum);
    }

}
