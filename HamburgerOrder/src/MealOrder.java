
public class MealOrder {

    private Burger burger;
    private Drink drink;
    private SideItem  sideItem;
    public double tp;
    public MealOrder()
    { burger =new Burger();
        drink=new Drink();
       this.sideItem=new SideItem();
        burger.choose();
        drink.chooseDrink();
        sideItem.chooseSideItem();

    tp= burger.getPrice()+drink.getPrice()+sideItem.getPrice();
    }

    @Override
    public String toString() {
        return "MealOrder is :\t" +
                " " + burger +"  burger\n" +
                " " + drink+"  Drink\n" +
                "" + sideItem +
                " totalPrice="+tp
                ;
    }
}
