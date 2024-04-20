public class NextExercise {


    public static void main(String[] args) {
        sumOdd(5, 55);

        int sum = 0;
        for (int i = 15, count = 1; count <= 5 && i < 95; i++) {
//            System.out.println(isDivisible(i)?count +"   "+i+" is divisible by both 3 and 5 ": "");
            if (isDivisible(i)) {
                sum += i;
                System.out.println("Count :" + count + "  " + i + " is divisible by both 3 and 5");
                count++;
            }
        }
        System.out.println("Sum of the numbers is:" + sum);
    }

    public static boolean isDivisible(int num) {

        if (num % 3 == 0 && num % 5 == 0) {
            return true;
        }
        return false;
    }

    public static boolean isOdd(int number) {
        if (number % 2 != 0) {

            return true;
        }
        return false;
    }

    public static int sumOdd(int start, int end) {
        if (start < 0 || start > end || end < 0) {
            return -1;
        }
        int sum = 0;
        for (int i = start; i <= end; i++) {
            if (isOdd(i)) {
                return sum += i;

            }

        }
return sum;
    }
}
