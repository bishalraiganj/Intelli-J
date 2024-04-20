import java.util.Scanner;

public class SideItem {


    private String type;
    private double price;
 public double getPrice()
 {
     return price;
 }



    public SideItem() {

        System.out.printf("""
                Choose your SideItem :
                Enter     1 for French Fries @ 70rs
                Enter      2 for  Noodle @ 60rs 
                Enter     3 for nuggets @ 100rs
                Enter     4 for fried veggies @ 50rs\n\t""");

        Scanner s = new Scanner(System.in);
        int selectValue = Integer.parseInt(s.nextLine());
        type = switch (selectValue) {
            case 1 -> "French Fries";
            case 2 -> "Noodles";
            case 3 -> "Nuggets";
            case 4 -> "Fried veggies";
            default -> "French Fries";
        };

        price = switch (selectValue) {
            case 1 -> 70;
            case 2 -> 60;
            case 3 -> 100;
            case 4 -> 50;
            default -> 70;


        };


    }

    public void chooseSideItem()
    {

        System.out.printf("""
                Choose your SideItem :
                Enter     1 for French Fries @ 70rs
                Enter      2 for  Noodle @ 60rs 
                Enter     3 for nuggets @ 100rs
                Enter     4 for fried veggies @ 50rs\n\t""");

        Scanner s = new Scanner(System.in);
        int selectValue = Integer.parseInt(s.nextLine());
        type = switch (selectValue) {
            case 1 -> "French Fries";
            case 2 -> "Noodles";
            case 3 -> "Nuggets";
            case 4 -> "Fried veggies";
            default -> "French Fries";
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
        return "SideItem" +
                "type=" + type + '\'' +
                " price=" + price
                ;
    }



}
