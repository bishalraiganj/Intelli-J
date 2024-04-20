import java.util.Scanner;

public class Drink {

    private String type;
    private double price;

    public double getPrice() {
        return price;
    }

    public Drink() {

//        System.out.printf("""
//                Choose your Drink :
//                Enter     1 for Coca-Cola @ 70rs
//                Enter      2 for  Pepsi @ 60rs
//                Enter     3 for Fruit Drink @ 100rs
//                Enter     4 for Lemon Soda @ 50rs\n\t""");
//
//        Scanner s = new Scanner(System.in);
//        int selectValue = Integer.parseInt(s.nextLine());
//        type = switch (selectValue) {
//            case 1 -> "Coca-cola";
//            case 2 -> "Pepsi";
//            case 3 -> "Fruit drink";
//            case 4 -> "Lemon soda";
//            default -> "Lemon Soda";
//        };
//
//        price = switch (selectValue) {
//            case 1 -> 70;
//            case 2 -> 60;
//            case 3 -> 100;
//            case 4 -> 50;
//            default -> 70;
//
//
//        };
//

    }
 public void chooseDrink() {
     System.out.printf("""
             Choose your Drink :
             Enter     1 for Coca-Cola @ 70rs
             Enter      2 for  Pepsi @ 60rs 
             Enter     3 for Fruit Drink @ 100rs
             Enter     4 for Lemon Soda @ 50rs\n\t""");

     Scanner s = new Scanner(System.in);
     int selectValue = Integer.parseInt(s.nextLine());
     type = switch (selectValue) {
         case 1 -> "Coca-cola";
         case 2 -> "Pepsi";
         case 3 -> "Fruit drink";
         case 4 -> "Lemon soda";
         default -> "Lemon Soda";
     };

     price = switch (selectValue) {
         case 1 -> 70;
         case 2 -> 60;
         case 3 -> 100;
         case 4 -> 50;
         default -> 70;


     };
 }



    @Override
    public String toString() {
        return "Drink" +
                "type=" + type + '\'' +
                "price=" + price
               ;
    }
}




