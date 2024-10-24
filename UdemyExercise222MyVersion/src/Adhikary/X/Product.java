package Adhikary.X;

public class Product implements Comparable<Product> {

    private String sku;
    private String name;
    private  String manufacturer;
    private  String category;

    public Product(String sku, String name, String manufacturer, String category)
    {
        this.sku = sku;
        this.name = name;
        this.manufacturer = manufacturer;
        this.category = category;
    }

    public String getSku()
    {
        return sku;
    }

    public String getName()
    {
        return name;
    }

    public String getManufacturer()
    {
        return manufacturer;
    }

    public String getCategory()
    {
        return category;
    }

    @Override
    public String toString()
    {
        return  "SKU = " + sku + "\n"
               +"Name = " + name + "\n"
               +"Manufacturer = "+manufacturer + "\n"
               +"Category = " +  category ;


    }

    @Override
    public boolean equals(Object o)
    {
        Product p = (Product) o;
        return (this ==o?true:(this.name.equalsIgnoreCase(p.getName())?true:false));
    }

    @Override
    public int compareTo(Product p)
    {

        if(equals(p))
        {
            return 0;
        }

       if( this.getCategory().compareTo(p.getCategory())<0)
       {
           return category.compareTo(p.getCategory())-1; // its not necessary to subtract 1 because if condition in the if statement is true the value to return is already <0
       }
       else
           return 1+this.category.compareTo(p.getCategory()); // we must add any constant to return a result >0 (because if the result of this.category.compareTo(p.getCategory()) is 0 then the desired behaviour is failed because we only want to return 0 when
        // the compared instances are the same in the heap memory
    }
}
