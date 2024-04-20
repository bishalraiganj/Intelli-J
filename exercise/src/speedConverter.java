public class speedConverter {

    public static void main(String[] args)
    {


        double kilometersPerHour=8d;
        toMilesPerHour(kilometersPerHour);
        printConversion(kilometersPerHour);
    }
    public static long toMilesPerHour(double kilometersPerHour )
    {

        if(kilometersPerHour <0)
        {

            return -1;
        }
        else
        {
            return (Math.round(kilometersPerHour *0.621371));
           
        }



    }

    public static void printConversion(double kilometersPerHour)
    {
        long toMilesPerHour =toMilesPerHour(kilometersPerHour);

        if(kilometersPerHour<0)
        {

            System.out.println("Invalid value");
            return;

        }
        else{
            System.out.println(kilometersPerHour +"km/h =" +toMilesPerHour+"mi/h");
        }
    }













}