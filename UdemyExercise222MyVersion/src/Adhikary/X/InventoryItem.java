package Adhikary.X;

public class InventoryItem {


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

    public Product getProcuct() {
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
        System.out.println("Added %d %s to the Inventory");
    }





}
