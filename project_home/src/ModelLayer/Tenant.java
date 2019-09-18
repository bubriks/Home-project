package ModelLayer;

public class Tenant extends Person{
	
	public double electricity, water, rent, heating, garbage, internet;
	
	public Tenant(String name, double electricity, double water, double rent, double heating, double garbage, double internet){
		super(name);
		this.electricity = electricity;
		this.water = water;
		this.rent=rent;
		this.heating=heating;
		this.garbage=garbage;
		this.internet=internet;
	}
}
