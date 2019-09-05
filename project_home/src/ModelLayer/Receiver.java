package ModelLayer;

public class Receiver extends Person{
	
	private String address, invoice, info;
	
	public Receiver(String name, String address, String invoice, String info){
		super(name);
		this.address = address;
		this.invoice = invoice;
		this.info=info;
	}
	
	public String getAddress() {
		return address;
	}
	public String getInvoice() {
		return invoice;
	}
	public String getInfo() {
		return info;
	}
}
