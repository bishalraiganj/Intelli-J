import java.util.*;
import java.lang.*;
public class Main {
   private static  LinkedList<Towns> list = new LinkedList<>();
    public static void main(String[] args) {
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

        System.out.println(list+"\n\n");
        showMenu();
    }

public static void showMenu() {
    System.out.printf("""
            Available actions (select word or letter) :
            (F)orward
            (B)ackward
            (L)ist Places
            (M)enu
            (Q)uit
            """);
    Scanner s = new Scanner(System.in);
    var iterator = list.listIterator();
    boolean quitValue = false;
    boolean b = false;

    while (!quitValue)
    {
        if (!iterator.hasPrevious())
        {
            System.out.println("Originating :" + iterator.next());
        }
        if (!iterator.hasNext())
        {
            System.out.println("Final :" + iterator.previous());
        }
        String s1 = s.nextLine();
        String u = s1.toUpperCase();
        var l = s1.substring(0, 1).toUpperCase();

        if (l == "F" || l == "B" || l == "L" || l == "M" || l == "Q" || u == "FORWARD" || u == "BACKWARD" || u == "LIST PLACES" || u == "MENU" || u == "QUIT")

        {

            if (s1.length() == 1) {
                switch (l) {
                    case "F":
                        System.out.println("Going a step forward" + iterator.next());
                        break;

                    case "B":
                        System.out.println("Going a step backward" + iterator.previous());
                        break;
                    case "L":
                        System.out.println("Printing the List" + list);
                        break;
                    case "M":
                        System.out.println("Showing Menu");
                        showMenu();
                    case "Q":
                        System.out.println("Quitting");
                        quitValue = true;
                        break;

                }


            } else if (!(s1.length() == 1)) {


                switch (u) {
                    case "FORWARD":
                        System.out.println("Going a step forward :\n" + iterator.next());
                        break;

                    case "BACKWARD":
                        System.out.println("Going a step backward \n" + iterator.previous());
                        break;
                    case "LIST PLACES":
                        System.out.println("Printing the List" + list);
                        break;
                    case "MENU":
                        System.out.println("Showing Menu");
                        showMenu();
                    case "QUIT":
                        System.out.println("Quitting");
                        quitValue = true;
                        break;

                }

            }
        }
        else
        {
            System.out.println("Invalid Input  ! TRY AGAIN !");

            String s2 = s.nextLine();
            String u1 = s2.toUpperCase();
            var l1 = s1.substring(0, 1).toUpperCase();

            if (s2.length() == 1) {
                switch (l1) {
                    case "F":
                        System.out.println("Going a step forward" + iterator.next());
                        break;

                    case "B":
                        System.out.println("Going a step backward" + iterator.previous());
                        break;
                    case "L":
                        System.out.println("Printing the List" + list);
                        break;
                    case "M":
                        System.out.println("Showing Menu");
                        showMenu();
                    case "Q":
                        System.out.println("Quitting");
                        quitValue = true;
                        break;

                }


            } else if (!(s2.length() == 1)) {


                switch (u1) {
                    case "FORWARD":
                        System.out.println("Going a step forward :\n" + iterator.next());
                        break;

                    case "BACKWARD":
                        System.out.println("Going a step backward \n" + iterator.previous());
                        break;
                    case "LIST PLACES":
                        System.out.println("Printing the List" + list);
                        break;
                    case "MENU":
                        System.out.println("Showing Menu");
                        showMenu();
                    case "QUIT":
                        System.out.println("Quitting");
                        quitValue = true;
                        break;

                }

            }

        }
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
            return   "Place :"+
                    "name= " + name +
                    " distance= " + distance
                    ;
        }
    }
