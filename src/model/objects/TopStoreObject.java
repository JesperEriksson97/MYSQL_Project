package model.objects;

public class TopStoreObject {
	
	private String address;
	private int number_of_sales;
	
	public TopStoreObject(String address, int number_of_sales) {
		this.address = address;
		this.number_of_sales = number_of_sales;
	}

	public String getAddress() {
		return address;
	}

	public int getNumber_of_sales() {
		return number_of_sales;
	}
 
}
