package Adhikary.X;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {

      System.out.println( validateName(askInput()));



    }

    public static TreeMap<String,String> askInput()
    {
        Scanner s= new Scanner(System.in);
        System.out.println(" \n rules for good String and name : \n 1<=len(good string)<=100 \n 1<=len(name)<=10^4 \n Good String will consist of lower ,upper case alphabets, digits and symbols \n Name will consist of only space, lower, upper, case alphabets \n Characters are case sensitive \n "+
                "The ASCII values for all the characters in the good string and name will be between 32 to 126 (both inclusive ) \n \nEnter Your Good String \n");
        String goodString = s.nextLine();
        System.out.println("Enter the Name : \n");
        String name = s.nextLine();

        TreeMap<String,String> map = new TreeMap<>();
        map.put(goodString,name);
        return map;
    }

    public void validateGoodString()
    {

    }

    public static boolean validateName(TreeMap<String,String> map)
    {

        String name = map.firstEntry().getValue();
        Set<Integer> setOfSymbolAsciiValuesNotAllowed = new TreeSet<>();
        for(int i=33,j=0;i<=126;i++)
        {
            if(i==48)
            {
                i=58;
            }
            if(i==65)
            {
                i=91;
            }
            if(i==97)
            {
                i=123;
            }
            setOfSymbolAsciiValuesNotAllowed.add(i);
        }
//        setOfSymbolAsciiValuesNotAllowed.forEach(System.out::println);
//        System.out.println(setOfSymbolAsciiValuesNotAllowed.size());
        for(char c:name.toCharArray())
        {
            if(setOfSymbolAsciiValuesNotAllowed.contains((int) c))
            {
                System.out.println("\n Not a VALID NAME! Special Symbol chars Except 'SPACE' isn't allowed \n");
                return false;
            }
        }


        System.out.println("\n Name is Valid according to the constraints");
        return true;

    }

//    public void finalizeName(String name)
//    {
//        if(validateName(name))
//        {
//
//
//        }
//
//
//
//    }

    public static void findDistance(Map<String,String> map)
    {


    }






}
