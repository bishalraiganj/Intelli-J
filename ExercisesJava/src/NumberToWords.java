public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(numberToWords(1001));
    }
    static String s1="";
    public static String numberToWords(int number) {
        if (number<0)
        {
            return "Invalid Value";
        }
        if(number==0)
        {
            return "Zero";

        }

        int leadingZeros=getDigitCount(number)-getDigitCount(reverse(number));
            int i1;
            for(i1=1;i1<=leadingZeros;i1++)
            {
                s1=s1+" Zero";
            }


        int k = reverse(number), i, j = 0;
        String s="";
        String l;
        for (i = k; i / 10 != 0; i /= 10)
        {
            j = i % 10;
         //   s=s+" "+digitToWord(j);

           l=switch (j) {
                         case 1 -> "One";
                          case 2 -> "Two";
                          case 3 -> "Three";
                         case 4 -> "Four";
                         case 5 -> "Five";
                         case 6 -> "Six";
                        case 7 -> "Seven";
                       case 8 -> "Eight";
                      case 9 -> "Nine";
                     default -> "Zero";

                    };
             s+=" "+l;
        }

        l=switch (i) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            default -> "Zero";

        };
        s+=" "+l;





      //  s=s+" "+digitToWord(i);
       return s+s1;

    }

    public static int reverse(int number) {
        int i, j = 0, reversed = 0;
        for (i = number; i / 10 != 0; i /= 10) {
            j = i % 10;
            reversed = reversed * 10 + j;


        }
        reversed=reversed*10+i;
        return reversed;
    }

  //  public static String digitToWord(int digit) { // (HERE digitToWord METHOD IS USED to CHange Each digit of a number to string its equivalent.
    //    return switch (digit) {
  //          case 1 -> "One";
  //          case 2 -> "Two";
  //          case 3 -> "Three";
   //         case 4 -> "Four";
   //         case 5 -> "Five";
   //         case 6 -> "Six";
    //        case 7 -> "Seven";
     //       case 8 -> "Eight";
      //      case 9 -> "Nine";
       //     default -> "Zero";

    //    };

   // }


    public static int getDigitCount(int number)
    {
        int i,j=0;
        for(i=number;i/10!=0;i/=10)
        {
            j+=1;

        }
        j+=1;
        return j;

    }
}


