package ModelLayer;

public class Prices {
	
	public Double electricityRate, electricityStart, electricityEnd, waterRate, sewerageRate, waterStart, waterEnd;
	
	public Prices(Double electricityRate, Double electricityStart, Double waterRate, Double sewerageRate, Double waterStart){
		this.electricityRate = electricityRate;
		this.electricityStart = electricityStart;
		this.electricityEnd = electricityStart;
		this.waterRate = waterRate;
		this.sewerageRate = sewerageRate;
		this.waterStart = waterStart;
		this.waterEnd = waterStart;
	}
}
