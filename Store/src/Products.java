public abstract class Products {

    protected String type;
    protected String description;
   protected double price;
    public Products(String type,String description,double price)
    {
        this.type=type;
        this.description=description;
        this.price=price;
    }
public abstract void showDetails();
public double salesPrice(int quantity)
{
    return quantity*price;

}
public void printPricedItem(int qty)
{
    System.out.printf("%2d qty at $%8.2f each,%-15s %-35s %n",qty,price,type,description);


}
}
