package model.objects;

public class SalesObject {

	private int sales_id;
	private String customer_name;
	private String product_name;
	private String store_address;
	private int quantity;
	private int total_price;
	
	public SalesObject(int sales_id, String customer_name, String product_name, String store_address, int quantity,  int total_price) {
		this.sales_id = sales_id;
		this.customer_name = customer_name;
		this.product_name = product_name;
		this.store_address = store_address;
		this.quantity = quantity;
		this.total_price = total_price;
	}

	public int getSales_id() {
		return sales_id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public String getProduct_name() {
		return product_name;
	}

	public String getStore_address() {
		return store_address;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getTotal_price() {
		return total_price;
	}
}
