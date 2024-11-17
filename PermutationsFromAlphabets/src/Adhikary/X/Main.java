package Adhikary.X;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class Main
{
    public static void main(String... args) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of Permutations to create from alphabets ,Where  letters arent repeated (Code Written By Bishal Adhikary ) \n");
        int length = s.nextInt();
        s.nextLine();


        if(length<=8&&length>=1)
        {

            List<String> previousString = new ArrayList<>();
        for (char c : alphabets.toCharArray())
        {
            previousString.add(String.valueOf(c));
        }



        while(previousString.get(0).length()<length)
        {
            List<String> newString = new ArrayList<>();
            for (String str : previousString)
            {
                if(previousString.get(0).length()<length)
                {
                    for(String s1 : removeString(str))
                    {
                     newString.add(str + s1);

                    }
                }
            }

            if(newString.size()!=0)
            {
                previousString.clear();
                previousString.addAll(newString);
            }
        }

        previousString.sort(Comparator.comparing((k)->k));

//        previousString.forEach(System.out::println);

            int iterationCount=1;
            for(String e: previousString )
            {
                System.out.println(iterationCount +" : " + e);
                iterationCount++;
            }
        System.out.println("\n Enter the rank of the String to find the string  : \n");
        int rank =  s.nextInt();
        s.nextLine();
//        findRank(previousString,rank);
        findRank2(rank,length);
        }

    }


    public static List<String>  removeString(String s)
    {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        List<String>  afterString  = new ArrayList<>();
        for(char  c: alphabets.toCharArray())
        {
            afterString.add(String.valueOf(c));
        }
        for(char c1: s.toCharArray())
        {
            afterString.remove(String.valueOf(c1));
        }
        return afterString;
    }

    public static void findRank(List<String> permutationsList,int rank)
    {
        TreeMap<Integer,String>  rankedPermutations = new TreeMap<>(Comparator.comparing((k)->k));
        for(String s : permutationsList)
        {
            rankedPermutations.putIfAbsent(permutationsList.indexOf(s)+1,s);
        }
        System.out.println("The String Ranked :"+rank +" is :" + rankedPermutations.get(rank));

    }

