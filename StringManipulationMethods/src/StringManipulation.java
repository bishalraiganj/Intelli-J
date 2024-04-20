public class StringManipulation {


    public static void main(String[] args)
    {

        String birthDate="25/11/1982";
        int startingIndex=birthDate.indexOf("1982");
        System.out.println(" Starting Index = "+startingIndex);
        System.out.println("Birth Year ="+birthDate.substring(startingIndex));
        System.out.println("Month ="+birthDate.substring(3,5));
       
    }
}
