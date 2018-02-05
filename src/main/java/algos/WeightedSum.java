package main.java.algos;

import main.java.data_classes.Position;

public class WeightedSum {
	
	
	
	/**
	 * @author Amit Nuni, Bar Janach
	 * This class is being used in both algorithms.
	 * It calculates the weight of each position.
	 */

	private static Position p1,p2,p3;
	private static double w1,w2,w3;
	
	/**
	 * this function give each Position its weight and then sends it to calculate the recorder position.
	 * @param a
	 * @param b
	 * @param c
	 * @param pos1
	 * @param pos2
	 * @param pos3
	 * @return
	 */
	public static Position calcNewPos(double a,double b,double c,Position pos1,Position pos2,Position pos3){
		p1 = new Position(pos1);
		p2 = new Position(pos2);
		p3 = new Position(pos3);
		
		w1 = a;
		w2 = b;
		w3 = c;

	
		String Lat = Double.toString(p1.getLAT()*w1);
		String Lon = Double.toString(p1.getLON()*w1);
		String Alt = Double.toString(p1.getALT()*w1);
		p1 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(p2.getLAT()*w2);
		Lon = Double.toString(p2.getLON()*w2);
		Alt = Double.toString(p2.getALT()*w2);
		p2 = new Position(Lat,Lon,Alt);

		Lat = Double.toString(p3.getLAT()*w3);
		Lon = Double.toString(p3.getLON()*w3);
		Alt = Double.toString(p3.getALT()*w3);
		p3 = new Position(Lat,Lon,Alt);

		
		return calcPos();
	}


	/**
	 * this function returns the calculated position of the recorder by using the weight of each sample.
	 * @return
	 */
	private static Position calcPos(){
		double sumlat, sumlon, sumalt, sumw;

		sumlat = p1.getLAT()+p2.getLAT()+p3.getLAT();
		sumlon = p1.getLON()+p2.getLON()+p3.getLON();
		sumalt = p1.getALT()+p2.getALT()+p3.getALT();
		sumw = w1+w2+w3;
		String Lat = Double.toString(sumlat/sumw);
		String Lon = Double.toString(sumlon/sumw);
		String Alt = Double.toString(sumalt/sumw);
		
		Position pos = new Position(Lat,Lon,Alt); 
		
	
		return pos;

	}

}
