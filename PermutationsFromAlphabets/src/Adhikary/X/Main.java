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
        findRank(previousString,rank);
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

    public void findRank2(int rank,int length)
    {
        TreeMap<Integer,String> rankedAlphabets = new TreeMap<>(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2)
            {
                return o1.compareTo(o2);
            }
        });

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        int lc =1;
        for(char c : alphabets.toCharArray())
        {
            rankedAlphabets.putIfAbsent(lc,String.valueOf(c));
            lc++;
        }
        int lc2=1;
        while(lc2<=length)
        {



        }



    }

    public int factorial(int n,int loopCounter)
    {
        int lc=loopCounter ;
        if(lc<n-1)
        {
            n=n*n-1;
            lc++;
            factorial(n,lc);
        }
        return n;
    }


}
