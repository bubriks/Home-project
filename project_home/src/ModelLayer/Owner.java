package ModelLayer;

public class Owner extends BusinessPerson{
	
	public String bankName,code;
	
	public Owner(String name, String address, String bankName, String code, String invoice, String info){
		super(name, address, invoice, info);
		this.bankName=bankName;
		this.code=code;
	}
}
