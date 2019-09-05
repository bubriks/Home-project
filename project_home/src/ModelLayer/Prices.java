package ModelLayer;

public class Prices {
	
	private Double electricityRate, electricity, waterRate, sewerageRate, water;
	
	public Prices(Double electricityRate, Double electricity, Double waterRate, Double sewerageRate, Double water){
		this.electricityRate = electricityRate;
		this.electricity = electricity;
		this.waterRate = waterRate;
		this.sewerageRate = sewerageRate;
		this.water = water;
	}
	
	public Double getElectricityRate(){
		return electricityRate;
	}
	public Double getElectricity(){
		return electricity;
	}
	public Double getWaterRate(){
		return waterRate;
	}
	public Double getSewerageRate(){
		return sewerageRate;
	}
	public Double getWater(){
		return water;
	}
}
