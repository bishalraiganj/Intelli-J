public class Main {

public static void main(String[] args)
{

CoffeeMaker coffeeMaker=new CoffeeMaker();
Refrigerator refrigerator=new Refrigerator();
DishWasher dishWasher=new DishWasher();
SmartKitchen smartKitchen=new SmartKitchen(refrigerator,coffeeMaker,dishWasher);



smartKitchen.getIceBox().setHasWorkToDo(true);
smartKitchen.getBrewMaster().setHasWorkToDo(true);
smartKitchen.getDishWasher().setHasWorkToDo(true);
smartKitchen.getIceBox().orderFood();
smartKitchen.getBrewMaster().brewCoffee();
smartKitchen.getDishWasher().doDishes();

}



}
