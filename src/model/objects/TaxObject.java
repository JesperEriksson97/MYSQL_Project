package model.objects;

public class TaxObject {

	private int tax_id;
	private int rate;
	
	public TaxObject(int tax_id, int rate) {
		this.tax_id = tax_id;
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}

	public int getTax_id() {
		return tax_id;
	}
}
