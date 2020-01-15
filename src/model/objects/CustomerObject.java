package model.objects;

public class CustomerObject {

	private double id;
	private String name;
	private String address;
	private String country;
	
	public CustomerObject(double id, String name, String address, String country) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public double getId() {
		return id;
	}
	
}
