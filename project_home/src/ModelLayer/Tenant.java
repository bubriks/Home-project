package ModelLayer;

public class Tenant extends Person{
	
	public double electricityStart, electricityEnd, waterStart, waterEnd, rent, heating, garbage, internet;
	
	public Tenant(String name, double electricityStart, double waterStart, double rent, double heating, double garbage, double internet){
		super(name);
		this.electricityStart = electricityStart;
		this.electricityEnd = electricityStart;
		this.waterStart = waterStart;
		this.waterEnd = waterStart;
		this.rent=rent;
		this.heating=heating;
		this.garbage=garbage;
		this.internet=internet;
	}
}
