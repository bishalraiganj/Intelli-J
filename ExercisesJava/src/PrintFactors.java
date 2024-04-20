public class PrintFactors {
 public static void main(String[] args)
 {

     printFactors(99);
 }


        public static void printFactors(int number)
        {

            if(number<1)
            {
                System.out.println("Invalid Value");
            }
            int i;
            for(i=1;i<=number;i++)
            {
                if(number%i==0)
                {
                 System.out.println(i);
                }


            }
        }
    }



