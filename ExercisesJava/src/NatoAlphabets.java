public class NatoAlphabets {
    public static void main(String[] args) {
//      System.out.println( getDaysInMonth(2,2020));
//        char alphabet = 'A';
//        switch (alphabet) {
//            case 'A':
//                System.out.println("For the letter : " + alphabet + "NATO Word is : Able");
//                break;
//            case 'B':
//                System.out.println("For the letter : " + alphabet + "NATO Word is : Baker");
//                break;
//            case 'c':
//                System.out.println("For the letter :" + alphabet + "NATO Word is : Charlie");
//                break;
//            case 'D':
//                System.out.println("For the letter :" + alphabet + "NATO Word is : Dog");
//                break;
//            case 'E':
//                System.out.println("For the letter : " + alphabet + "NATO Word is : EASY");
//                break;
//            default:
//                System.out.println("Letter " + alphabet + "was Not Found in SWITCH");
//        }
//        for (int i = 0; i < 7; i++) {
//            printDayOfWeek(i);
//        }
//        for (int i = 0; i <= 7; i++) {
//            printWeekDay(i);
//        }

//    }

//    public static void printDayOfWeek(int day) {
//        String dayOfTheWeek = switch (day) {
//            case 0 -> {
//                yield "Sunday";
//            }
//            case 1 -> "Monday";
//            case 3 -> "Tuesday";
//            case 4 -> "Wednesday";
//            case 5 -> "Thursday";
//            case 6 -> "Friday";
//            case 7 -> "Saturday";
//            default -> "Invalid Day";
//
//
//        };
//        System.out.println("    " + day + dayOfTheWeek);
//    }
//
//    public static void printWeekDay(int day) {
//        String dayOfTheWeek;
//        if (day == 0) {
//            dayOfTheWeek = "Sunday";
//        } else if (day == 1) {
//            dayOfTheWeek = "Monday";
//        } else if (day == 2) {
//            dayOfTheWeek = "Tuesday";
//        } else if (day == 3) {
//            dayOfTheWeek = "Wednesday";
//        } else if (day == 4) {
//            dayOfTheWeek = "Thursay";
//        } else if (day == 5) {
//            dayOfTheWeek = "Friday";
//        } else
//            dayOfTheWeek = "Invalid Day";
//        System.out.println(day + "    " + dayOfTheWeek);
//    }
//
//    public static void printNumberInWord(int number) {
//        String printValue = switch (number) {
//            case 0 -> "Zero";
//            case 1 -> "One";
//            case 2 -> "Two";
//            case 3 -> "Three";
//            case 4 -> "Four";
//            case 5 -> "Five";
//            case 6 -> "Six";
//            case 7 -> "Seven";
//            case 8 -> "Eight";
//            case 9 -> "Nine";
//
//            case -1 -> "Minus One";
//            case -2 -> "Minus Two";
//            case -3 -> "Minus Three";
//            case -4 -> "Minus Four";
//            case -5 -> "Minus Five";
//            case -6 -> "Minus Six";
//            case -7 -> "Minus Seven";
//            case -8 -> "Minus Eight";
//            case -9 -> "Minus Nine";
//            default -> "Invalid Number";
//        };
//        System.out.println(printValue);
//
//


//    public static int getDaysInMonth(int month,int year){
//
//        if((month<1||month>12)||(year<1||year>9999))
//        {
//            return -1;
//        }
//       return switch(month){
//            case 1,3,5,7,9,10,12->31;
//            case 2->(isLeapYear(year)?29:28);
//            default ->30;
//       };
//    }
//    public static boolean isLeapYear(int year) {
//
//        if (1 > year || year <= 9999) {
//            return false;
//
//        }
//
//        if (year % 4 == 0) {
//            if (year % 100 != 0) {
//                return true;}
//            } else if (year % 400 == 0) {
//                return true;
//            }
//
//            return false;
//
//    }
//
////    public static double calculateInterest(double interestRate)
////    {
////
////        return interestRate*100;
////
////    }
////
////
//    }
    }

}