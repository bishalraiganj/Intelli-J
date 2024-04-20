public abstract class ProductForSale {
private  String type=getClass().getSimpleName();

private int productCount;
private double price;
private String description;
public String getType()
{
    return type;

}
public int getProductCount()
{

    return productCount;
}
public double getPrice()
{
    return price;
}
public String getDescription()
{
    return description;

}
public ProductForSale(double price,String description,int productCount)
{   this.productCount=productCount;

    this.price=price;
    this.description=description;
}
public abstract void showDetails();


}
