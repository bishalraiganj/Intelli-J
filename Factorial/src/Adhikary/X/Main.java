package Adhikary.X;

public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(11)+" \n Integer Check : " + integerCheck(33.000001));
        System.out.println("-".repeat(50));
        System.out.println(numOfPermutationsAtPosition(3,3));



    }

    public static int  numOfPermutationsAtPosition(int length,int lc) {
        if (lc >= length||lc<0) {
            System.out.println("Position is greater than length");
            return 0;
        } else {

            int numOfCharsInCurrPosition = 26 - lc, numOfLength = length - lc, thirdPart;
            int res = numOfCharsInCurrPosition;
            for (int i = 1; i < numOfLength; i++) {
                res *= (numOfCharsInCurrPosition - 1);
                numOfCharsInCurrPosition--;
            }
            return res;
        }
        }

    public static int factorial(int n) {

        int res = n;
        while (n >= 2) {
            res = res *( n - 1 );
            n--;
        }
        return res;
    }

    public static  boolean integerCheck(double n)
    {
        if(n-Math.floor(n)==0)
        {
            return true;
        }
        return false;
    }

}