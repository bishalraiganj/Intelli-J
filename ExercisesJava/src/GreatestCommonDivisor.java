public class GreatestCommonDivisor {

    public static void main(String[] args) {
    System.out.println("The GCD of two numbers is "+getGreatestCommonDivisor(66,77));

    }

    public static int getGreatestCommonDivisor(int first, int second) {
        int i, j = 0;
        if (first < second || first == second) {
            for (i = 1; i <= first; i++) {
                if (first%i == 0 && second%i == 0) {
                    j = i;
                }
            }
            return j;
        }
        for (i = 1; i <= second; i++) {
            if (second % i == 0 && first % i == 0) {
                j = i;

            }

        }
        return j;
    }
}