package model.objects;

public class ProductObject {

	private int id;
	private int tax;
	private String manufactor;
	private String description;
	private int price;
	private int notax;
	
	public ProductObject(int id, int tax, String manufactor, String description, int price, int notax) {
		this.setId(id);
		this.setTax(tax);
		this.setManufactor(manufactor);
		this.setDescription(description);
		this.setPrice(price);
		this.setNotax(notax);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTax() {
		return tax;
	}

	public void setTax(int tax) {
		this.tax = tax;
	}

	public String getManufactor() {
		return manufactor;
	}

	public void setManufactor(String manufactor) {
		this.manufactor = manufactor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNotax() {
		return notax;
	}

	public void setNotax(int notax) {
		this.notax = notax;
	}
}
