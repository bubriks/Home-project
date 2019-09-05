package ModelLayer;

public class Tenant extends Person{
	
	private double electricity, water, rent, heating, garbage, internet;
	
	public Tenant(String name, double electricity, double water, double rent, double heating, double garbage, double internet){
		super(name);
		this.electricity = electricity;
		this.water = water;
		this.rent=rent;
		this.heating=heating;
		this.garbage=garbage;
		this.internet=internet;
	}
	
	public double getElectricity() {
		return electricity;
	}
	public double getWater() {
		return water;
	}
	public double getRent() {
		return rent;
	}
	public double getHeating() {
		return heating;
	}
	public double getGarbage() {
		return garbage;
	}
	public double getInternet() {
		return internet;
	}
}
