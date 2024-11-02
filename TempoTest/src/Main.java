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

        System.out.println("\n");

        findDistance(goodStringList,nameList);
    }

    public static  void findDistance(List<Character> goodStringList, List<Character> nameList)
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
                    sDistanceMap.putIfAbsent(c3,Math.abs((int) c-(int) c3));
                 }

                 goodList.add(sDistanceMap.firstKey());

                }
                else
                    goodList.add(firstChar);
        }

                goodList.forEach(System.out::print);


    }


}
