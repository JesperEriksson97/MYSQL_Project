package model.objects;

public class ManufactorObject {

	int id;
	String name;
	
	public ManufactorObject(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
}
