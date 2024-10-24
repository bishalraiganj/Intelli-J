package Adhikary.X;

public class InventoryItem implements Comparable<InventoryItem> {


    private Product product;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, int qtyTotal, int qtyReserved, int qtyReorder, int qtyLow, double salesPrice) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.qtyReserved = qtyReserved;
        this.qtyReorder = qtyReorder;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;

    }

    public Product getProduct() {
        return product;
    }

    public int getQtyTotal() {
        return qtyTotal;
    }

    public int getQtyReserved() {
        return qtyReserved;
    }

    public int getQtyReorder() {
        return qtyReorder;
    }

    public int getQtyLow() {
        return qtyLow;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public void setQtyReserved(int qtyReserved)
    {
        this.qtyReserved = qtyReserved;
    }


    public void reserveItem(int qty) {

        qtyReserved += qty;

    }

    public void releaseItem(int qty) {

        qtyReserved -= qty;
    }

    public void sellItem(int qty)
    {
        System.out.printf("Sold  %d  %s",qty,product.getName());
        qtyTotal -= qty;
    }

    public void placeInventoryItem(int qty)
    {
        qtyTotal +=qty;
        System.out.printf("Added %d %s to the Inventory, because low triggered / low threshold reached",qty,this.product.getName());
    }

//    @Override
//    public boolean equals(Object o)
//    {
//        if(this.product.getName()=)
//    }


    @Override
    public boolean equals(Object o)
    {
        return this.product.equals(((InventoryItem) o).getProduct());
    }
    @Override
    public String toString()
    {

       return  "Name = "+this.product.getName()+"\n"
               +"Stock = "+this.qtyTotal+"\n"
               +"Sales Price = "+this.salesPrice+"\n"
               +"Reserved Stock = "+this.qtyReserved+"\n"
               +"Reorder Quantity = "+this.qtyReorder+"\n"
               +"Quantity of Low Trigger/Threshold = "+this.qtyLow+"\n";

    }

    @Override
    public int compareTo(InventoryItem o)
    {
        return this.product.getCategory().compareTo(o.getProduct().getCategory());
    }

}
