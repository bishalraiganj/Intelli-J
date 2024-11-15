package Adhikary.X;

import java.util.*;

public class Main
{
    public static void main(String... args) {
        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the length of Permutations to create from alphabets ,Where  letters arent repeated\n");
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

        previousString.forEach(System.out::println);

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
            double div = (double)rank/numOfPermutationsAtPosition(length,lc);

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

            if(integerCheck(div))
            {
                permutation.append(new TreeSet<>(set).last());
                lc++;
            }
            else
            {
                double difference = div-Math.floor(div);
                int index = (int) Math.ceil(difference*(26-lc))-1;
                for(char c : permutation.toString().toCharArray())
                {
                    if(alphabets.indexOf(c)<index);
                    index++;
                }
                permutation.append(alphabets.charAt(index));
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

    public static  boolean integerCheck(double n)
    {
        if(n-Math.floor(n)==0)
        {
            return true;
        }
         return false;
    }

}
