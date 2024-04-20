public class SmartKitchen {
  private Refrigerator iceBox;
  private CoffeeMaker brewMaster;
   private DishWasher dishWasher;

public SmartKitchen(Refrigerator refrigerator,CoffeeMaker coffeeMaker,DishWasher dishWasher)
{
    iceBox=refrigerator;
    brewMaster=coffeeMaker;
    this.dishWasher=dishWasher;
}
public Refrigerator getIceBox()
{
    return iceBox;
}
public CoffeeMaker getBrewMaster()
{
    return brewMaster;
}
public DishWasher getDishWasher()
{
    return dishWasher;
}
public void addWater()
{
    brewMaster.setHasWorkToDo(true);
}
public void pourMilk()
{
    iceBox.setHasWorkToDo(true);
}
public void loadDishwasher()
{
    dishWasher.setHasWorkToDo(true);
}


public void setKitchenState()
{
    brewMaster.setHasWorkToDo(true);
    iceBox.setHasWorkToDo(true);
    dishWasher.setHasWorkToDo(true);


}


}
class Refrigerator{

    private boolean hasWorkToDo;
public void setHasWorkToDo(boolean hasWorkToDo)
{
    this.hasWorkToDo=hasWorkToDo;

}
public void  orderFood()
{    if(hasWorkToDo)
    System.out.println(" Ordering Food");
    hasWorkToDo=false;

}

}


class CoffeeMaker{

    private boolean hasWorkToDo;
    public void setHasWorkToDo(boolean hasWorkToDo)
    {

        this.hasWorkToDo=hasWorkToDo;
    }


    public void brewCoffee()
    {    if(hasWorkToDo)
        System.out.println("Brewing Coffee");
    }


}
class DishWasher{
    private boolean hasWorkToDo;
public void setHasWorkToDo(boolean hasWorkToDo)
{
    this.hasWorkToDo=hasWorkToDo;
}

public void doDishes()
{
    if(hasWorkToDo)
    {
        System.out.println(" Doing Dishes");

    }

}

}