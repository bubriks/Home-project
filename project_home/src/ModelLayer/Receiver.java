package ModelLayer;

public class Receiver extends BusinessPerson{
	public double electricityStart, electricityEnd;

	public Receiver(String name, String address, String invoice, String info, double electricityStart){
		super(name, address, invoice, info);
		this.electricityStart = electricityStart;
		this.electricityEnd = 0.0;
	}
}
