public class IsEvenNumber {

    public static void main(String[] args)
    {   int i=5,j=0,unEvenCount=0;
        while(i<=20)
        { i++;

            if (isEvenNumber(i)) {

                System.out.println("Number serial index :"+j+" Even number is:"+i);
                j++;
                continue;
            }
           unEvenCount+=1;

            if(j>=5)
            {
                break;
            }


        }
        System.out.println("Total number of even numbers found is :"+j+" Total number of Odd Numbers found is :"+unEvenCount);
    }
    public static boolean isEvenNumber(int number)
    {
        if(number%2==0) {
            return true;
        }
        return false;
    }
}
