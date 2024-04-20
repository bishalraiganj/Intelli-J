import java.util.LinkedList;
import java.util.Scanner;


public class Temp{

    public static void main(String[] args) {

        LinkedList<Towns> list = new LinkedList<>();
//         var iterator=list.listIterator();
//         iterator.add(new Towns("Adelaide",1374));
//         iterator.add(new Towns("Alice Springs", 2771));
//         iterator.add(new Towns("Brisbane",917));
//         iterator.add(new Towns("Darwin", 3972)) ;
//         iterator.add(new Towns("Melbourne",877));
//         iterator.add(new Towns("Perth",3923));
//         System.out.println(list);
//         boolean b=true;
//        Scanner s=new Scanner(System.in);
//        String l;String i;
//         do{
//             System.out.printf("""
//                     Available actions (Select Word or Letter):
//                     (F)orward
//                     (B)ackward
//                     (L)ist Places
//                     (M)enu
//                     (Q)uit
//                     """);
//            l=s.nextLine();
//            i=l.substring(0,1);
//            switch(switch(i)
//            {
//                case "F"->"Forward";
//                case "B"->"Backward";
//                case "L"->"List Places";
//                case "M"->"Menu";
//                case "Q"->"Quit";
//                default->"";
//            }
//            )
//            {
//   case l=="Forward"->
//   case l=="Backward"->
//       case
//
//
//            }
//
//
//
//         }while(b==true);


        System.out.println(list);
        addPlaces(list, new Towns("Btown", 779));
        System.out.println(list);
        addPlaces(list, new Towns("bTown", 89));

        addPlaces(list,new Towns("ltown",900));
        System.out.println(list);
        addPlaces(list,new Towns("lol",700));
        addPlaces(list,new Towns("newTown",711));

        System.out.println(list);
    }

    public static void showMenu()
    {
        System.out.printf("""
            Available actions (select word or letter) :
            (F)orward
            (B)ackward
            (L)ist Places
            (M)enu
            (q)uit
            """);
        Scanner s=new Scanner(System.in);
        String sl=s.nextLine();
        switch(sl)
        {
            case sl.charAt(0).



        }








    }
    public static void addPlaces(LinkedList<Towns> list, Towns tweens) {
        for (Towns i : list) {

            if (i.name().equalsIgnoreCase(tweens.name())) {
                System.out.printf("Duplicate found :%s\n" ,i);
                return;
            }
        }int c=0;
        int count=0;
        for(Towns i:list)
        {
            if(i.distance()<tweens.distance())
            {   System.out.println("\nControl is here \n");
                if(list.indexOf(i)+1==list.size())
                {
                    list.add(tweens);
                    return;
                }
                count++;
            }

            list.add(count,tweens);
            return;
        }
        if(c==0) {
            list.add(tweens);
            c++;
        }
    }
}
record Towns(String name, double distance) {

    @Override
    public String toString() {
        return "Towns{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}