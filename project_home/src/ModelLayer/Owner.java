package ModelLayer;

public class Owner extends Person{
	
	private String adress,bankName,code,rekvizit,info;
	
	public Owner(String name,String adress,String bankName,String code,String rekvizit,String info){
		super(name);
		this.adress=adress;
		this.bankName=bankName;
		this.code=code;
		this.rekvizit=rekvizit;
		this.info=info;
	}
	
	public String getRekvizit() {
		return rekvizit;
	}

	public String getInfo() {
		return info;
	}

	public String getCode() {
		return code;
	}
	public String getAdress() {
		return adress;
	}

	public String getBankName() {
		return bankName;
	}
}
