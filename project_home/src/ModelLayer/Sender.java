package ModelLayer;

public class Sender extends BusinessPerson{
	
	public String bankName,code;
	
	public Sender(String name, String address, String bankName, String code, String invoice, String info){
		super(name, address, invoice, info);
		this.bankName=bankName;
		this.code=code;
	}
}
