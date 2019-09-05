package ModelLayer;

public class Owner extends Person{
	
	private String address,bankName,code,invoice,info;
	
	public Owner(String name, String address, String bankName, String code, String invoice, String info){
		super(name);
		this.address = address;
		this.bankName=bankName;
		this.code=code;
		this.invoice=invoice;
		this.info=info;
	}

	public String getAddress() {
		return address;
	}
	public String getBankName() {
		return bankName;
	}
	public String getCode() {
		return code;
	}
	public String GetInvoice() {
		return invoice;
	}
	public String getInfo() {
		return info;
	}
}
