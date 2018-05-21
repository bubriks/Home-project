package ModelLayer;

public class Prices {
	
	private Double elRate,elLast,udRate,kaRate,udLast;
	
	public Prices(Double elRate,Double elLast,Double udRate,Double kaRate,Double udLast){
		this.elRate=elRate;
		this.elLast=elLast;
		this.udRate=udRate;
		this.kaRate=kaRate;
		this.udLast=udLast;
	}
	
	public Double getElRate(){
		return elRate;
	}

	public Double getElLast(){
		return elLast;
	}
	
	public Double getUdRate(){
		return udRate;
	}
	
	public Double getKaRate(){
		return kaRate;
	}

	public Double getUdLast(){
		return udLast;
	}
}
