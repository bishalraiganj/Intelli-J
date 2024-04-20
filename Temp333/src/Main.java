import java.util.LinkedList;
import java.util.List;


public class Main {


    public static void main(String[] args)
    {Towns t=new Towns("bi",778);
        List<Towns> list=new LinkedList<>();
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

        list.add(t);
        System.out.println(list);
        addPlaces(list,new Towns("Btown",778));
        System.out.println(list);
        addPlaces(list,new Towns("bTown",770));
        System.out.println("This is the List :"+list);



    }


    public  static void addPlaces(List<Towns> list,Towns towns)
    {
        for(Towns i:list)
        {
            if(i.name().equalsIgnoreCase(towns.name()))
            {
                System.out.printf("Duplicate found :"+i);
                return;

            }
            if(i.distance()<towns.distance())
            {
                list.add(towns);
                return;
            }if(list.indexOf(i)==0){
            list.add(towns);
        }
            list.add(towns);
        }

    }
}
record Towns (String name,double distance){

    @Override
    public String toString() {
        return "Towns{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                '}';
    }
}