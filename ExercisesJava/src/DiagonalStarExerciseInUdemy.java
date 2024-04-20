public class DiagonalStarExerciseInUdemy {
    public static void main(String[] args) {

     System.out.println(  printSquareStar(10)); //printing the String value returned from the printSquareStar method 

    }
    static String s="";
    public static String printSquareStar(int number) {
        int i, j;
        for (i = 1; i <= number; i++) {
            for (j = 1; j <= number; j++) {
                if ((i == 1) || (j == 1) || (i == number) || (j == number) || (i == j) || (j == number - i + 1)) {
//                    System.out.print("*"); //(This logic is used when this method returns void : and all the following commented code is for the same reason

                    s=s+"*";

                    continue;



                }
//                System.out.print(" ");
                s=s+" ";
            }
//            System.out.println("");
            s=s+"\n";

        }
        return s;
    }
}




