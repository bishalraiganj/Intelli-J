import java.util.*;



public class Main {

    public static void main(String[] args)
    {
        String goodString = "6*K4AQf]gpi";
        String name = "Nainika";
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



        for(Character c : nameList)
        {
            for(Character c2 : goodStringList)
            {




            }
        }


    }

    public void findDistance(List<Character> goodStringList, List<Character> nameList)
    {
        List<Character> goodList = new ArrayList<>();
        for(char c : nameList)
        {
            Map<Character,Integer> map = new TreeMap<>(new Comparator(){

                @Override
                public int compare(Object o1,Object o2)
                {
                  if(Math.abs((int ) o1)-Math.abs((int) c )==Math.abs((int ) c)-Math.abs((int) o2 ))
                  {
                      return 1;
                  }
                  if(Math.abs((int ) o1)-Math.abs((int) c )>Math.abs((int ) c)-Math.abs((int) o2 ))
                    return 1;
                  return -1;
                };


            });
            for(char d : goodStringList)
            {



            }
        }
    }


}
