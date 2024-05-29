package dev.lpa.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;
    public double conversionRate;
    public Meal()
    {
        this(1);
    }
    public Meal(double conversionRate)
    {
        this.conversionRate = conversionRate;
        this.burger = new Burger("name");
        this.drink = new Item("coke","drink",1.5);
        System.out.println(drink.name);
        this.side = new Item("fries","side",2.0);
    }

    public double getTotal()
    {

        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total,conversionRate);
    }
    @Override
    public String toString()
    {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger,drink,side,"Total Due",getTotal());
    }

    private class Item{
        private String name;
        private String type;
        private double price;


    public Item(String name,String type,double price)
    {
        this.name = name;
        this.type = type;
        this.price = price;
    }
    public Item(String name,String type)
    {
        this(name,type,type.equals("burger")?Meal.this.price:0);
    }
    @Override
    public String toString()
    {

        return "%10s%15s $%.2f".formatted(type,name,getPrice(price,conversionRate));

    }
    private static double  getPrice(double price,double rate)
    {
        return price*rate;
    }
    }

    public class Burger extends Item{

       private enum Extra{AVOCADO,BACON,CHEESE,KETCHUP,MAYO,MUSTARD,PICKLE;

       private double getPrice()
       {

           return switch(this){

               case AVOCADO -> 1.0;
               case BACON,CHEESE -> 1.5;
               default -> 0;
           };



       }



       }
        private List<Item> toppings = new ArrayList<>();
        Burger(String name)
        {
        super(name,"burger",50.0);
        }
    public double getPrice()
    {

        return super.price;
    }

    private void addToppings(String... selectedToppings)
    {
        for(String selectedTopping:selectedToppings)
        {
            Extra topping = Extra.valueOf(selectedTopping.toUpperCase());
            {
                toppings.add(new Item(Extra.valueOf(selectedTopping.toUpperCase()).name(),"TOPPING",topping.getPrice()));
            }


        }



    }







    }




}
