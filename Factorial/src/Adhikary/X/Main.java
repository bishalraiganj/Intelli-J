package Adhikary.X;

public class Main {

    public static void main(String[] args) {

        System.out.println(factorial(7));

    }


    public static int factorial(int n) {

        int res = n;
        while (n >= 2) {
            res = res *( n - 1 );
            n--;
        }
        return res;
    }

}