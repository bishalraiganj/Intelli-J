package Adhikary.X;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {





    }

    public Map<String,String> askInput()
    {
        Scanner s= new Scanner(System.in);
        System.out.println(" \n rules for good String and name : \n 1<=len(good string)<=100 \n 1<=len(name)<=10^4 \n Good String will consist of lower ,upper case alphabets, digits and symbols \n Name will consist of only space, lower, upper, case alphabets \n Characters are case sensitive \n "+
                "The ASCII values for all the characters in the good string and name will be between 32 to 126 (both inclusive ) \n \nEnter Your Good String \n");
        String goodString = s.nextLine();
        System.out.println("Enter the Name : \n");
        String name = s.nextLine();

        Map<String,String> map = new HashMap<>();
        map.put(goodString,name);
        return map;
    }

    public void validateGoodString()
    {

    }

    public boolean validateName(String name)
    {
        Set<Integer> setOfSymbolCharsNotAllowed = new HashSet<>();
        for(int i=33,j=0;i<=30&&i<=126;i++)
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
                i=122;
            }
            setOfSymbolCharsNotAllowed.add(i);
        }




    }

    public void findDistance(Map<String,String> map)
    {


    }






}