//    public  static void findRank2(int rank,int length)
//    {
//        HashMap<String,Integer> ra = new HashMap<>();
//        TreeMap<String,Integer> rankedAlphabets = new TreeMap<>(new Comparator<String>(){
//
//            @Override
//            public int compare(String o1, String o2)
//            {
//                return ra.get(o1).compareTo(ra.get(o2));
//            }
//        });
//        rankedAlphabets.putAll(ra);
//
//        String alphabets = "abcdefghijklmnopqrstuvwxyz";
//        int lc =1;
//        for(char c : alphabets.toCharArray())
//        {
//            ra.putIfAbsent(String.valueOf(c),lc);
//            lc++;
//        }
//
//        TreeMap<Integer,String> intString = new TreeMap<>();
//        for(String s : rankedAlphabets.keySet())
//        {
//            intString.putIfAbsent(rankedAlphabets.get(s),s);
//        }
//
//
//        int lc2=0;
//        int max =26;
//        StringBuilder permutation  = new StringBuilder();
//        while(lc2<length)
//        {
//           double div = rank/((factorial(max-lc2)/factorial(26-length)));
//           if(integerCheck(div))
//           {
//               permutation.append("z");
//           }
//           else {
//               double decimal = div - Math.floor(div);
//
//               double letterIndex = decimal*(26-lc2);
//               for (int i = 1; i <=permutation.length(); i++)
//               {
//                   if(rankedAlphabets.get(permutation.charAt(i))<letterIndex)
//                   {
//                       letterIndex++;
//                   }
//               }
//               permutation.append(intString.get(letterIndex));
//           }
//        }
//        System.out.println("The Permutation Ranked:" + rank + "is : " +permutation.toString());
//    } Ineffiecient also wrong logic


    public static void findRank2(int rank,int length) {
        /*
                     EXPLANATION
        (LOGIC) -   say, permutation length n, of alphabets without repetitions, rank is x
        each permutation have n positions ,
        for  each position in the permutation , number of permutations including that position wil be (26-i)*(26-i-1)*(26-i-2)*....*(26-n+1)
        in the above expression i is the position subtracted by 1, ex : for first position including this position we can have
        26*25*23*....*(26-n+1) number of permutations ,,
        |
        |
        26 alphabets possible in the first position

        to find the  alphabet at first position of the permutation ranked  x
        divide rank by number of permutations possible for the length possible when including the position ex : finding the first position alphabet
        means permutations of length n ,
        if the result is an integer it means the result is the last alphabet that is not already on the permutation
        if it is in decimal then multiply the decimal part of the quotient to the number of alphabets possible in that position
        the result of the above division represents the position of alphabets if we order the alphabets lexicographically
        now , if the alphabets in the permutation have serial indexes less than the serial index of the result then we have to increase
        the result index by the same number of alphabets in the permutation having indexes less than that of the quotient ,,,
        now after addition the quotient represent the index of the alphabet in that position , if the quotient after indexing becomes greater than the index of the last
        alphabet available then the last alphabet available is the one at that position




         */
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder  permutation = new StringBuilder();
        int lc = 0;
        Set<String> set = new LinkedHashSet<>();
        for(char c : alphabets.toCharArray())
        {
            set.add(String.valueOf(c));
        }
        while (lc < length)
        {
            BigDecimal  positionIndex = new BigDecimal(String.valueOf(lc));
            BigDecimal pLength = new BigDecimal(String.valueOf(length));
            BigDecimal pRank = new BigDecimal(String.valueOf(rank));
            BigDecimal div = pRank.divide(new BigDecimal((String.valueOf(numOfPermutationsAtPosition(length,lc)))),18, RoundingMode.DOWN); // truncating using RoundingMode.DOWN fixed the pecision issues compared to using RoundingMode.HALF_UP
            set.removeIf((k)->{
                for(char c : permutation.toString().toCharArray())
                {
                    if(k.equals(String.valueOf(c)))
                    {
                        return true;
                    }
                }
                return  false;
            });

            List<String> availableAlphabetsList = new ArrayList<>(set);
            if(integerCheck(div))
            {
                permutation.append(new TreeSet<>(set).last());
                lc++;
            }
            else
            {
                System.out.println("\n "+div + "\n");
                BigDecimal difference = div.subtract(div.setScale(0,RoundingMode.DOWN));
                BigDecimal di = BigDecimal.valueOf(26).subtract(positionIndex); // number of alphabets possible at that position lc+1
                BigDecimal d= difference.multiply(di);
                BigDecimal test = d.setScale(0,RoundingMode.CEILING);
                BigDecimal index = test.subtract(BigDecimal.valueOf(1));
                permutation.append(availableAlphabetsList.get(index.intValue()));
                availableAlphabetsList.forEach(System.out::print);
                lc++;
            }
        }
            System.out.println(" The Permutation Ranked : " +rank + " is : " + permutation);
    }

    public static int  numOfPermutationsAtPosition(int length,int lc)
    {

        int numOfCharsInCurrPosition = 26-lc,numOfLength=length-lc;
        int res = numOfCharsInCurrPosition;
        for(int i =1 ;i<numOfLength;i++)
        {
            res *=(numOfCharsInCurrPosition-1);
            numOfCharsInCurrPosition--;
        }
        return res;
    }

    public static int factorial(int n) {

        int res = n;
        while (n >= 2) {
            res = res *( n - 1 );
            n--;
        }
        return res;
    }

    public static  boolean integerCheck(BigDecimal n)
    {
//        return n.setScale(3,RoundingMode.HALF_UP).divide(n.setScale(0,RoundingMode.DOWN),3,RoundingMode.HALF_UP).equals(BigDecimal.ONE.setScale(3,RoundingMode.HALF_UP));
        return n.setScale(3,RoundingMode.HALF_UP).subtract(n.setScale(0,RoundingMode.DOWN)).equals(BigDecimal.ZERO.setScale(3,RoundingMode.HALF_UP));
    }

}
