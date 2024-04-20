import java.util.*;
public class Main {

    Scanner s=new Scanner(System.in);
    List<String> list=new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner s=new Scanner(System.in);
        List<String> list1=new ArrayList<>();

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

                System.out.println("Enter the items separate by comma");
                String s1=s.nextLine();
                s1=s.nextLine();
                String[] sArray=(s1.split(","));
                list1=new ArrayList<>(List.of(s1.split(",")));
                for(String i,list1)
                {



                }





            }


        }


    }



}
