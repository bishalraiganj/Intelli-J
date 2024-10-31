package Adhikary.X;

import java.util.*;

public class Main {

    public static void main(String... args)
    {



        findDistance(askInput());








    }

    private static Map<String,String> askInput()
    {
        Scanner s = new Scanner(System.in);
        System.out.println(" \n rules for good String and name : \n 1<=len(good string)<=100 \n 1<=len(name)<=10^4 \n Good String will consist of lower ,upper case alphabets, digits and symbols \n Name will consist of only space, lower, upper, case alphabets \n Characters are case sensitive \n "+
                "The ASCII values for all the characters in the good string and name will be between 32 to 126 (both inclusive ) \n \nEnter Your Good String \n");

        String goodString =  s.nextLine();
//        if(goodString.length()<=100&&goodString.length()>=1&&goodString.chars().anyMatch((ch)->{ return "abcdefghijklmnopqrstuvwxyz".indexOf(ch)>=0
//        && "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch)>=0;}));



        System.out.println("Enter Your name");
        String name = s.nextLine();

        if(name.length()<=10*10*10*10&&name.length()>=1)
        {
            boolean symbolRange1= false;
            boolean symbolRange2= false;
            boolean symbolRange3= false;
            boolean symbolRange4= false;
            boolean anySymbolRange= false;
            for(int i=33;i<=47;i++)
            {
                if(name.contains(String.valueOf((char) i)))
                {
                    symbolRange1= true;
                    anySymbolRange=true;
                    break;
                }
            }
            for(int i=58;i<=64;i++)
            {
                if(name.contains(String.valueOf((char) i))&&!anySymbolRange)
                {
                    symbolRange2=true;
                    anySymbolRange=true;
                    break;
                }
            }
            for(int i=91;i<=96;i++)
            {
                if(name.contains(String.valueOf((char) i))&&!anySymbolRange)
                {
                    symbolRange3=true;
                    anySymbolRange=true;
                    break;
                }
            }
            for(int i=123;i<=126;i++)
            {
                if(name.contains(String.valueOf((char) i))&&!anySymbolRange)
                {
                    symbolRange4=true;
                    anySymbolRange=true;
                    break;
                }
            }

            if(!anySymbolRange)
            {
                Map<String,String> map = new TreeMap<>();
                map.put(goodString,name);
                System.out.println("Constraints followed Returning the map ");
                return map;

            }

        }


        System.out.println("Constraints not followed");
        return null;


    }

    private static void findDistance(Map<String,String> map)
    {
        for(Map.Entry<String,String> entry : map.entrySet())
        {
            String goodString = entry.getKey();
            String name = entry.getValue();

            char[] gsArr = goodString.toCharArray();
            char[] nArr = name.toCharArray();

            char previousSelect;
            int psInt=0;
            int distance =0;


            for(char n:nArr)
            {

                Set<Integer>  equiDistantArr= new HashSet<>();
                int indexCounter=1;
               List<Integer> asciiValues = new ArrayList<>();
                for(char g:gsArr)
                {
                           asciiValues.add((int) g);
                }

                for(int g:asciiValues)
                {
                    if(indexCounter==1)
                    {
                        psInt=g;
                    }
                    if((Math.abs(((int) n)-psInt)>Math.abs(n-g))&&indexCounter>1)
                    {
                        psInt=g;

                    }
                    if(indexCounter>1&&(Math.abs((int)n-g))==Math.abs((int) n-psInt))
                    {
                        equiDistantArr.add(g);
                        equiDistantArr.add(psInt);

                    }
                    indexCounter++;
                }

                if(!equiDistantArr.isEmpty())
                {
                    int v=0;
                    int r;
                    int ic=1;

                    for(int i:equiDistantArr)
                    {
                        if(ic==1)
                        {
                            v=Math.abs((int) n -i);
                            r=i;
                        }
                        if(v>Math.abs(((int) n)-i)&&ic>1)
                        {
                            v=Math.abs((int) n-i);

                        }


                    }

                    distance+=v;
                    continue;
                }
                distance+=Math.abs((int) n -psInt);
            }

            System.out.println("distance is :"+distance);
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
