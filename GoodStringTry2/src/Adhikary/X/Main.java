package Adhikary.X;

import com.sun.source.tree.Tree;

import java.util.*;

public class Main {

    public static void main(String[] args)
    {

      finalizeName(( validateName(askInput())));



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

    public static TreeMap<String,String> validateName(TreeMap<String,String> map)
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
                return null;
            }
        }


        System.out.println("\n Name is Valid according to the constraints");
        return map;

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

    public static void finalizeName(TreeMap<String,String> map){



        String goodString = map.firstEntry().getKey();
        String name = map.firstEntry().getValue();
//        char[] goodStringArr  = goodString.toCharArray();
//        char[] nameArr =  name.toCharArray();
//
//        Set<Character> goodStringSet = new LinkedHashSet<>();
//        for(char c:goodStringArr)
//        {
//            goodStringSet.add(c);
//        }
//        Set<Character> nameSet = new LinkedHashSet<>();
//        for(char c:nameArr)
//        {
//            nameSet.add(c);
//        }
//        Set<Character> retainedSet = new LinkedHashSet<>(goodStringSet);
//        retainedSet.retainAll(goodStringSet);
//
//        Set<Character> finalNameSet = new LinkedHashSet<>(nameSet);
//        finalNameSet.removeAll(retainedSet);
//
//        finalNameSet.forEach(System.out::print);

        List<Character> goodStringList  = new ArrayList<>();
        for(char c : goodString.toCharArray())
        {
            goodStringList.add(c);
        }
        List<Character> nameList = new ArrayList<>();
        for(char c: name.toCharArray())
        {
            nameList.add(c);
        }
        nameList.removeIf((k)-> goodStringList.contains(k));

        nameList.forEach(System.out::print);

        System.out.println("\n");

        findDistance(goodStringList,nameList);






    }

    public static void findDistance(List<Character>  goodStringList,List<Character> nameList)
    {


        char previousSelect='\u0000';
        List<Character> goodList = new ArrayList<>();
        for(char c : nameList)
        {
            List<Character> sDistance = new ArrayList<>();
            TreeMap<Character,Integer> map = new TreeMap<>(new Comparator(){

                @Override
                public int compare(Object o1,Object o2)
                {
                    char i1 = (char) o1;
                    char i2 = (char) o2;
                    if(Math.abs((int ) i1-(int) c )==Math.abs((int ) c-(int) i2 ))
                    {
                        return 1;
                    }
                    if(Math.abs((int ) i1-(int) c )>Math.abs((int ) c-(int) i2 ))
                        return 1;
                    return -1;
                };
            });

//            System.out.println("\n");

            for(char d : goodStringList)
            {
                map.putIfAbsent(d,Math.abs((int) c-(int) d));
            }
//                goodList.add(map.firstKey());
            map.forEach((k, v) -> System.out.print("Key :" + k + " Value :" + v + " "));

            System.out.println("");

//                goodList.forEach(System.out::print);

            if(previousSelect == '\u0000')
            {
                previousSelect = map.firstKey();
            }
            char firstChar = map.pollFirstEntry().getKey();
            while(firstChar ==map.firstKey())
            {
                sDistance.add(firstChar);
                sDistance.add(map.firstKey());
                firstChar = map.pollFirstEntry().getKey();
            }
            if(!sDistance.isEmpty())
            {
                TreeMap<Character,Integer> sDistanceMap = new TreeMap<>((Comparator)(o1,o2)-> {

                    if(Math.abs((int ) o1-(int) c )==Math.abs((int ) c-(int) o2 ))
                    {
                        return 0;
                    }
                    if(Math.abs((int ) o1-(int) c )>Math.abs((int ) c-(int) o2 ))
                        return 1;
                    return -1;

                });
                for(char c3 : sDistance)
                {
                    sDistanceMap.putIfAbsent(c3,Math.abs((int) previousSelect-(int) c3));
                }

                goodList.add(sDistanceMap.firstKey());
                previousSelect=sDistanceMap.firstKey();

            }
            else
                goodList.add(firstChar);
                previousSelect=firstChar;
        }

        goodList.forEach(System.out::print);


    }






}
