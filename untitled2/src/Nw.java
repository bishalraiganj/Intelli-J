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
                    String[] sArray = s1.split(",");
                    aList = new ArrayList(Arrays.asList(sArray));
                    System.out.println("The list after adding the items is : " + aList);
                }

            }
        }
        while(n!=1&&n!=2&&n!=0);


    }
}
