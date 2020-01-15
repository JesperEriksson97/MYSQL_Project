package model.objects;

public class StoreObject {

	private int store_id;
	private String address;
	
	public StoreObject(int store_id, String address) {
		this.store_id = store_id;
		this.address = address;
	}

	public int getStore_id() {
		return store_id;
	}

	public String getAddress() {
		return address;
	}
}
