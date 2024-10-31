package Adhikary.X;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String... args)
    {


        askInput();






    }

    private static Map<String,String> askInput()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the Good String \n rules : \n 1<=len(good string)<=100 \n 1<=len(name)<=10^4 \n Good String will consist of lower ,upper case alphabets, digits and symbols \n Name will consist of only space, lower, upper, case alphabets \n Characters are case sensitive \n "+
                "The ASCII values for all the characters in the good string and name will be between 32 to 126 (both inclusive ) \n");

        String goodString =  s.nextLine();
//        if(goodString.length()<=100&&goodString.length()>=1&&goodString.chars().anyMatch((ch)->{ return "abcdefghijklmnopqrstuvwxyz".indexOf(ch)>=0
//        && "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch)>=0;}));



        System.out.println("Enter Your name");
        String name = s.nextLine();
        Map<String,String> map = new TreeMap<>();
        map.put(goodString,name);
        return map;
    }

    private static void findDistance(Map<String,String> map)
    {
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            String goodString = entry.getKey();
            String name = entry.getValue();



        }



    }


    private boolean upperLowerDigitSymbolCheck(String goodString)
    {

      if(goodString.length()<=100&&goodString.length()>=1)
        {
            boolean lowerCasePresent= false;
            boolean upperCasePresent= false;
            boolean digitPresent=false;
            boolean symbolPresent=false;

            for(int i=97;i<=122;i++)
            {
                if(goodString.contains(String.valueOf((char) i)))
                {
                    lowerCasePresent =true;
                    break;
                }
            }

            for(int i = 65;i<=90;i++)
            {
                if(goodString.contains(String.valueOf((char) i)))
                {
                    upperCasePresent = true;
                    break;
                }
            }

            for(int i=48;i<=57;i++)
            {
                if(goodString.contains(String.valueOf((char) i)))
                {
                    digitPresent = true;
                    break;
                }
            }

            boolean anySymbolPresent = false;
            for(int i=32;i<=47;i++)
            {
                if(goodString.contains(String.valueOf((char) i)))
                {
                    symbolPresent=true;
                    anySymbolPresent = true;
                    break;
                }
            }

            for(int i = 58;i<=64;i++)
            {
                if(goodString.contains(String.valueOf((char) i))&&!anySymbolPresent)
                {
                    symbolPresent=true;
                    anySymbolPresent = true;
                    break;
                }
            }
            for(int i = 91;i<=97;i++)
            {
                if(goodString.contains(String.valueOf((char) i))&&!anySymbolPresent)
                {
                    symbolPresent=true;
                    anySymbolPresent=true;
                    break;
                }
            }
            for(int i= 122;i<=126;i++)
            {
                if(goodString.contains(String.valueOf((char) i))&&!anySymbolPresent)
                {
                    symbolPresent= true;
                    break;
                }
            }

            if(lowerCasePresent&&upperCasePresent&&digitPresent&&symbolPresent)
            {

                return true;
            }


        }
      return false;

    }

}
