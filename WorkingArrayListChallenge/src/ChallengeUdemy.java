
import java.util.*;
public class ChallengeUdemy {

    private static  Scanner s=new Scanner(System.in);
    private static List<String> list=new ArrayList<>();

    public static void main(String[] args)
    {



        boolean b=true;
         while(b)
         {
            String textBlock= """
                    Enter any integer to choose from :
                                                      0 for shut down
                                                      1 for adding items( comma delimited lis)
                                                      2 for removing items(comma delimited list)
                    
                    
                    """;
             System.out.println(textBlock);
             int i1=s.nextInt();
             if(i1==1)
             {

               addItems();

             }
             if (i1 ==2)
             {

     removeItems();

             }
             if(i1==0)
             {
                 b=false;

             }

         }


    }
    public static void addItems()
    {

        System.out.println("Enter the items ( Separate by commas)");
        s.nextLine();
        String[] sArray=s.nextLine().split(",");
        for(String i:sArray)
        {
            String trimmed=i.trim();
            if(list.indexOf(trimmed)<0)
            {
                list.add(trimmed);

            }


        }
System.out.println(list);
    }
    public static void removeItems()
    {

        System.out.println("Enter the items to remove (Separate by comma");
        s.nextLine();
        String[] s1=s.nextLine().split(",");
        list.removeAll(Arrays.asList(s1));

System.out.println(list);

    }


}
