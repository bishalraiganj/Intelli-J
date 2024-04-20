import java.util.Scanner;


public class Burger  {

    private String type;
    private double price;
    private int toppingCount;


    public Burger() {
//        Scanner s = new Scanner(System.in);
//        System.out.printf("""
//                                          Choose your burger :
//                                          Enter     1 for Veg Burger @ 80rs
//                                          Enter      2 for  Non-veg burger @ 160rs
//                                          Enter     3 for Cheese  Veg burger @ 100rs
//                                          Enter     4 for Burger Deluxe @ 500rs\n\t""");
//        int selectValue = Integer.parseInt(s.nextLine());
//        if (selectValue != 4) {
//            System.out.printf("""
//                                              How many toppings do you want :
//                                              Enter     1 for 1 toppings
//                                              Enter      2 for 2 toppings
//                                              Enter     3 for 3 toppings
//                                              \n\t
//                                              """);
//        } else {
//
//            System.out.printf("""
//                    select topping each @50rs extra  :" +
//                    "                          Enter     1 for 1 topping" +
//                    "                          Enter      2 for 2 toppings" +
//                    "                          Enter     3 for 3 toppings" +
//                    "                          Enter     4 for 4 toppings" +
//                    "                          Enter     5 for 5 toppings\n\t
//                    """);
//        }
//
//        int sv2 = Integer.parseInt(s.nextLine());
//        toppingCount = sv2;
//        type = switch (selectValue) {
//            case 1 -> "Veg burger";
//            case 2 -> "Non- veg burger";
//            case 3 -> "Cheese Veg burger";
//            case 4 -> "Burger deluxe";
//            default -> "veg burger";
//        };
//        this.price = switch (selectValue) {
//            case 1 -> 80 + sv2 * 50;
//            case 2 -> 160 + sv2 * 50;
//            case 3 -> 100 + sv2 * 50;
//            case 4 -> 500 + sv2 * 50;
//            default -> 80 + sv2 * 50;
//        };
    }
    public void choose()
    {
        Scanner s = new Scanner(System.in);
        System.out.printf("""
                                          Choose your burger :
                                          Enter     1 for Veg Burger @ 80rs
                                          Enter      2 for  Non-veg burger @ 160rs 
                                          Enter     3 for Cheese  Veg burger @ 100rs
                                          Enter     4 for Burger Deluxe @ 500rs\n\t""");
        int selectValue = Integer.parseInt(s.nextLine());
        if (selectValue != 4) {
            System.out.printf("""
                                              How many toppings do you want :
                                              Enter     1 for 1 toppings
                                              Enter      2 for 2 toppings
                                              Enter     3 for 3 toppings
                                              \n\t
                                              """);
        } else {

            System.out.printf(""" 
                    select topping each @50rs extra  :" +
                    "                          Enter     1 for 1 topping" +
                    "                          Enter      2 for 2 toppings" +
                    "                          Enter     3 for 3 toppings" +
                    "                          Enter     4 for 4 toppings" +
                    "                          Enter     5 for 5 toppings\n\t
                    """);
        }

        int sv2 = Integer.parseInt(s.nextLine());
        toppingCount = sv2;
        type = switch (selectValue) {
            case 1 -> "Veg burger";
            case 2 -> "Non- veg burger";
            case 3 -> "Cheese Veg burger";
            case 4 -> "Burger deluxe";
            default -> "veg burger";
        };
        this.price = switch (selectValue) {
            case 1 -> 80 + sv2 * 50;
            case 2 -> 160 + sv2 * 50;
            case 3 -> 100 + sv2 * 50;
            case 4 -> 500 + sv2 * 50;
            default -> 80 + sv2 * 50;
        };



    }
    public double getPrice()
    {
        return price;
    }
    public String getType()
    {
        return type;
    }
    public int toppiingCount()
    {
        return toppingCount;
    }
    @Override
    public String toString() {
        return "Burger" +
                "type='" + type + '\'' +
                " price=" + price +
                " toppingCount=" + toppingCount
              ;
    }

}
