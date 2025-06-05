package Adhikary.X;

public record Order(long orderId, Shoe shoeType, int quantity ) {


	@Override
	public String toString()
	{
		return "Order id: " + orderId + "  Type: " + shoeType + "  Quantity: x" + quantity;
	}



}
