package ModelLayer;

public class Reciever extends Person{
	
	private String adress,rekvizit,info;
	
	public Reciever(String name,String adress,String rekvizit,String info){
		super(name);
		this.adress=adress;
		this.rekvizit=rekvizit;
		this.info=info;
	}
	
	public String getRekvizit() {
		return rekvizit;
	}

	public String getInfo() {
		return info;
	}

	public String getAdress() {
		return adress;
	}
}
