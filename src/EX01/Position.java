package EX01;


public class Position {
	private double LAT,LON,ALT=0;
	public Position(String lat, String lon, String alt){
		LAT = Double.parseDouble(lat);
		LON = Double.parseDouble(lon);
		ALT = Double.parseDouble(alt);
	}

	public Position(Position other){
		this.LAT = other.getLAT();
		this.LON = other.getLON();
		this.ALT = other.getALT();
	}

	public double getLAT(){
		return this.LAT;
	}
	public double getLON(){
		return this.LON;
	}
	public double getALT(){
		return this.ALT;
	}

	public boolean equals(Position p1) {
		return(p1.getLAT()==this.getLAT()&&p1.getLON()==this.getLON()&&p1.getALT()==this.getALT());
	}


}



