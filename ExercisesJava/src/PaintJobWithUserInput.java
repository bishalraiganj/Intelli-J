import java.util.Scanner;

public class PaintJobWithUserInput {

    public static void main(String[] args)

    {
       System.out.println( "Bucket Count required to paint the area is :"+getBucketCount());
    }
    public static int getBucketCount ( )
    {
        Scanner scanner=new Scanner(System.in);

        double dwidth=0,dheight=0,darea=0,nbc;
        int id,extraBuckets,nbc2;
        System.out.println("Enter the Width of the Wall :");

       {     for(int i=0;true;i++) {


           try {
               String swidth = scanner.nextLine();
               dwidth = Double.parseDouble(swidth);
               break;
           } catch (NumberFormatException e) {
               System.out.println("Enter a valid value");

           }
       }
       }
         for(int i=0;true;i++)
         {
             try {
                 System.out.println("Enter the height of the Wall :");
                 String s2width = scanner.nextLine();
                 dheight = Double.parseDouble(s2width);
                 break;
             } catch (NumberFormatException e) {

                 System.out.println("Enter a valid value such as a number :");
             }
         }
         for(int i=0;true;i++)
         {          System.out.println("Enter the area that a single paint bucket covers :");
               try {
                   String s3area = scanner.nextLine();
                   darea = Double.parseDouble(s3area);
                   break;
               }
               catch(NumberFormatException e) {
                   System.out.println("Invalid value enter a number");
               }
       }
         for(int i=0;true;i++) {
             System.out.println("Enter the value of extra buckets :");
             String s = scanner.nextLine();
             try {
                 extraBuckets = Integer.parseInt(s);
                 break;
             } catch (NumberFormatException e) {

                 System.out.println("Enter valid input such as a Number !");
             }
         }
         nbc=(dwidth*dheight)/darea;
         nbc2=(int) nbc;
         if(nbc-nbc2>0) {

             ++nbc2;
         }
         System.out.println("width :"+dwidth+"\n"+"height :"+dheight+" \n"+"Bucket paint  area :"+darea+" \nrequired bucket count :"+nbc2+"\n"+" Extra buckets :"+extraBuckets);
         if(nbc2==extraBuckets)
         {
             return nbc2;
         }
         if(nbc2>extraBuckets)
         {

             return nbc2-extraBuckets;
         }

   return 0;
}

       }

