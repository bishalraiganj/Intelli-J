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

        return this ==o;
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
           return category.compareTo(p.getCategory())-1;
       }
       else
           return 1+this.category.compareTo(p.getCategory());
    }
}
