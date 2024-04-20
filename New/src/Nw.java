import java.util.*;



public class Nw {
    public static void main(String[] args)
    {   int n;
        ArrayList<String> aList=new ArrayList<> ();
        Scanner s= new Scanner(System.in);
        String s1;
        do{
        System.out.printf("""
                   Enter :
                         0 for shut down:
                         1 for adding elements in a comma delimmitted list:
                         2 for removing enter the eliments in a comma delimitted list:
                   
                   
                   """);
         n=s.nextInt();
        if(n==1||n==2||n==0) {
            if (n == 1) {
                System.out.printf("Enter the comma delimitted list of items to add :\n");

                s1 = s.nextLine();
                s1=s.nextLine();
                String[] sArray = s1.split(",");
                if(Arrays.asList(sArray).containsAll(Arrays.asList(sArray)))
                {
                    break;
                }
                aList = new ArrayList(Arrays.asList(sArray));
                System.out.println("The list after adding the items is : " + aList);
            }
            if(n==2)
            {
                System.out.println("Enter the comma delimitted list of items to be removed :");
                s1=s.nextLine();
                String[] sArray = s1.split(",");
               List<String> c=Arrays.asList(sArray);
                removeItems(c);



            }

        }
        }
        while(n!=1&&n!=2&&n!=0);


    }
}
