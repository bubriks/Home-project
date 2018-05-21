package ModelLayer;

public class Tenant extends Person{
	
	private double elLast,udLast,rent,heating,garbage,internet;
	
	public Tenant(String name,double elLast,double udLast,double rent,double heating,double garbage,double internet){
		super(name);
		this.elLast=elLast;
		this.udLast=udLast;
		this.rent=rent;
		this.heating=heating;
		this.garbage=garbage;
		this.internet=internet;
	}
	
	public double getElectricity() {
		return elLast;
	}
	
	public double getWater() {
		return udLast;
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
